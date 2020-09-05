package com.heesup.webservice.web;

import com.heesup.webservice.domain.posts.PostsRepository;
import com.heesup.webservice.dto.posts.PostsSaveRequestDto;
import com.heesup.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor//Autowired로 주입받지 않고 생성자를 통하여 주입을 받음(권장)
public class WebRestController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
}
