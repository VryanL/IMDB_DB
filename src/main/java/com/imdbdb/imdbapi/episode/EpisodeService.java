package com.imdbdb.imdbapi.episode;

import com.imdbdb.imdbapi.errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    @Autowired
    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;

    }

    public List<EpisodeDTO> getEpisodeTitles(String tconst) {

        List<Episode> episodes = episodeRepository.findByParentTconstOrderBySeasonNumberAscEpisodeNumberAsc(tconst);
        if (episodes.isEmpty()) {
            throw new ResourceNotFoundException(tconst + " not found");
        }

        return episodes.stream().map(EpisodeDTO::new).toList();
    }
}