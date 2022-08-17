package javaPractice;

import java.util.Optional;

public class OptionalEx {
    public static void main(String[] args) {

        // Optional을 통해 NullPointerException을 발생할 수 있는 가능성이 없어지고
        // if문으로 null 체크를 하던 코드가 간결해진다.

        String str = "abc";
        Optional<String> optVal = Optional.of(str);
        Optional<String> optVal2 = Optional.of("abc");
        // Optional<String> optVal3 = Optional.of(null);
        Optional<String> optVal4 = Optional.ofNullable(null);

        Optional<String> optVal5 = Optional.<String>empty();

        String str1 = optVal.get();                                       // optVal에 저장된 값을 반환. null이면 예외발생
        String str2 = optVal.orElse("");                            // optVal에 저장된 값이 null일 때는, ""을 반환
        String str3 = optVal.orElseGet(String::new);                        // 람다식 사용가능 () -> new String()
        String str4 = optVal.orElseThrow(NullPointerException::new);        // 널이면 예외 발생

        // str      => 0x100
        // optval   => 0x200 => 0x100 => "abc"

        // int[] arr = null;
        int[] arr = new int[0];
        System.out.println("arr.length : " + arr.length);

        // Optional<String> opt = null; // OK. 하지만 바람직X
        Optional<String> opt = Optional.empty();
        System.out.println("opt : " + opt);

        String str7 = "";
        str7 = opt.orElse("str : " + str7);
    }
}
