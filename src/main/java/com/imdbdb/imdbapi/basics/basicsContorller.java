package com.imdbdb.imdbapi.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/basics")
public class basicsContorller {

    private final BasicsService basicsService;

    @Autowired
    public basicsContorller(BasicsService basicsService) {
        this.basicsService = basicsService;
    }



    @GetMapping("/episodes")
    public Page<EpisodeDTO> getEpisodesByTitle(
            @RequestParam String title,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return basicsService.getEpisodeByTitle(title, page, size);
    }

}
