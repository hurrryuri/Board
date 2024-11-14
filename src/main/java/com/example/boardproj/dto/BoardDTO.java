package com.example.boardproj.dto;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {

    private Long bno;

    @NotBlank(message = "제목의 길이는 2~50글자 사이여야 합니다.")
    @Size(min = 2, max = 50, message = "제목의 길이는 2~50글자 사이여야 합니다.")
    private String title;

    @NotBlank(message = "제목의 길이는 2~50글자사이여야 합니다.")
    @Size(min = 2, max = 255, message = "내용의 길이는 2~255로 채우세요")
    private String content;

    @NotBlank(message = "작성자는 꼭 입력하세요")
    @Size(min= 2, max = 50, message = "작성자의 길이는 2~50글자 사이여야 합니다.")
    private String writer;

    private LocalDate regidate;

    private LocalDate updatedate;



}
