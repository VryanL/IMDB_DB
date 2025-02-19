package com.imdbdb.imdbapi.dto;

import com.imdbdb.imdbapi.entity.Basics;
import com.imdbdb.imdbapi.entity.Episode;
import com.imdbdb.imdbapi.entity.Rating;
import lombok.Getter;

@Getter
public class EpisodeDTO {
    private final String id;
    private final String primaryTitle;
    private final Integer seasonNumber;
    private final Integer episodeNumber;
    private final Double rating;


    public EpisodeDTO(Basics basics, Episode episode, Rating rating) {
        this.id = basics.getTconst();
        this.primaryTitle = basics.getPrimaryTitle();
        this.seasonNumber = episode.getSeasonNumber();
        this.episodeNumber = episode.getEpisodeNumber();
        this.rating = Math.round(rating.getAverageRating() * 10.0) /10.0;
    }
}
