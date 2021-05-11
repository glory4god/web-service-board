package serviceboard.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import serviceboard.spring.service.post.PostService;
import serviceboard.spring.web.dto.PostResponseDto;
import serviceboard.spring.web.dto.PostSaveRequestDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private PostService postService;

    @PostMapping(value = "/api/board",produces = "application/json")
    public Long save(@RequestBody PostSaveRequestDto requestDto) {
        return postService.save(requestDto);
    }

    @GetMapping("/api/board/{id}")
    public PostResponseDto findbyId(@PathVariable Long id) {
        return postService.findById(id);
    }
}
