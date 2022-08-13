package com.song.blog.test;

import org.springframework.web.bind.annotation.*;

// 사용자가 요청 -> 응답(data)
@RestController
public class HttpControllerTest {

    // 인터넷 브라우저 요청은 무조건 get요청밖에 할 수 없다.
    @GetMapping("/http/get")
    public String getTest(MemberBean mem) {
        return "get 요청 : " + mem.getId() + ", " + mem.getUsername();
    }

    // post는 url이 아닌 body란 곳에 담긴다.
    // post는 평문을 @RequestBody로 받는다.
    @PostMapping("/http/post")
    public String postTest(@RequestBody MemberBean mem) { // MessageConverter (스프링 부트)
        return "post 요청 : " + mem.getId() + ", " + mem.getUsername();
    }

    @PutMapping("/http/put")
    public String putTest() {
        return "put 요청";
    }

    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
