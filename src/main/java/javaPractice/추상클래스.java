package javaPractice;

public class 추상클래스 {
    public static void main(String[] args) {
        
        // 추상 클래스(abstract class)
        // 미완성 설계도. 미완성 메서드를 갖고 있는 클래스
        // 구현부가 없는 메서드
    }
}

abstract class Player {
    boolean pause;
    int currentPos;

    Player() {
        pause = false;
        currentPos = 0;
    }
    abstract void play(int pos);    // 대충 몸통 만들어 놓고 오버라이딩 하면 안되나요?
                                    // 이건 필수적이고 중요한 거니깐 너희들이 만들어 주도록 해!
                                    // 개발자들에게 [니 클래스에 맞도록 몸통을 구현해라] 라는 강제성을 줄 수 있음

    abstract void stop();

    void play() {
        play(currentPos); // 상속을 통해 자손이 완성되면 호출이 가능하기 때문에
    }
}
