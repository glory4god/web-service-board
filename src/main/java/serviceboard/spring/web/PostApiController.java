package serviceboard.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import serviceboard.spring.service.GetService;
import serviceboard.spring.service.PostService;
import serviceboard.spring.web.dto.PostResponseDto;
import serviceboard.spring.web.dto.PostSaveRequestDto;
import serviceboard.spring.web.dto.PostUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostApiController {

    private final PostService postService;
    private final GetService getService;

    @PostMapping("/api/board/post")
    public PostResponseDto save(@RequestBody PostSaveRequestDto requestDto) {
        Long id = postService.save(requestDto);
        return getService.findById(id);
    }

    @PutMapping("/api/board/post/{id}")
    public PostResponseDto update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        postService.update(id, requestDto);
        return getService.findById(id);
    }

}
