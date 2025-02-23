package com.imdbdb.imdbapi.basics;

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

    @GetMapping("/{title_id}")
    public ResponseEntity<BasicsDTO> getEpisode(@PathVariable String title_id) {
        return ResponseEntity.ok(basicsService.getTitlesById(title_id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<BasicsDTO>> search(@RequestParam String title) {
        return ResponseEntity.ok(basicsService.getTitles(title));
    }

}
