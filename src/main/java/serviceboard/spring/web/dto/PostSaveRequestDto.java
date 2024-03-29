package serviceboard.spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import serviceboard.spring.domain.post.Post;

@Getter
@NoArgsConstructor
public class PostSaveRequestDto {
    private String name;
    private String password;
    private String content;

    @Builder
    public PostSaveRequestDto(Post entity) {
        this.name = entity.getName();
        this.password = entity.getPassword();
        this.content = entity.getContent();
    }

    public Post toEntity() {
        return Post.builder()
                .name(name)
                .password(password)
                .content(content)
                .build();
    }
}
