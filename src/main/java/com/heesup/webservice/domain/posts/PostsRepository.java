package com.heesup.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;


//JpaRepository<Entity클래스, PK타입>
//@Repository 추가할 필요 없음
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
