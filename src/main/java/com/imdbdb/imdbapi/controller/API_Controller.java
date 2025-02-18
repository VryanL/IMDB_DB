package com.imdbdb.imdbapi.controller;

import com.imdbdb.imdbapi.dto.TitlesDTO;
import com.imdbdb.imdbapi.service.API_Service;
import com.imdbdb.imdbapi.dto.EpisodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class API_Controller {

    private final API_Service APIService;

    @Autowired
    public API_Controller(API_Service APIService) {
        this.APIService = APIService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<TitlesDTO>> search(@RequestParam String title) {
        return ResponseEntity.ok(APIService.getTitles(title));
    }

    @GetMapping("/{title_id}")
    public ResponseEntity<TitlesDTO> getEpisode(@PathVariable String title_id) {
        return ResponseEntity.ok(APIService.getTitlesById(title_id));
    }

    @GetMapping("/{title_id}/episodes")
    public ResponseEntity<List<EpisodeDTO>> getEpisodesByTitle(@PathVariable String title_id) {
        return ResponseEntity.ok(APIService.getEpisodeTitles(title_id));
    }

}
