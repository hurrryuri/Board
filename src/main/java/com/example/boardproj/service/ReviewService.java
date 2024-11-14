package com.example.boardproj.service;

import com.example.boardproj.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    public void register(ReviewDTO reviewDTO);

    public ReviewDTO read(Long vno);

    public List<ReviewDTO> list();

    public ReviewDTO update(ReviewDTO reviewDTO);

    public void remove(Long vno);
}
