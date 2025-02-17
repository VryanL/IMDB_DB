package com.imdbdb.imdbapi.basics;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class EpisodeDTO {
    private final String primaryTitle;
    private final Integer seasonNumber;
    private final Integer episodeNumber;

    public EpisodeDTO(String primaryTitle, Integer seasonNumber, Integer episodeNumber) {
        this.primaryTitle = primaryTitle;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
    }

}
