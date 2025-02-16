package com.imdbdb.imdbapi.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {
    private final EpisodeRepository episodeRepository;

    @Autowired
    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }


    public Episode getEpisodes(String tconst) {
        return episodeRepository.findById(tconst).orElse(null);
    }
}
