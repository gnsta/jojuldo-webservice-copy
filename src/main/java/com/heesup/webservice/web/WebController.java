package com.heesup.webservice.web;

import com.heesup.webservice.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;

    /*
     *handlebars-spring-boot-starter를 추가
     *prefix: src/main/resources/templates, suffix: .hbs
     */
    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }
}
