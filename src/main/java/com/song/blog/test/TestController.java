package com.song.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/songTest")
    public String getSongTest() {
        return "Test";
    }
}
