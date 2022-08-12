package com.song.blog.test;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyControllerTest {

    // http의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("dummy/join")
    public String join(String username, String password, String email) {

        System.out.println("username : " + username);

        return "회원가입이 완료되었습니다.";
    }
}
