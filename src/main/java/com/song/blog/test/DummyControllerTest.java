package com.song.blog.test;

import com.song.blog.model.MyUser;
import com.song.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입(DI)
    private UserRepository userRepository;

    @GetMapping("/dummy/user/{id}" )
    public MyUser detail(@PathVariable int id) {
        // user/4를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될 것 아냐?
        // 그럼 return null이 리턴이 되자나 ... 그럼 프로그램에 문제가 있지 않겠니?
        // Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해!!
        
        // 람다식
        MyUser user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자는 없습니다."));

        return user;
    }

    // http의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("dummy/join")
    public String join(MyUser user) {

        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
