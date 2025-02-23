package com.imdbdb.imdbapi.basics;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class BasicsDTO {
    private final String tconst;
    private final String titleType;
    private final String primaryTitle;
    private final Integer startYear;
    private final Integer runtime_minutes;
    private final List<String> genres;
    private final Integer numVotes;
    private final Double averageRating;

    public BasicsDTO(Basics basics) {
        this.tconst = basics.getTconst();
        this.titleType = basics.getTitleType();
        this.primaryTitle = basics.getPrimaryTitle();
        this.startYear = basics.getStartYear();
        this.runtime_minutes = basics.getRuntimeMinutes();
        this.genres = Arrays.asList(basics.getGenres().split(","));

        this.numVotes = basics.getRatings().getNumVotes() == null ? null : basics.getRatings().getNumVotes();
        this.averageRating = basics.getRatings().getAverageRating() == null
                ? null : Math.round(basics.getRatings().getAverageRating()*10.0)/10.0;


    }
}
