package com.imdbdb.imdbapi.repository;

import com.imdbdb.imdbapi.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RatingRepository extends JpaRepository<Rating, String> {

}
