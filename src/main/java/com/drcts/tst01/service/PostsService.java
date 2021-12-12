package com.drcts.tst01.service;


import com.drcts.tst01.domain.Posts;
import com.drcts.tst01.domain.PostsRepository;
import com.drcts.tst01.web.dto.PostsResponseDto;
import com.drcts.tst01.web.dto.PostsSaveRequestDto;
import com.drcts.tst01.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }



    //    @Transactional(readOnly = true)
    public List<PostsResponseDto> findAllDesc(){
      return postsRepository.findAllDesc()
              .stream().map(posts -> new PostsResponseDto(posts)).collect(Collectors.toList());
    }


    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {

        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당포스트가 없습니다"));

        // Entity 업데이트하면, JPA에서 자동업데이트함
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }


    @Transactional
    public Long delete(Long id) {

        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당포스트가 없습니다"));

        // 삭제는 repository에서 수행... update는 커스터마이징이 필요해서 Entity에 추가한것이다..
        postsRepository.delete(posts);
        //        postsRepository.deleteById(id);

        return id;
    }



    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당포스트가 없습니다"));

        return new PostsResponseDto(entity);
    }
}
