package com.imdbdb.imdbapi.entity;

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
    private double averageRating;

    @Column(name = "num_votes")
    private Integer numVotes;

    @OneToOne
    @JoinColumn(name = "tconst", referencedColumnName = "tconst")
    private Basics basics;
}
