package com.imdbdb.imdbapi.episode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EpisodeController {

    private final EpisodeService episodeService;

    @Autowired
    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/{title_id}/episodes")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesByTitle(@PathVariable String title_id) {
        return ResponseEntity.ok(episodeService.getEpisodeTitles(title_id));
    }
}
