package javaPractice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Comparator;
import java.util.Optional;
import java.util.function.Supplier;

public class 람다식 {
    public static void main(String[] args) {

        // 람다식(Lambda Expression)
        // 함수(메서드)를 간단한 식으로 표현하는 방법
        // 익명 함수(이름이 없는 함수, anonymouse function)
        // 함수와 메서드의 차이
            // 근본적으로 동일. 함수는 일반적 용어, 메서드는 객체지향개념 용어
            // 함수는 클래스에 독립적, 메서드는 클래스에 종속적

        // 람다식은 익명 함수가 아니라 익명 객체이다.

//      Object obj = (a, b) -> a > b ? a : b;
        Object obj = new Object() {
            int max(int a, int b) {
                return a > b ? a : b;
            }
        };

        // Object에는 max라는 함수가 없어서 에러
        // int value = obj.max(3, 5); // 함수형 인터페이스가 필요함



//        MyFunction f = new MyFunction() {
//            @Override
//            public int max(int a, int b) { // 오버라이딩 - 접근제어자는 좁게 못바꾼다.
//                return a > b ? a : b;
//            }
//        };

         MyFunction f = (a, b) -> a > b ? a : b;

         int value = f.max(3, 5);
        System.out.println("value = " + value);

        Comparator c = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };




    }

    int max(int a, int b) {
        return a > b ? a : b;
    }


}
@FunctionalInterface
interface MyFunction { // 함수형 인터페이스는 단 하나의 추상 메서드만 가져야 함.
    public abstract int max(int a, int b);
}
