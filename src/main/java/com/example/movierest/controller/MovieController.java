package com.example.movierest.controller;

import com.example.movierest.model.Movie;
import com.example.movierest.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "movie-api")
@Tag(
     name = "Фильмы",
     description = "Все методы для работы с фильмами из БД"
    )
public class MovieController {

    Logger logger = LoggerFactory.getLogger(MovieController.class);

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Получить все фильмы")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Movie> allMovies(){
        return  movieService.getAllMovies();
    }

    @Operation(summary = "Получить фильм по названию")
    @RequestMapping(value = "/byTitle", method = RequestMethod.GET)
    public Movie getByTitle(@RequestParam
                            @Parameter(description = "Название фильма")
                            String title){
        return  movieService.findByTitle(title);
    }

    @Operation(summary = "Получить фильмы по типу")
    @RequestMapping(value = "/byType", method = RequestMethod.GET)
    public List<Movie> getByType(@RequestParam
                                 @Parameter(description = "Тип фильма")
                                 String type){
        return  movieService.findByType(type);
    }

    @Operation(summary = "Получить фильмы по дате выхода")
    @RequestMapping(value = "/byDate", method = RequestMethod.GET)
    public List<Movie> getByType(@RequestParam
                                 @Parameter(description = "Дата премьеры")
                                 @DateTimeFormat(pattern = "yyyy-MM-dd")
                                 LocalDate date){
        return  movieService.findByDate(date);
    }

    @Operation(summary = "Добавить фильм")
    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    public void addMovie(@RequestBody
                         @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Данные фильма в JSON формате")
                         Movie movie){
        movieService.saveMovie(movie);
    }

    @Operation(summary = "Добавить несколько фильмов")
    @RequestMapping(value = "/addMovies", method = RequestMethod.POST)
    public void saveMovies(@RequestBody
                           @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Данные фильма в JSON формате")
                           List<Movie> movies) {
        movieService.saveMovies(movies);
    }

}
