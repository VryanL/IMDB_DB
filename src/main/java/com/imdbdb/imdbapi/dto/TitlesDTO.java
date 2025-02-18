package com.imdbdb.imdbapi.dto;

import com.imdbdb.imdbapi.entity.Basics;
import lombok.Getter;

@Getter
public class TitlesDTO {
    private final String tconst;
    private final String title;
    private final Integer year;
    private final String genre;
    private final String type;


    public TitlesDTO(Basics basics) {
        this.tconst = basics.getTconst();
        this.title = basics.getPrimaryTitle();
        this.year = basics.getStartYear();
        this.genre = basics.getGenres();
        this.type = basics.getTitleType();

    }
}
