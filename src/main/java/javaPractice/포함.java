package javaPractice;

public class 포함 {
    public static void main(String[] args) {
        
        // 포함(composite)
        // 클래스의 멤버로 참조변수를 선언하는 것
        // 작은 단위으 클래스를 만들고, 이 들을 조합해서 클래스를 만든다.

        // 상속 관계 : ~은 ~이다.(is-a)
        // 포함관계 : ~은 ~을 가지고 있다.(has-a)
        // 90% 이상이 포함관계... 상속은 꼭 필요할 때만!
        // 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 한다.

        System.out.println("classpath");
    }
}

class Tv {
    boolean power;
    int channel;

    void power() {
        power = !power;
    }
    void channelUp() {
        ++channel;
    }
    void channelDown() {
        --channel;
    }
}

class DVD {
    boolean power;

    void power() {
        power = !power;
    }
    void play() {

    }
    void stop() {

    }
    void rew() {

    }
    void ff() {

    }
}

// 비중이 높은 클래스 하나만 상속관계로, 나머지는 포함관계로 한다.
class TvDVD extends Tv {
    DVD dvd = new DVD();

    void play() {
        dvd.play();
    }
    void stop() {
        dvd.stop();
    }
    void rew() {
        dvd.rew();
    }
    void ff() {
        dvd.ff();
    }
}
