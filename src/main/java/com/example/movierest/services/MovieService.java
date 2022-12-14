package com.example.movierest.services;

import com.example.movierest.model.Movie;
import com.example.movierest.repositories.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie findByTitle(String title){
        return movieRepository.findAllByTitle(title);
    }

    public List<Movie> findByType(String type){
        return movieRepository.findAllByType(type);
    }

    public List<Movie> findByDate(LocalDate date){
        return movieRepository.findAllByDate(date);
    }

    public void saveMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void saveMovies(List<Movie> movies){
        movieRepository.saveAll(movies);
    }

    public Page<Movie> getPageMovies(Integer page, Integer size){

        return movieRepository.findAll(PageRequest.of(page,size));
    }


}
