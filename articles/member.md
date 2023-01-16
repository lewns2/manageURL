## 공통 엔티티 및 회원 도메인 구현

### BaseEntity 구현

객체들이 주로 사용되는 공통 매핑 정보를 정의한다.

JPA
@MappedSuperclass
부모 클래스는 테이블과 매핑하지 않고, 상속받는 자식 클래스에게 매핑 정보만 제공하고 싶을때 사용한다.
실제 테이블과 매핑되지 않고, 단순히 매핑 정보를 상속할 목적으로만 사용된다.
클래스를 직접 생성해서 사용할 일은 거의 없으므로, 추상 클래스로 만드는 것을 권장한다.

JAVA
직렬화 Serializable
객체 데이터를 바이트(Byte) 형태로 변환하는 것을 말한다.
자바에서 직렬화를 위해선 java.io 패키지의 Serializable 인터페이스를 implements 한다.
직렬화 대상은 필드(멤버 변수)만 가능하며, 생성자와 메서드는 대상에 포함되지 않는다.

사용 이유 : JVM의 메모리에만 상주되어있는 객체 데이터를 영속화(Persistence)하기 위함.
시스템이 종료되더라도 없어지지 않는 장점을 가지며 영속화된 데이터이기 때문에 네트워크로 전송 가능하다.

스프링 JPA에서 엔티티(Dto 클래스)는 Serializable를 구현한다.
JPA Entity를 생성하면 기본값으로 implements Serializable를 구현한다. 이러한 이유는 외부로 전송할 있는 가능성을 열어두기 위함이라고 한다.

extends vs implements
extends는 일반 클래스와 추상 클래스 상속에 사용되고, implement는 interface 상속에 사용된다.
즉, extends는 클래스를 확장하는 것을 의미하며 implements는 인터페이스의 구현을 의미한다.
인터페이스는 정의한 메소드를 직접 구현하지 않아도 되고, 상속받는 클래스에서 인터페이스에 정의된 메소드를 구현하면 된다.

참고. 자바에서는 C++와 달리 다중상속을 지원하지 않아, 그 대안으로 인터페이스를 제공한다.

### 회원 도메인 구현

요구사항

- 이메일과 비밀번호를 통해 회원 가입할 수 있다.
- 사용자와 관리자로 나누어 관리한다.
- (미확정)회원 데이터의 DB는 아직 미정이다.

(ER 모델)

()

마주친 문제들

상황 1. Jpa 리포지터리로 변경하기
기존 임시 저장소(MemoryMemberRepository)에서 Jpa 저장소(JpaMemberRepository)로 변경

에러 : 테스트 시, 리포지터리 빈 생성 에러 발생

> Error creating bean with name 'memberRepository': Injection of persistence dependencies failed; nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'javax.persistence.EntityManagerFactory' available

세부 내용

```java
@PersistenceContext
private Entitiymanager em;
```

예상 문제점

1. 엔티티 매니저 사용을 위한 `main/resources/META_INF/persistence.xml` 미작성
2. Confiuration을 통한 수동 주입과 자동 주입(엔티티, 서비스, 리포지터리 애노테이션 등)의 혼용

해결
테스트 코드 작성 시, ApplicationContext을 통해 클래시를 호출하는 대신 @Autowired를 통해 주입하니 해결

기존 호출 방식

```Java
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MemberConfig.class);

MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
MemberRepository memberRepository = applicationContext.getBean("memberRepository", MemberRepository.class);
```

해결 호출 방식

```Java
@Autowired
private MemberService memberService;

@Autowired
private MemberRepository memberRepository;

```

에러 : No EntityManager with actual transaction available for current thread
해결 : @Transactional 애노테이션
해설 : JPA는 기본적으로 transaction 기반으로 작동한다. transaction 단위에 따라 1차 캐시영역에 있는 객체들이 db에 flush되어 영속화되기 때문이다. 하지만 영속작업을 하는 persist() 메소드에 객체가 들어갔으나 가능한 transaction이 존재하지 않아 에러 발생

에러 : detached entity passed to perist
해결 : 기존 멤버 엔티티의 생성자 매개 변수를 수정해주었다.
해설 : 기존 메모리에선 기본키를 직접 넣었으나, 작성된 기본키 전략에 따라 자동으로 주입되지만 테스트 시 직접 기본키를 입력하였기에 생긴 오류

에러 : No default constructor for entity
해결 : 기본 생성자 생성
해설 : JPA에는 기본 생성자가 필요하다. 그래서 이를 위해 롬복의 @NoArgsConstructor, @AllArgsConstructor을 사용한다. 하지만 나의 경우, 직접 새로운 빈 생성자를 만들어주었다.
이러면 생성자가 2개가 된 셈인데, 이를 어떻게 해결해야 할 지 의문이다.

고민

- 의존성을 낮춘다. 서비스에서 리포지터리 구현체가 아닌 인터페이스에만 접근하는 법?
- 스프링 빈 등록 방법 : @Bean vs @Component + @Autowired?
- JPA를 사용하며 기존 생성자와 JPA를 위한 생성자 2개가 되었는 데 어떻게 해결?
  - 방법 1. 기존 생성자 삭제 -> Member 생성을 set()으로 한다.
- 테스트 시, id를 통해 꺼내 확인하는 테스트는 어려운 거 같다. 기본키를 직접 제어하는 것이 아니니 계속해서 만들어지는 id를 알 방법이 없다. 다른 테스트 방법은?
