package com.imdbdb.imdbapi.basics;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BasicsRepository extends JpaRepository<Basics, String> {

    @Query("""
        SELECT new com.imdbdb.imdbapi.basics.EpisodeDTO(b2.tconst, b2.primary_title)
        FROM Basics b2
        WHERE EXISTS (
            SELECT 1 FROM Episode e
            JOIN Basics b1 ON e.parent_tconst = b1.tconst
            WHERE b1.primary_title = :searchTitle
            AND e.tconst = b2.tconst
        )
    """)
    Page<EpisodeDTO> findEpisodesByTitle(@Param("searchTitle") String searchTitle, Pageable pageable);
}
