package com.heesup.webservice.service;

import com.heesup.webservice.domain.posts.PostsRepository;
import com.heesup.webservice.dto.PostsMainResponseDto;
import com.heesup.webservice.dto.posts.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostsService {

    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    /*
     *DB 데이터를 등록/수정/삭제 하는 Service 메소드는 @Transactional를 필수
     *메소드 내에서 Exception이 발생하면 해당 메소드에서 이루어진 모든 DB작업을 초기화
     *이미 넣은걸 롤백시키는건 아니며, 모든 처리가 정상적으로 됐을때만 DB에 커밋
     */
    //Entity로 받지 않고 dto를 통해서 받음
    @Transactional(readOnly = true)
    public List<PostsMainResponseDto> findAllDesc() {
        return postsRepository.findAllDesc()
                //repository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsMainResponseDto로 변환 -> List로 반환하는 메소드.
                .map(PostsMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
