package com.imdbdb.imdbapi.rating;

import com.imdbdb.imdbapi.basics.Basics;
import com.imdbdb.imdbapi.episode.Episode;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rating")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "average_rating")
    private Double averageRating;

    @Column(name = "num_votes")
    private Integer numVotes;

    @OneToOne(mappedBy = "ratings")
    private Basics basics;

    @OneToOne(mappedBy = "rating")
    private Episode episode;
}
