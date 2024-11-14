package com.example.boardproj.repository;

import com.example.boardproj.entity.Review;
import com.example.boardproj.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long>, BoardSearch {
}
