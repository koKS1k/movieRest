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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Schema(description = "Информация о фильме")
@Entity
public class Movie {

    public static final List<String> typelist = Collections.unmodifiableList(
            new ArrayList<String>() {{
                add("Полнометражный");
                add("Короткометражный");
                add("Сериал");
            }});

    @Id
    @Schema(description = "Идентификатор")
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Название не может быть пустым")
    @Size(min = 4, message = "Минимум 4 символа в названии")
    @Schema(description = "Название")
    private String title;

    @Schema(description = "Описание")
    private String description;

    @Column(nullable = false)
    @NotBlank(message = "Тип не может быть пустым")
    @Schema(description = "Тип")
    private String type;

    @Schema(description = "Жанр")
    private String genre;

    @Column(nullable = false)
    @Schema(description = "Дата премьеры")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Yekaterinburg")
    private LocalDate date;

    public Movie(String title, String description, String type, String genre, LocalDate date) {

        if(typelist.contains(type))
            this.type = type;
        else
            throw new IllegalArgumentException("Неверно указан тип фильма");

        this.title = title;
        this.description = description;
        this.genre = genre;
        this.date = date;
    }
}

