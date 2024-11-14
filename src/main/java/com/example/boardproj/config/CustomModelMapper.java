package com.example.boardproj.config;

import com.example.boardproj.dto.BoardDTO;
import org.modelmapper.ModelMapper;

import java.awt.*;

public class CustomModelMapper extends ModelMapper {

    @Override
    public <D> D map (Object source, Class<D> destinationType) {
//        BoardDTO boardDTO =
//                ModelMapper.map(board, BoardDTO.class);
        if (source == null) {
            return null;
        }

        return super.map(source, destinationType);

    }
}
