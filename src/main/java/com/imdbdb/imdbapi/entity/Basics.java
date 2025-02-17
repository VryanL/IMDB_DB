package com.imdbdb.imdbapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "basics")
public class Basics {

    @Id
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "title_type")
    private String titleType;

    @Column(name = "primary_title")
    private String primaryTitle;

    @Column(name = "original_title")
    private String originalTitle;

    @Column(name = "is_adult")
    private boolean isAdult;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "runtime_minutes")
    private Integer runtimeMinute;

    @Column(name = "genres")
    private String genres;

    @OneToMany(mappedBy = "parentTconst", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Episode> episodes;

    @OneToOne(mappedBy = "basics", cascade = CascadeType.ALL)
    private Rating rating;
}
