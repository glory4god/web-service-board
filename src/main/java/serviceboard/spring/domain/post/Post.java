package serviceboard.spring.domain.post;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import serviceboard.spring.domain.BaseTimeEntity;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "board")
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "content", nullable = false)
    private String content;

    @Builder
    public Post(String name, String password, String content) {
        this.name = name;
        this.password = password;
        this.content = content;
    }

}
