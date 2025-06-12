package org.scoula.board.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardVO {
    private Long no;    // wrapper 타입으로 잡은 이유는 NULL을 배정하기 위함
    private String title;
    private String content;
    private String writer;
    private Date regDate;
    private Date updateDate;
}
