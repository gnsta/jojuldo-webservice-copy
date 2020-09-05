package com.heesup.webservice.domain.posts;

import com.heesup.webservice.domain.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/*
 * JPA Auditing을 하기 위한 설정
 * 1, gradle 에 해당 요소 추가
 * 2, abstract클래스 생성
 * 3, Application.java에 어노테이션 추가
 */


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity// 테이블과 링크될 클래스, 언더스코어 네이밍
public class Posts extends BaseTimeEntity {
    @Id // PK를 나타냄
    @GeneratedValue// PK생성규칙, MySQL의 auto_increment 같은 개념
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
