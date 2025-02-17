package com.imdbdb.imdbapi.service;


import com.imdbdb.imdbapi.dto.EpisodeDTO;
import com.imdbdb.imdbapi.entity.Basics;
import com.imdbdb.imdbapi.entity.Episode;
import com.imdbdb.imdbapi.entity.Rating;
import com.imdbdb.imdbapi.errorhandler.ResourceNotFoundException;
import com.imdbdb.imdbapi.repository.EpisodeRepository;
import com.imdbdb.imdbapi.repository.BasicsRepository;
import com.imdbdb.imdbapi.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class BasicsService {

    private final BasicsRepository basicsRepository;

    private final EpisodeRepository episodeRepository;

    private final RatingRepository ratingRepository;

    @Autowired
    public BasicsService(BasicsRepository basicsRepository, EpisodeRepository episodeRepository, RatingRepository ratingRepository) {
        this.basicsRepository = basicsRepository;
        this.episodeRepository = episodeRepository;
        this.ratingRepository = ratingRepository;
    }

    public List<EpisodeDTO> getEpisodeTitles(String primary_title) {
        List<Basics> basicsList = basicsRepository.findByPrimaryTitleAndTitleType(primary_title, "tvSeries");

        if (basicsList.isEmpty()) {
            throw new ResourceNotFoundException(primary_title + " not found");
        }

        List<EpisodeDTO> episodeTitles = new ArrayList<>();

        for (Basics basics : basicsList) {
            String tconst = basics.getTconst();
            List<Episode> episodes = episodeRepository.findByParentTconstOrderBySeasonNumberAscEpisodeNumberAsc(tconst);


            for (Episode episode : episodes) {
                String episode_tconst = episode.getTconst();

                Rating rating = ratingRepository.findByTconst(episode_tconst).orElse(null);
                basicsRepository.findById(episode_tconst)
                        .ifPresent(b -> {
                            assert rating != null;
                            episodeTitles.add(new EpisodeDTO(
                                    b.getPrimaryTitle(),
                                    episode.getSeasonNumber(),
                                    episode.getEpisodeNumber(),
                                    rating.getAverageRating())
                            );
                        });
            }

        }
        return episodeTitles;
    }

}
