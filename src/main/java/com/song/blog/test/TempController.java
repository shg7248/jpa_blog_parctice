package com.song.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempController {

    @GetMapping("temp/home")
    public String tempHome() {
        System.out.println("temp/home");
        // 파일리턴 기본경로: src/main/resources/static
        return "home";
    }
}
