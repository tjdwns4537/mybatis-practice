package kia.com.mybatistest.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {

    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String createAt;
    private String modifyAt;
    private Long userId;

    public BoardDto(String boardTitle, String boardContent, String createAt, String modifyAt) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
    }

    public BoardDto(String boardTitle, String boardContent, String createAt, String modifyAt, Long userId) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.createAt = createAt;
        this.modifyAt = modifyAt;
        this.userId = userId;
    }
}
