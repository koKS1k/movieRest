package com.example.movierest;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.movierest.model.Movie;
import com.example.movierest.services.MovieService;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class MovieRestApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void shouldReturnOneMovieByTitle() throws Exception {


        when(movieService.findByTitle("Большой Лебовски")).thenReturn(new Movie(
                                                                                /*title*/"Большой Лебовски",
                                                                                /*description*/"Тихого пофигиста по ошибке принимают за богача.",
                                                                                /*type*/"Полнометражный",
                                                                                /*genre*/"Комедия",
                                                                                /*date*/LocalDate.of(1998, 1, 18)
                                                                                ));

        this.mockMvc.perform(get("/movie-api/byTitle?title=Большой Лебовски"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()",is(6)))
                .andExpect(jsonPath("$.title",is("Большой Лебовски")))
                .andExpect(jsonPath("$.description",is("Тихого пофигиста по ошибке принимают за богача.")))
                .andExpect(jsonPath("$.type",is("Полнометражный")))
                .andExpect(jsonPath("$.genre",is("Комедия")))
                .andExpect(jsonPath("$.date",is("1998-01-18")));

    }



    @Test
    public void shouldReturnListOfMovies() throws Exception {

        List<Movie> movieList= new ArrayList<>();
        Collections.addAll
                (movieList,

                        new Movie(
                                /*title*/"Побег из Шоушенка",
                                /*description*/"Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника.",
                                /*type*/"Полнометражный",
                                /*genre*/"Драма",
                                /*date*/LocalDate.of(1994, 9, 10)
                        ),

                        new Movie(
                                /*title*/"Большой Лебовски",
                                /*description*/"Тихого пофигиста по ошибке принимают за богача.",
                                /*type*/"Полнометражный",
                                /*genre*/"Комедия",
                                /*date*/LocalDate.of(1998, 1, 18)
                        ),

                        new Movie(
                                /*title*/"Самогонщики",
                                /*description*/"Трус, Балбес и Бывалый решают поставить на широкую ногу изготовление самогона - и снова фиаско...",
                                /*type*/"Короткометражный",
                                /*genre*/"Драма",
                                /*date*/LocalDate.of(1962, 1, 8)
                        )
                );


        when(movieService.getAllMovies()).thenReturn(movieList);

        this.mockMvc.perform(get("/movie-api/all"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.size()",is(3)))
                    .andExpect(jsonPath("$.[0].title",is("Побег из Шоушенка")))
                    .andExpect(jsonPath("$.[0].description",is("Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника.")))
                    .andExpect(jsonPath("$.[0].type",is("Полнометражный")))
                    .andExpect(jsonPath("$.[0].genre",is("Драма")))
                    .andExpect(jsonPath("$.[0].date",is("1994-09-10")));

    }

    @Test
    public void shouldCreateMovie() throws Exception{

        this.mockMvc
                .perform(post("/movie-api/addMovie")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"id\": 20,\n" +
                                "    \"title\": \"Гравити Фолз\",\n" +
                                "    \"description\": \"Близнецы проводят каникулы у странного прадядюшки. Тайны и аномалии в захватывающем мультсериале Алекса Хирша\",\n" +
                                "    \"type\": \"Сериал\",\n" +
                                "    \"genre\": \"Мультфильм\",\n" +
                                "    \"date\": \"2013-01-04\"\n" +
                                "  }")
                        )
               .andExpect(status().isCreated());

        verify(movieService).saveMovie(ArgumentMatchers.any(Movie.class));
    }

    @Test
    public void shouldCreateAnyMovies() throws Exception{

        this.mockMvc
                .perform(post("/movie-api/addMovies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("[\n" +
                                "  {\n" +
                                "    \"id\": null,\n" +
                                "    \"title\": \"Женщина в золотом\",\n" +
                                "    \"description\": \"История Марии Альтманн, которая пытается добиться справедливости – вернуть ценности, отобранные у её семьи нацистами несколько десятилетий назад.\",\n" +
                                "    \"type\": \"Полнометражный\",\n" +
                                "    \"genre\": \"Драма\",\n" +
                                "    \"date\": \"2015-02-15\"\n" +
                                "  },\n" +
                                "  {\n" +
                                "    \"id\": null,\n" +
                                "    \"title\": \"Очень странные дела\",\n" +
                                "    \"description\": \"1980-е годы, тихий провинциальный американский городок. Благоприятное течение местной жизни нарушает загадочное исчезновение подростка по имени Уилл.\",\n" +
                                "    \"type\": \"Сериал\",\n" +
                                "    \"genre\": \"Фантастика\",\n" +
                                "    \"date\": \"2016-07-11\"\n" +
                                "  },\n" +
                                "  {\n" +
                                "    \"id\": null,\n" +
                                "    \"title\": \"ДМБ \",\n" +
                                "    \"description\": \"Студент Штык соблазнил профессорскую жену, рабочий парень Бомба сжёг родной завод, завсегдатай казино Пуля скрывается от кредиторов. У всех одна дорога — на призывной пункт.\",\n" +
                                "    \"type\": \"Полнометражный\",\n" +
                                "    \"genre\": \"Комедия\",\n" +
                                "    \"date\": \"2000-03-31\"\n" +
                                "  }\n" +
                                "\n" +
                                "]")
                )
                .andExpect(status().isCreated());

        verify(movieService).saveMovies(ArgumentMatchers.anyList());
    }
}