## 싱글톤 패턴
 - 인스턴스를 오직 하나만 제공하는 클래스
 - 시스템 런타임, 환경 셋팅에 대한 정보들, 인스턴스가 여러개일 때 문제가 생길 수 있는 경우가 있다.
 - "인스턴스를 오직 한개만" 만들어 제공하는 클래스가 필요하다.

### private 생성자에 static 메소드
new를 사용해서 인스턴스를 만들게 허용하면 싱글톤 패턴을 만족시킬 수 없다.
 - private 생성자를 만들어서 해당 클래스 안에서만 접근할 수 있게 하면 클래스 밖에서는 new를 사용하여 인스턴스를 생성할 수 없다.
 - private 생성자를 global access가 가능하게 하려면 static으로 선언해야한다.
 - 멀티쓰레드 환경에서 이 방법은 안전하지 않다. (thread safe 하지 않다.)
   - 왜? if(instance == null) 안에 여러개의 스레드가 한번에 들어온다면 각각 인스턴스를 생성하여 "오직 한개만" 제공하는데 실패한다.

### 멀티쓰레드 환경에서 안전하게 만드는 방법
- 동기화(synchronized)를 사용해서 한 스레드만 접근 가능하도록 하는 방법 
  - 동기화 메커니즘이 lock을 잡아서 lock을 가지고 있는 스레드만 접근할 수 있게 하고 다 쓰면 lock을 해제하는 등 성능 부하가 생길 수 있다.
- 이른 초기화(eager initialization) 사용하기
  - private static final Settings INSTANCE = new Settings();
  - 미리 만들어두고 안쓰는 경우에는 단점이 될 수 있다.
- double checked locking 으로 효율적 동기화 블럭 만들기
  - getInstance() 메서드를 호출할때마다 synchronized가 매번 걸리지 않는다.
  - 동시에 if문 안에 들어갔을때만 동기화 처리를 하기 떄문에 성능에 유리하다.
  - 인스턴스를 필요로 하는 시점에 만들 수 있다. (이른초기화의 단점 개선)
  - volatile를 추가하여 instance 변수를 정의해야햔다.
- static inner 클래스를 사용하는 방법도 있음
  - getInstance()가 호출될 때 SettingsHolder inner Class가 로딩되고 그떄 인스턴스를 만들기 떄문에 lazy loading(지연 초기화)가 가능해진다.