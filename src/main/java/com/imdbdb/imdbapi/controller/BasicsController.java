package com.imdbdb.imdbapi.controller;

import com.imdbdb.imdbapi.dto.TitlesDTO;
import com.imdbdb.imdbapi.service.BasicsService;
import com.imdbdb.imdbapi.dto.EpisodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class BasicsController {

    private final BasicsService basicsService;

    @Autowired
    public BasicsController(BasicsService basicsService) {
        this.basicsService = basicsService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<TitlesDTO>> search(@RequestParam String title) {
        return ResponseEntity.ok(basicsService.getTitles(title));
    }

    @GetMapping("/{title_id}")
    public ResponseEntity<TitlesDTO> getEpisode(@PathVariable String title_id) {
        return ResponseEntity.ok(basicsService.getTitlesById(title_id));
    }

    @GetMapping("/{title_id}/episodes")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesByTitle(@PathVariable String title_id) {
        return ResponseEntity.ok(basicsService.getEpisodeTitles(title_id));
    }

}
