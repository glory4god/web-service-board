package serviceboard.spring.service.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import serviceboard.spring.domain.post.Post;
import serviceboard.spring.domain.post.PostRepository;
import serviceboard.spring.web.dto.PostResponseDto;
import serviceboard.spring.web.dto.PostSaveRequestDto;

@RequiredArgsConstructor
@Service
public class PostService {
    private PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    public PostResponseDto findById(Long id) {
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        return new PostResponseDto(entity);

    }

}
