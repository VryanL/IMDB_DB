package com.imdbdb.imdbapi.basics;


import com.imdbdb.imdbapi.episode.Episode;
import com.imdbdb.imdbapi.episode.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class BasicsService {

    private final BasicsRepository basicsRepository;

    private final EpisodeRepository episodeRepository;

    @Autowired
    public BasicsService(BasicsRepository basicsRepository, EpisodeRepository episodeRepository) {
        this.basicsRepository = basicsRepository;
        this.episodeRepository = episodeRepository;
    }

    public List<EpisodeDTO> getEpisodeTitles(String primary_title) {
        List<Basics> basicsList = basicsRepository.findByPrimaryTitleAndTitleType(primary_title, "tvSeries");

        if (basicsList.isEmpty()) {
            throw new RuntimeException("Show not found");
        }

        List<EpisodeDTO> episodeTitles = new ArrayList<>();

        for (Basics basics : basicsList) {
            System.out.println(basics.getTconst());

            String tconst = basics.getTconst();
            List<Episode> episodes = episodeRepository.findByParentTconstOrderBySeasonNumberAscEpisodeNumberAsc(tconst);

            for (Episode episode : episodes) {
                basicsRepository.findById(episode.getTconst())
                        .ifPresent(b -> episodeTitles.add(
                                new EpisodeDTO(b.getPrimaryTitle(), episode.getSeasonNumber(), episode.getEpisodeNumber())
                        ));
            }

        }
        return episodeTitles;
    }

}
