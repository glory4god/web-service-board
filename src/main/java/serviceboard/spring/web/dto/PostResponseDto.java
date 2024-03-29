package serviceboard.spring.web.dto;

import lombok.Getter;
import serviceboard.spring.domain.post.Post;

@Getter
public class PostResponseDto {
    private Long id;
    private String name;
    private String password;
    private String content;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.content = entity.getContent();
    }
}
