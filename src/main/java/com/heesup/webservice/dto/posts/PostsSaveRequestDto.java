package com.heesup.webservice.dto.posts;

import com.heesup.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//설계를 할 때 주의할 점
//Entity 클래스를 Request/Response 클래스로 사용하면 안됨(가장 Core한 클래스)
//(중요)Entity 클래스와 Controller에서 쓸 DTO는 분리
//여러 테이블join등 Entity로만 표현하기 어려운 것들이 있기 떄문
@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    public Posts toEntity(){
        //빌더 클래스 이용
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
