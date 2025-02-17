package com.imdbdb.imdbapi.episode;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EpisodeRepository extends JpaRepository<Episode, String> {
    List<Episode> findByParentTconst(String parentTconst);

    List<Episode> findByParentTconstOrderBySeasonNumberAscEpisodeNumberAsc(String parentTconst);

}
