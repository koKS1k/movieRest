package com.example.movierest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Информация о фильме")
@Entity
public class Movie {

    @Id
    @Schema(description = "Идентификатор")
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @Schema(description = "Название")
    private String title;

    @Schema(description = "Описание")
    private String description;

    @Column(nullable = false)
    @Schema(description = "Тип")
    private String type;

    @Schema(description = "Жанр")
    private String genre;

    @Column(nullable = false)
    @Schema(description = "Дата премьеры")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Yekaterinburg")
    private LocalDate date;


    public Movie(String title, String description, String type, String genre, LocalDate date) {

        if(type.equals("Полнометражный")||type.equals("Короткометражный")||type.equals("Сериал"))
            this.type = type;
        else
            throw new IllegalArgumentException("Неверно указан тип фильма");

        this.title = title;
        this.description = description;
        this.genre = genre;
        this.date = date;
    }
}

