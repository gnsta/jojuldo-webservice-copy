package com.heesup.webservice.dto;

import com.heesup.webservice.domain.posts.Posts;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostsMainResponseDto {
    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostsMainResponseDto(Posts entity) {
        id = entity.getId();
        title = entity.getTitle();
        author = entity.getAuthor();
        modifiedDate = toStringDateTime(entity.getModifiedDate());//date를 String으로 변환
    }

    /**
     * Date format
     */
    //중요!
    //DTO는 Entity를 사용해도 되지만, Entity는 DTO에 대해 전혀 모르게 코드를 구성
    //Entity는 말 그대로 가장 core한 클래스인 반면, DTO는 View 혹은 외부 요청에 관련 있는 클래스
    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
