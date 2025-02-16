package com.imdbdb.imdbapi.basics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private String title_type;

    @Column(name = "primary_title")
    private String primary_title;

    @Column(name = "original_title")
    private String original_title;

    @Column(name = "is_adult")
    private boolean is_adult;

    @Column(name = "start_year")
    private Integer start_year;

    @Column(name = "end_year")
    private Integer end_year;

    @Column(name = "runtime_minutes")
    private Integer runtime_minute;

    @Column(name = "genres")
    private String genres;

}
