package serviceboard.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import serviceboard.spring.domain.post.Post;
import serviceboard.spring.domain.post.PostRepository;
import serviceboard.spring.web.dto.DeleteRequestDto;

@RequiredArgsConstructor
@Service
public class DeleteService {

    private final PostRepository postRepository;
    private final GetService getService;

    @Transactional
    public Long deleteById(Long id, DeleteRequestDto requestDto) {
        Post entityEarly = postRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시물이 없습니다. id=" + id));
        if (entityEarly.getPassword().equals(requestDto.getPassword())) {
            postRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("비밀번호가 다릅니다");
        }
        return id;

    }

}
