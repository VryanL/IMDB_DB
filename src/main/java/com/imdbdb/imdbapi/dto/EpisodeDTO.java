package com.imdbdb.imdbapi.dto;

import lombok.Getter;

@Getter
public class EpisodeDTO {
    private final String primaryTitle;
    private final Integer seasonNumber;
    private final Integer episodeNumber;
    private final Double rating;

//    public EpisodeDTO(String primaryTitle, Integer seasonNumber, Integer episodeNumber) {
//        this.primaryTitle = primaryTitle;
//        this.seasonNumber = seasonNumber;
//        this.episodeNumber = episodeNumber;
//    }

    public EpisodeDTO(String primaryTitle, Integer seasonNumber, Integer episodeNumber, Double episodeRating) {
        this.primaryTitle = primaryTitle;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.rating = episodeRating;
    }
}
