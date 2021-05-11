package serviceboard.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import serviceboard.spring.service.get.GetService;
import serviceboard.spring.web.dto.PostListResponseDto;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GetApiController {

    private GetService getService;

    @GetMapping("/api/board")
    public List<PostListResponseDto> findAll() {
        return getService.findAll();
    }

}
