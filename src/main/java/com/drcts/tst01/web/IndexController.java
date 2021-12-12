package com.drcts.tst01.web;


import com.drcts.tst01.service.PostsService;
import com.drcts.tst01.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    //    @Autowired
    //    PostsService postsService;

    // 롬복의 @RequiredArgsConstructor 어노테이션으로 서비스빈 final으로 선언된 인스턴스 생성
    private final PostsService postsService;


    @GetMapping("/")
    public String index(Model model){

        List<PostsResponseDto> lst = postsService.findAllDesc();
        model.addAttribute("posts", lst);
        return "index";
    }

    /*등록페이지*/
    @GetMapping("/posts/save")
    public String posts_save(){

        return "posts_save";
    }

    /*수정페이지*/
    @GetMapping("/posts/update/{id}")
    public String posts_update(@PathVariable Long id, Model model){

        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts_update";
    }




}
