package com.example.boardproj.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {

    private Long vno;

    private Long bno;

    private String reviewText;

    private String writer;

    private BoardDTO boardDTO;

    private LocalDate regidate;

    private LocalDate updatedate;

    public ReviewDTO setBoardDTO(BoardDTO boardDTO){
        this.boardDTO = boardDTO;
        return this;
    }
}
