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

        List<EpisodeDTO> episodeTitles = new ArrayList<>();
        List<Episode> episodes = episodeRepository.findByParentTconstOrderBySeasonNumberAscEpisodeNumberAsc(tconst);
        if (episodes.isEmpty()) {
            throw new ResourceNotFoundException(tconst + " not found");
        }

        for (Episode episode : episodes) {
            String episode_tconst = episode.getTconst();
            Rating rating = ratingRepository.findById(episode_tconst).orElseThrow(
                    ()->new ResourceNotFoundException("Id: " + tconst + " not found in ratings"));

            basicsRepository.findById(episode_tconst)
                    .ifPresent(b -> episodeTitles.add(new EpisodeDTO(b, episode, rating)));
        }
        return episodeTitles;
    }

}
