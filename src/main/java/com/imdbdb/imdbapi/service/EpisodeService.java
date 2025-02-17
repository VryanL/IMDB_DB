package com.imdbdb.imdbapi.service;

import com.imdbdb.imdbapi.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {
    private final EpisodeRepository episodeRepository;

    @Autowired
    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }


}
