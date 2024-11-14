package com.example.boardproj.service;

import com.example.boardproj.dto.BoardDTO;
import com.example.boardproj.dto.ReviewDTO;
import com.example.boardproj.entity.Board;
import com.example.boardproj.entity.Review;
import com.example.boardproj.repository.BoardRepository;
import com.example.boardproj.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Log4j2
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{

    private final ReviewRepository reviewRepository;
    private final BoardRepository boardRepository;
    private final ModelMapper modelMapper;

    @Override
    public void register(ReviewDTO reviewDTO) {

        Optional<Board> optionalBoard =
                boardRepository.findById(reviewDTO.getBno());

        Board board = optionalBoard.orElseThrow(EntityNotFoundException::new);

        Review review =
        modelMapper.map(reviewDTO, Review.class);
        review.setBoard(board);

        reviewRepository.save(review);

    }

    @Override
    public ReviewDTO read(Long vno) {
        Review review =
                reviewRepository.findById(vno).orElseThrow(EntityNotFoundException::new);

        ReviewDTO reviewDTO = modelMapper.map(review, ReviewDTO.class);


        return reviewDTO;
    }

    @Override
    public List<ReviewDTO> list() {
        List<Review> reviewList =
                reviewRepository.findAll();

        List<ReviewDTO> list =
                reviewList.stream()
                        .map(review -> modelMapper.map(review, ReviewDTO.class)
                                .setBoardDTO(modelMapper.map(review.getBoard(), BoardDTO.class)))
                        .collect(Collectors.toList());
        return list;
    }

    @Override
    public ReviewDTO update(ReviewDTO reviewDTO) {

        Review review = reviewRepository.findById(reviewDTO.getVno()).orElseThrow(EntityNotFoundException::new);
        review.setReviewText(reviewDTO.getReviewText());

        return modelMapper.map(review, ReviewDTO.class);
    }

    @Override
    public void remove(Long vno) {

        reviewRepository.deleteById(vno);

    }
}
