package serviceboard.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serviceboard.spring.service.get.GetService;
import serviceboard.spring.service.post.PostService;
import serviceboard.spring.web.dto.PostSaveRequestDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;

    private final GetService getService;

    @PostMapping(value = "/api/board/post",produces = "application/json; charset=utf-8")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

}
