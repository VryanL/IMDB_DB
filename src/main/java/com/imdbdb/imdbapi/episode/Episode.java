package com.imdbdb.imdbapi.episode;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String parent_tconst;

    @Column(name = "season_number")
    private Integer season_number;

    @Column(name = "episode_number")
    private Integer episode_number;
}
