package kia.com.mybatistest.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class BoardDto {

    private Long board_id;
    private String board_title;
    private String board_content;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime create_at;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime modify_at;

    public BoardDto(String board_title, String board_content, LocalDateTime create_at, LocalDateTime modify_at) {
        this.board_title = board_title;
        this.board_content = board_content;
        this.create_at = create_at;
        this.modify_at = modify_at;
    }

    public static BoardDto of(String board_title, String board_content, LocalDateTime create_at, LocalDateTime modify_at) {
        return new BoardDto(board_title, board_content, create_at, modify_at);
    }
}