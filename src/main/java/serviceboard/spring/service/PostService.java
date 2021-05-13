package serviceboard.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import serviceboard.spring.domain.post.Post;
import serviceboard.spring.domain.post.PostRepository;
import serviceboard.spring.web.dto.PostResponseDto;
import serviceboard.spring.web.dto.PostSaveRequestDto;
import serviceboard.spring.web.dto.PostUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        if (entity.getPassword().equals(requestDto.getPassword())) {
            entity.update(requestDto.getContent());
        } else {
            throw new IllegalArgumentException("비밀번호가 다릅니다");
        }
        return id;
    }

}
