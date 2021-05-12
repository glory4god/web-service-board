package serviceboard.spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostUpdateRequestDto {
    private String content;

    @Builder
    public PostUpdateRequestDto(String content) {
        this.content = content;
    }


}
