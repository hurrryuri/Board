package com.example.boardproj.service;

import groovyjarjarpicocli.CommandLine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@Component
public class FileService {

    @Value("${imgLocation}")
    private String imgLocation;

    public void register(MultipartFile multipartFile, String newImgName){
        //들어온 사진이름

        System.out.println(imgLocation+"\\"+newImgName);


        //사진 경로 및 이름
        File file = new File(imgLocation+"\\"+newImgName);
        //사진저장

        try{
            multipartFile.transferTo(file);

        }catch (IOException e){

        }


    }


    //물리파일 삭제
    public void delFile(String filePath){

        File deleteFilekkk = new File(filePath);

        //if(파일객체 변수명 deleteFile가 존재한다면~ )
        if(deleteFilekkk.exists()) {
            deleteFilekkk.delete(); //물리 파일 삭제
            System.out.println("파일 삭제함");
            System.out.println("파일 삭제함");
            System.out.println("파일 삭제함");

        }else {
            System.out.println("파일 못삭제함");
            System.out.println("파일 못삭제함");
            System.out.println("파일 못삭제함");

        }

    }
}
