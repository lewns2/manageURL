## 에러와 생각 한눈에 정리하기

- 스프링 빈을 등록하고 사용하기 위한 좋은 방법은 무엇인지?
- JPA 리포지터리로 변경하며 발생한 문제들

  - JPA를 사용하며 생성자가 2개가 되었다. 이대로 괜찮은지?
  - JPA와 트랜잭션에 대한 개념의 부족(remove()를 해도 삭제가 안되는 문제 등)
  - 기존 테스트 코드에서 에러가 발생하는 이유? 정확히는 빈이 생성되지 않는 문제.
  - 기본 키 전략이 'IDENTITIY'일 때, 올바르게 테스트하는 방법? (DB를 직접 들어가봐야 id를 알 수 있는 문제)

- JPA 양방향 매핑 시, @JoinColumn과 mappedBy 속성의 차이

- spring-petClinic 코드에 대한 생각
  - 여러 개의 객체를 받는 경우(조회), 서비스는 'Collection'을 리포지터리에는 'List'를 사용한 이유?