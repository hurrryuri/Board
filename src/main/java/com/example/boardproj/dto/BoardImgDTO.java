package com.example.boardproj.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BoardImgDTO {

    private Long ino;

    private String imaPath;

    private String ImgName;

    private String newImgName;

    private BoardDTO boardDTO;
}
