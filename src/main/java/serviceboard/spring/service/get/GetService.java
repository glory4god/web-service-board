package serviceboard.spring.service.get;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import serviceboard.spring.domain.post.Post;
import serviceboard.spring.domain.post.PostRepository;
import serviceboard.spring.web.dto.PostListResponseDto;
import serviceboard.spring.web.dto.PostResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAll() {
        return postRepository.findAll().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    public PostResponseDto findById(Long id) {
        Post entity = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        return new PostResponseDto(entity);
    }

}
