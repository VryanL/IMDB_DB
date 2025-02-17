package com.imdbdb.imdbapi.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/basics")
public class basicsContorller {

    private final BasicsService basicsService;

    @Autowired
    public basicsContorller(BasicsService basicsService) {
        this.basicsService = basicsService;
    }



    @GetMapping("/series/episodes")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesByTitle(@RequestParam String title) {
        List<EpisodeDTO> episodes = basicsService.getEpisodeTitles(title);
        return ResponseEntity.ok(episodes);
    }

}
