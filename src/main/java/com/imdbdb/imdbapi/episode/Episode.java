package com.imdbdb.imdbapi.episode;

import com.imdbdb.imdbapi.basics.Basics;
import com.imdbdb.imdbapi.rating.Rating;
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
    @Column(name = "tconst")
    private String tconst;

    @Column(name = "parent_tconst")
    private String parentTconst;

    @Column(name = "season_number")
    private Integer seasonNumber;

    @Column(name = "episode_number")
    private Integer episodeNumber;

    @OneToOne
    @JoinColumn(name = "tconst", referencedColumnName = "tconst")
    private Basics basics;

    @ManyToOne
    @JoinColumn(name = "parent_tconst", referencedColumnName = "tconst", insertable=false, updatable=false)
    private Basics parentBasics;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tconst", referencedColumnName = "tconst")
    private Rating rating;

}
