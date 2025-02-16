package com.imdbdb.imdbapi.basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BasicsService {

    private final BasicsRepository basicsRepository;

    @Autowired
    public BasicsService(BasicsRepository basicsRepository) {
        this.basicsRepository = basicsRepository;
    }

    public Page<EpisodeDTO> getEpisodeByTitle(String title, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return basicsRepository.findEpisodesByTitle(title, pageable);
    }
}
