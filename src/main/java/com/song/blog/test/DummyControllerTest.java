package com.song.blog.test;

import com.song.blog.model.MyUser;
import com.song.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입(DI)
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{id}")
    public String delete(@PathVariable int id) {
        try{
            userRepository.deleteById(id);
        } catch(Exception e) {
            e.printStackTrace();
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
        }
        return "삭제되었습니다. id : " + id;
    }

    // save 함수는 id를 전달하지 않으면 insert를 해주고
    // save 함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고
    // save 함수는 id를 전달하면 해당 id에 대한 데이터가 없으면 insert를 해요.
    @Transactional // 함수 종료시에 자동 commit 이 됨.
    @PutMapping("/dummy/user/{id}")
    public MyUser updateUser(@PathVariable int id, @RequestBody MyUser requestUser) {

        MyUser user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("수정에 실패했습니다.")); // 이 때 영속화가 됨
        
        // 영속화된 객체와 비교를 해서 변경이 되었으면 영속화 된 객체에 집어넣고 flush를 통해 DB에 업데이트를 함
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

        // userRepository.save(user);

        // 더티 체킹
        return user;
    }
    
    // 영속성 컨텍스트
    // 객체가 1차 캐시에 영속화가 되어 있으면 DB에 접근하지 않고 그 객체를 바로 들고 온다.
    // flush

    // http://localhost:8080/blog/dumy/user
    @GetMapping("/dummy/users")
    public List<MyUser> list() {
        return userRepository.findAll();
    }

    // 한페이지당 2건의 데이터를 리턴받아 볼 예정
    @GetMapping("/dummy/user")
    public Page<MyUser> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC, page = 10) Pageable pageable) {
        Page<MyUser> users = userRepository.findAll(pageable);
        return users;
    }

    @GetMapping("/dummy/user/{id}" )
    public MyUser detail(@PathVariable int id) {
        // user/4를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될 것 아냐?
        // 그럼 return null이 리턴이 되자나 ... 그럼 프로그램에 문제가 있지 않겠니?
        // Optional로 너의 User 객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return해!!
        
        // 람다식
        MyUser user = userRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 사용자는 없습니다."));
    
        // 요청 : 웹브라우저
        // user객체 = 자바 오브젝트
        // 변환 (웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
        // 스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
        // 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
        // user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
        return user;
    }

    // http의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("dummy/join")
    public String join(MyUser user) {

        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
