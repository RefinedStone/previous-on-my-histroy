package com.sparta.submitHomwork.domain;
import com.sparta.submitHomwork.dto.CommentRequestDto;
import com.sparta.submitHomwork.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String username;

    @Column(nullable = true)
    private String comments;

    public Comment(String username, String contents) {
        this.username = username;
        this.comments = contents;
    }
    public Comment(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }

    public void update(CommentRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.comments = requestDto.getComments();
    }


}
