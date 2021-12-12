package com.drcts.tst01.web.dto;


import com.drcts.tst01.domain.Posts;
import lombok.Getter;


@Getter
public class PostsResponseDto {

    private Long id ;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
