package com.heesup.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;


//JpaRepository<Entity클래스, PK타입>
//@Repository 추가할 필요 없음
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //sping jap에서 제공하지 않는 쿼리문의 설정
    @Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
