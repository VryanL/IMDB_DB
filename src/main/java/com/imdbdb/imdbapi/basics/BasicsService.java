package com.imdbdb.imdbapi.basics;

import com.imdbdb.imdbapi.errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicsService {

    private final BasicsRepository basicsRepository;


    @Autowired
    public BasicsService(BasicsRepository basicsRepository) {
        this.basicsRepository = basicsRepository;

    }

    public BasicsDTO getTitlesById(String tconst) {

        return new BasicsDTO(basicsRepository.findByTconst(tconst));
    }

    public List<BasicsDTO> getTitles(String title) {

        Sort sort = Sort.by(Sort.Order.desc("ratings.numVotes"));
        List<Basics> basicsList = basicsRepository.findByPrimaryTitleIgnoreCase(title, sort);
        if (basicsList.isEmpty()) {
            throw new ResourceNotFoundException(title + " not found");
        }

        return basicsList.stream()
                .filter(t -> t.getRatings() != null)
                .map(BasicsDTO::new)
                .toList();
    }

}
