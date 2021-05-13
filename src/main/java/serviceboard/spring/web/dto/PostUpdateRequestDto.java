package serviceboard.spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostUpdateRequestDto {
    private String password;
    private String content;

    @Builder
    public PostUpdateRequestDto(String password, String content) {
        this.password = password;
        this.content = content;
    }


}
