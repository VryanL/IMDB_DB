package com.imdbdb.imdbapi.controller;


import com.imdbdb.imdbapi.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/episode")
public class EpisodeController {

    private final EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }


}
