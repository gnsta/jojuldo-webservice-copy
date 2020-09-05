package com.heesup.webservice.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
       /*
        * 테스트를 수행 할 떄마다 테이블을 비워줌
        */
        postsRepository.deleteAll();
    }

    @Test
    public void callPosts() {
        //given
        //데이터를 저장
        //빌터 클래스 이용하여 명시적으로 데이터를 저장
        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("gilmat@naver.com")
                .build());

        //when
        //데이터를 가져옴
        List<Posts> postsList = postsRepository.findAll();

        //then
        //데이터에 대한 수행문
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트 게시글"));
        assertThat(posts.getContent(), is("테스트 본문"));
    }

    //Jpa Auditing 테스트
    @Test
    public void BaseTimeEntityRegister(){
        //given
        //현재 시간을 받아옴
        LocalDateTime now = LocalDateTime.now();

        postsRepository.save(Posts.builder()
                .title("테스트 게시글")
                .content("테스트 본문")
                .author("jojoldu@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertTrue(posts.getCreatedDate().isAfter(now));
        assertTrue(posts.getModifiedDate().isAfter(now));

    }
}