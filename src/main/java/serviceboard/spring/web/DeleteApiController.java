package serviceboard.spring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import serviceboard.spring.service.DeleteService;
import serviceboard.spring.web.dto.DeleteRequestDto;

@RequiredArgsConstructor
@RestController
public class DeleteApiController {

    private final DeleteService deleteService;

    @DeleteMapping("/api/board/{id}")
    public Long delete(@PathVariable Long id, @RequestBody DeleteRequestDto requestDto) {
        deleteService.deleteById(id, requestDto);
        return id;
    }
}
