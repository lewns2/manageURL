## 게시판 기능 구현

### 게시글 저장

회원 저장과 동일한 구현.

### 회원 Id를 통한 게시글 조회

서비스 : Collection을 리턴 <br>
리포지터리 : List를 리턴 <br>

```java
// 서비스 인터페이스

Collection<Board> findBoardByMemberId(Long memberId);
```

<br>

```java
// 서비스 구현체

@Override
@Transactional
public Collection<Board> findBoardByMemberId(Long memberId) {
    return boardRepository.findByMemberId(memberId);
}
```

<br>

```java
// 리포지토리 인터페이스

List<Board> findByMemberId(Long memberId);
```

직접 쿼리를 작성한다. <br>

```java
// 리포지토리 JPA 구현체

@Override
public List<Board> findByMemberId(Long memberId) {
		Query query = this.em.createQuery("SELECT b FROM Board b where b.member.id= :id");
		query.setParameter("id", memberId);
		return query.getResultList();
}
```

왜 이렇게 작성했을까? <br>

List 자료구조만 사용할 것이라면 서비스에서도 Collection 대신 List를 리턴해도 되겠지만, 만약 속도 개선을 위해 HashSet을 바꿔야하는 경우가 발생할 수 있으니 이에 가능성을 열어둔 것이 아닐까. <br>

List 대신 Set을 사용하고 싶다면, 리포지터리만 변경하면 되니깐. <br>

### 게시글 삭제

```Java
// 리포지터리 JPA 구현체

@Override
public void delete(Board board) {
    String boardId = board.getId().toString();
    this.em.createQuery("DELETE FROM Board board WHERE id=" + boardId).executeUpdate();
    if(em.contains(board)) {
        em.remove(board);
    }
}
```

<br>

에러 1. if문 없이 바로 em.remove(board) 시, `java.lang.IllegalArgumentException: Removing a detached instance` 발생 <br>

- 영속성 컨텍스트에 대한 학습 (영속성 컨텍스트에 없는 경우(분리된 경우), 에러가 발생한 것)
- em.remove()의 동작 과정
  - 삭제 대상 엔티티를 넘겨주면 엔티티를 삭제한다.
  - 엔티티를 즉시 삭제하지는 않는다.
  - 쓰기 지연 SQL 저장소에 등록된 뒤, 트랜잭셩을 커밋하여 플러시를 호출할 때 실제 삭제 쿼리가 전달된다.

에러 2. excuteUpdate() 미작성 시, 글이 삭제되지 않음. <br>

### 게시글 Id를 통한 해당 게시글 조회

```Java
// 리포지터리 JPA 구현체

@Override
public Board findById(Long boardId) {
    return this.em.find(Board.class, boardId);
}
```

<br>

### JPA와 EntitiyManager
