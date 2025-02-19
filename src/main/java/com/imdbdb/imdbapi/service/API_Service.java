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
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class API_Service {

    private final BasicsRepository basicsRepository;
    private final EpisodeRepository episodeRepository;
    private final RatingRepository ratingRepository;

    @Autowired
    public API_Service(BasicsRepository basicsRepository, EpisodeRepository episodeRepository, RatingRepository ratingRepository) {
        this.basicsRepository = basicsRepository;
        this.episodeRepository = episodeRepository;
        this.ratingRepository = ratingRepository;
    }

    public TitlesDTO getTitlesById(String tconst) {
        Basics basics = basicsRepository.findById(tconst).orElseThrow(
                ()-> new ResourceNotFoundException("Basics not found"));
        Rating rating = ratingRepository.findById(tconst).orElse(new Rating());
        return new TitlesDTO(basics,rating);
    }

    public List<TitlesDTO> getTitles(String title) {
        List<Basics> basicsList = basicsRepository.findByPrimaryTitleIgnoreCaseOrderByStartYearDesc(title);
        if (basicsList.isEmpty()) {
            throw new ResourceNotFoundException(title + " not found");
        }

        List<TitlesDTO> basicsDTOList = new ArrayList<>();
        for (Basics basics : basicsList) {
            Rating rating = ratingRepository.findById(basics.getTconst()).orElse(new Rating());
            basicsDTOList.add(new TitlesDTO(basics, rating));
        }
        return basicsDTOList;
    }



    public List<EpisodeDTO> getEpisodeTitles(String tconst) {

        List<EpisodeDTO> episodeTitles = new ArrayList<>();
        List<Episode> episodes = episodeRepository.findByParentTconstOrderBySeasonNumberAscEpisodeNumberAsc(tconst);
        if (episodes.isEmpty()) {
            throw new ResourceNotFoundException(tconst + " not found");
        }

        for (Episode episode : episodes) {
            String episode_tconst = episode.getTconst();
            Rating rating = ratingRepository.findById(episode_tconst).orElse(new Rating());

            basicsRepository.findById(episode_tconst)
                    .ifPresent(b -> episodeTitles.add(new EpisodeDTO(b, episode, rating)));
        }
        return episodeTitles;
    }

}
