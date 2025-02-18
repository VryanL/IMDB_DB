package com.imdbdb.imdbapi.repository;


import com.imdbdb.imdbapi.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, String> {

    List<Episode> findByParentTconstOrderBySeasonNumberAscEpisodeNumberAsc(String parentTconst);

}
