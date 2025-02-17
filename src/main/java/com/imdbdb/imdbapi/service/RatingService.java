package com.imdbdb.imdbapi.service;

import com.imdbdb.imdbapi.entity.Rating;
import com.imdbdb.imdbapi.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RatingService {
    private final RatingRepository ratingsRepository;

    @Autowired
    public RatingService(RatingRepository ratingsRepository) {
        this.ratingsRepository = ratingsRepository;
    }

    public Optional<Rating> getRatingByTconst(String tconst) {
        return ratingsRepository.findByTconst(tconst);
    }
}
