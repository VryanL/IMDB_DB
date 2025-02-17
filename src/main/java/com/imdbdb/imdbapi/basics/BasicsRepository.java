package com.imdbdb.imdbapi.basics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BasicsRepository extends JpaRepository<Basics, String> {
    List<Basics> findByPrimaryTitleAndTitleType(String primaryTitle, String titleType);

}
