package serviceboard.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import serviceboard.spring.service.get.GetService;
import serviceboard.spring.web.dto.PostListResponseDto;
import serviceboard.spring.web.dto.PostResponseDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GetApiController {

    private final GetService getService;

    @GetMapping("/api/board/{id}")
    public PostResponseDto findById(@PathVariable Long id) {
        return getService.findById(id);
    }

    @GetMapping("/api/board")
    public List<PostListResponseDto> findAll() {

        return getService.findAll();
    }

}
