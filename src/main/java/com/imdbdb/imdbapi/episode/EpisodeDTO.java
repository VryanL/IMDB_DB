package com.imdbdb.imdbapi.episode;

import lombok.Getter;

@Getter
public class EpisodeDTO {
    private final String tconst;
    private final String episode_title;
    private final String parent_tconst;
    private final String parent_title;
    private final Integer season_number;
    private final Integer episode_number;


    public EpisodeDTO(Episode episode) {
        this.tconst = episode.getTconst();
        this.episode_title = episode.getBasics().getPrimaryTitle();

        this.parent_tconst = episode.getParentTconst();
        this.parent_title = episode.getParentBasics().getPrimaryTitle();

        this.season_number = episode.getSeasonNumber();
        this.episode_number = episode.getEpisodeNumber();
    }
}
