package com.imdbdb.imdbapi.repository;

import com.imdbdb.imdbapi.entity.Basics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BasicsRepository extends JpaRepository<Basics, String> {
    List<Basics> findByPrimaryTitleIgnoreCase(String primaryTitle);
    List<Basics> findByPrimaryTitleAndTitleType(String primaryTitle, String titleType);

    //Optional<Basics> findByTconst(String tconst);
}
