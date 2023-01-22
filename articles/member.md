## 공통 엔티티 및 회원 도메인 구현

### BaseEntity 구현

객체들이 주로 사용되는 공통 매핑 정보를 정의한다.

### 회원 도메인 구현

요구사항

- 이메일과 비밀번호를 통해 회원 가입할 수 있다.
- 사용자와 관리자로 나누어 관리한다.
- (미확정)회원 데이터의 DB는 아직 미정이다.

### 마주친 어려움들

**상황 1. Jpa 리포지터리로 변경하기** <br>
기존 임시 저장소(MemoryMemberRepository)에서 Jpa 저장소(JpaMemberRepository)로 변경한다. <br>

에러 : 테스트 시, 리포지터리 빈 생성 에러 발생 <br>

> Error creating bean with name 'memberRepository': Injection of persistence dependencies failed; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'javax.persistence.EntityManagerFactory' available

세부 구현 사항 : `@PersistenceContext`을 통한 엔티티 매니저 호출

```java
@PersistenceContext
private Entitiymanager em;
```

예상 문제점 (23/01/15)

1. 엔티티 매니저 사용을 위한 `main/resources/META_INF/persistence.xml` 미작성
2. Confiuration을 통한 수동 주입과 자동 주입(엔티티, 서비스, 리포지터리 애노테이션 등)의 혼용

해결 (23/01/17) <br>
테스트 코드 작성 시, ApplicationContext을 통해 클래스를 호출하는 대신 @Autowired를 통해 스프링 빈을 호출하여 사용.

기존 테스트 코드 <br>

```Java
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MemberConfig.class);

MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
MemberRepository memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);
```

해결 테스트 코드 <br>

```Java
@Autowired
private MemberService memberService;

@Autowired
private MemberRepository memberRepository;

```

**상황 2. Jpa 리포지터리로 변경하기** <br>

에러 : 트랜잭션 오류 <br>

> No EntityManager with actual transaction available for current thread

해결 <br>

사용하고자 하는 서비스 구현체에 @Transactional 애노테이션 작성하기 <br>
JPA는 기본적으로 transaction 기반으로 작동한다. <br>
transaction 단위에 따라 1차 캐시영역에 있는 객체들이 db에 flush되어 영속화되기 때문이다. 하지만 영속작업을 하는 persist() 메소드에 객체가 들어갔으나 가능한 transaction이 존재하지 않아 에러 발생

에러 : 엔티티 설계와 테스트 상의 차이 문제 <br>

> detached entity passed to perist

해결 : 기존 Member 엔티티의 생성자 매개 변수를 수정해주었다. <br>
변경 전 리포지터리인 메모리에서는 기본키를 직접 할당했으나, Jpa 리포지터리는 작성한 기본키 전략에 따라 자동으로 주입된다. 따라서 테스트 시, 직접 기본키를 할당하였기에 발생하였다.

에러 : Jpa 사용을 위한 기본 생성자 누락 <br>

> No default constructor for entity

해결 : 기본 생성자 생성
JPA에는 기본 생성자가 필요하다. 그래서 이를 위해 롬복의 @NoArgsConstructor, @AllArgsConstructor을 사용한다. <br>
하지만 나의 경우, 엔티티에 새로운 (비어있는) 생성자를 만들어주었다. <br>
<span style="color:gray">이러면 생성자가 2개가 된 셈인데, 이를 어떻게 해결해야 할 지 의문이다. </span><br>

### 고민

- 의존성을 낮춘다. 서비스에서 리포지터리 구현체가 아닌 인터페이스에만 접근하는 법?
- 스프링 빈 등록/활용 방법 : @Bean vs @Component + @Autowired?
- JPA를 사용하며 기존 생성자와 JPA를 위한 생성자 2개가 되었는 데 어떻게 해결?
  - 방법 1. 기존 생성자 삭제 -> Member 생성을 set()으로 한다.
- 테스트 시, id를 통해 꺼내 확인하는 테스트는 어려운 거 같다. 기본키를 직접 제어하는 것이 아니니 계속해서 만들어지는 id를 알 방법이 없다. 다른 테스트 방법은?
  1. doSignUp 메서드가 id를 리턴하게 만든다. 근데 이건 테스트 코드만을 위한 코드 수정이 아닌가?또, 리포지터리, 서비스 모두 수정해야한다.
  2. 리포지터리에 직접 등록하고 리포지터리의 save만 id를 리턴하게 만든다. 이것도 마찬가지로 테스트 코드만을 위한 코드 수정같은데. 또, 이러면 서비스(doSignUp)를 테스트하는 것이 아니게 된다.
  3. 테스트 전, 데이터베이스를 리셋시키는 코드를 추가한다. -> 그럼 실제 DB와 테스트 DB가 분리되어야먼 한다. 실제 회원들이 날아가면 안되니깐
  4. 테스트 시, 넣었다가 롤백시키는 방법.
  5. id가 아닌 다른 값을 통해 찾더라도, Member 객체끼리 비교는 항상 실패한다. 로그를 보니 데이터를 불러올때마다 참조값이 매번 달라진다. (Member@xxx : xxx의 값이 매번 바뀐다.) 왜그럴까?

---

#### JPA

`@MappedSuperclass` <br>
부모 클래스는 테이블과 매핑하지 않고, 상속받는 자식 클래스에게 매핑 정보만 제공하고 싶을때 사용한다. <br>
실제 테이블과 매핑되지 않고, 단순히 매핑 정보를 상속할 목적으로만 사용된다. <br>
클래스를 직접 생성해서 사용할 일은 거의 없으므로, 추상 클래스로 만드는 것을 권장한다. <br>

#### JAVA

`직렬화 Serializable` <br>
객체 데이터를 바이트(Byte) 형태로 변환하는 것을 말한다. <br>
자바에서 직렬화를 위해선 java.io 패키지의 Serializable 인터페이스를 implements 한다. <br>
직렬화 대상은 필드(멤버 변수)만 가능하며, 생성자와 메서드는 대상에 포함되지 않는다. <br>

**사용 이유** <br>
JVM의 메모리에만 상주되어있는 객체 데이터를 영속화(Persistence)하기 위함. <br>
시스템이 종료되더라도 없어지지 않는 장점을 가지며 영속화된 데이터이기 때문에 네트워크로 전송 가능하다. <br>

스프링 JPA에서 엔티티(Dto 클래스)는 Serializable를 구현한다. <br>
JPA Entity를 생성하면 기본값으로 implements Serializable를 구현한다. 이러한 이유는 외부로 전송할 있는 가능성을 열어두기 위함이라고 한다.

`extends vs implements` <br>
extends는 일반 클래스와 추상 클래스 상속에 사용되고, implement는 interface 상속에 사용된다. <br>
즉, extends는 클래스를 확장하는 것을 의미하며 implements는 인터페이스의 구현을 의미한다. <br>
인터페이스는 정의한 메소드를 직접 구현하지 않아도 되고, 상속받는 클래스에서 인터페이스에 정의된 메소드를 구현하면 된다.

참고) 자바에서는 C++와 달리 다중상속을 지원하지 않아, 그 대안으로 인터페이스를 제공한다.
