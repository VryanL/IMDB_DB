package com.imdbdb.imdbapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "episode")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Episode {
    @Id
    @Column(name = "tconst", unique = true, nullable = false)
    private String tconst;

    @Column(name = "parent_tconst")
    private String parentTconst;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @Column(name = "episode_number")
    private Integer episodeNumber;

    @ManyToOne
    @JoinColumn(name = "parent_tconst", referencedColumnName = "tconst", insertable=false, updatable=false)
    private Basics parentShow;
}
