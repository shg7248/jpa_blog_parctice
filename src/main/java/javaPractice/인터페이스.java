package javaPractice;

public class 인터페이스 {
    public static void main(String[] args) {

        // 인터페이스 (interface)
        // 추상 메서드의 집합
        // 구현된 것이 전혀 없는 설계도. 껍데기 (모든 멤버가 public)
        // 추상클래스 : 일반 클래스인데 추상 메서드를 가지고 있음 (일부 미완성)
        // 인터페이스 : 추상 메서드만 가지고 있음 (아무것도 완성된게 없음)

        // 인터페이스의 조상은 인터페이스만 가능 (Object가 최고 조상이 아님)
        // 다중 상속이 가능 (추상메서드는 충돌해도 문제 없음) interface Fightable extends Movable, Attackable { }
        // 선언부가 다르면 둘다 상속 받으면 그만인데, 선언부가 같고 내용{}이 다르면 어느쪽을 상속받을지 결정할 수 없다.
        // 몸통이 없기 때문에 둘 다 상속 받아도 아무런 문제가 없다.

        // 일부만 구현하는 경우, 클래스 앞에 abstract를 붙여야 함. (추상 클래스를 만드는 것과 동일)

        // 두 대상(객체) 간의 '연결, 대화, 소통'을 돕는 '중간 역할'을 한다.
        // 선언(설계)와 구현을 분리시킬 수 있게 한다.
        // 인터페이스 덕분에 B가 변경되다 A는 안바꿀 수 있게 된다. (느슨한 결합)

        // 장점
        // 개발 시간을 단축할 수 있다.
        // 변경에 유리한 유연한 설계가 가능하다.
        // 표준화가 가능하다.
        // 서로 관계없는 클래스들의 관계를 맺어줄 수 있다.

        A a = new A();
        a.method(new B());
    }
}

interface I {
    void method();
}

class B implements I {

    @Override
    public void method() {
        System.out.println("B클래스의 메서드");
    }
}

class A {
    public void method(I i) {
        i.method();
    }
}


