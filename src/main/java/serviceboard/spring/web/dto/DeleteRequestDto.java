package serviceboard.spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteRequestDto {

    private String name;
    private String password;

    @Builder
    public DeleteRequestDto(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
