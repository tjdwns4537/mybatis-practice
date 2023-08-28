package kia.com.mybatistest.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardUserDto {
    private Long boardId;
    private String boardTitle;
    private String boardContent;
    private String createAt;
    private String modifyAt;
    private JoinUserDto user;

}
