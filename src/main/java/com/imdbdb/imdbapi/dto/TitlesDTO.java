package com.imdbdb.imdbapi.dto;

import com.imdbdb.imdbapi.entity.Basics;
import com.imdbdb.imdbapi.entity.Rating;
import lombok.Getter;

@Getter
public class TitlesDTO {
    private final String id;
    private final String title;
    private final Integer year;
    private final String genre;
    private final String type;
    private final Double rating;
    private final String isAdult;


    public TitlesDTO(Basics basics, Rating rating) {
        this.id = basics.getTconst();
        this.title = basics.getPrimaryTitle();
        this.year = (basics.getStartYear() == null) ? 0 : basics.getStartYear();
        this.genre = basics.getGenres();
        this.type = basics.getTitleType();
        this.rating = Math.round(rating.getAverageRating() * 10.0) /10.0;
        this.isAdult = (basics.isAdult()) ? "Yes" : "No";
    }
}
