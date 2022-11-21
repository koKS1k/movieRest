package com.example.movierest.controller;

import com.example.movierest.model.Movie;
import com.example.movierest.services.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping(value = "movie-api")
@Tag(
     name = "Фильмы",
     description = "Все методы для работы с фильмами из БД"
    )
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @Operation(summary = "Отображение по страницам")
    @RequestMapping(value = "/pagination", method = RequestMethod.GET)
    public ResponseEntity<?> getPage(@RequestParam(value="size", required = false, defaultValue = "5")
                                     Integer size,
                                     @RequestParam(value="page", required = false, defaultValue = "0")
                                     Integer page) {

        return  ResponseEntity.ok(movieService.getPageMovies(page,size));
    }

    @Operation(summary = "Получить все фильмы")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<?> allMovies(){
        return  ResponseEntity.ok(movieService.getAllMovies());
    }



    @Operation(summary = "Получить фильм по названию")
    @RequestMapping(value = "/byTitle", method = RequestMethod.GET)
    public ResponseEntity<?> getByTitle(@RequestParam
                                        @Parameter(description = "Название фильма")
                                        String title){
        return  ResponseEntity.ok(movieService.findByTitle(title));
    }

    @Operation(summary = "Получить фильмы по типу")
    @RequestMapping(value = "/byType", method = RequestMethod.GET)
    public ResponseEntity<?> getByType(@RequestParam
                                       @Parameter(description = "Тип фильма")
                                       String type){
        return  ResponseEntity.ok(movieService.findByType(type));
    }

    @Operation(summary = "Получить фильмы по дате выхода")
    @RequestMapping(value = "/byDate", method = RequestMethod.GET)
    public ResponseEntity<?> getByDate(@RequestParam
                                       @Parameter(description = "Дата премьеры")
                                       @DateTimeFormat(pattern = "yyyy-MM-dd")
                                       LocalDate date){
        return  ResponseEntity.ok(movieService.findByDate(date));
    }

    @Operation(summary = "Добавить фильм")
    @RequestMapping(value = "/addMovie", method = RequestMethod.POST)
    public ResponseEntity<Void> saveMovie(@RequestBody
                                          @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Данные фильма в JSON формате")
                                          @Valid
                                          Movie movie){

        movieService.saveMovie(movie);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @Operation(summary = "Добавить несколько фильмов")
    @RequestMapping(value = "/addMovies", method = RequestMethod.POST)
    public ResponseEntity<Void> saveMovies(@RequestBody
                                           @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Данные фильма в JSON формате")
                                           @Valid
                                           List<Movie> movies) {
        movieService.saveMovies(movies);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }



}
