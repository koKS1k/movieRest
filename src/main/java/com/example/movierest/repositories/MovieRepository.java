package com.example.movierest.repositories;

import com.example.movierest.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Movie findAllByTitle(String title);

    List<Movie> findAllByType(String type);

    List<Movie> findAllByDate(LocalDate date);

    Page<Movie> findAll(Pageable pageable);
}
