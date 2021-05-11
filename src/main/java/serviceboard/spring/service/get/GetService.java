package serviceboard.spring.service.get;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import serviceboard.spring.domain.post.PostRepository;
import serviceboard.spring.web.dto.PostListResponseDto;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class GetService {
    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAll() {
        return postRepository.findAll().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

}
