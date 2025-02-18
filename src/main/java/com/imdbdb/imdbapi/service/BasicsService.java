package com.imdbdb.imdbapi.service;


import com.imdbdb.imdbapi.dto.EpisodeDTO;
import com.imdbdb.imdbapi.dto.TitlesDTO;
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

    public TitlesDTO getTitlesById(String tconst) {
        Basics basics = basicsRepository.findById(tconst).orElseThrow(
                ()-> new ResourceNotFoundException("Basics not found"));
        return new TitlesDTO(basics);
    }

    public List<TitlesDTO> getTitles(String title) {
        List<Basics> basicsList = basicsRepository.findByPrimaryTitleIgnoreCase(title);
        if (basicsList.isEmpty()) {
            throw new ResourceNotFoundException(title + " not found");
        }

        List<TitlesDTO> basicsDTOList = new ArrayList<>();
        for (Basics basics : basicsList) {
            basicsDTOList.add(new TitlesDTO(basics));
        }
        return basicsDTOList;
    }



    public List<EpisodeDTO> getEpisodeTitles(String tconst) {
        Basics basics = basicsRepository.findById(tconst).orElseThrow(
                ()->new ResourceNotFoundException("Id " + tconst + " not found"));

        List<EpisodeDTO> episodeTitles = new ArrayList<>();
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
        return episodeTitles;
    }

}
