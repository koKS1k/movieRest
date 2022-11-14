package com.example.movierest.configurations;

import com.example.movierest.model.Movie;
import com.example.movierest.repositories.MovieRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class StartConfiguration {

    @Bean
    public CommandLineRunner commandLineRunner(MovieRepository movieRepository){
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
                             ),

                        new Movie(
                                /*title*/"Побег из Шоушенка",
                                /*description*/"Бухгалтер Энди Дюфрейн обвинён в убийстве собственной жены и её любовника.",
                                /*type*/"Полнометражный",
                                /*genre*/"Драма",
                                /*date*/LocalDate.of(1994, 9, 10)
                             ),

                        new Movie(
                                /*title*/"Идентификация Борна",
                                /*description*/"Потерявший память герой пытается узнать свое прошлое. Начало шпионской франшизы Дага Лаймана о супербойце ЦРУ",
                                /*type*/"Полнометражный",
                                /*genre*/"Боевик",
                                /*date*/LocalDate.of(2002, 6, 6)
                            ),

                        new Movie(
                                /*title*/"Папаши",
                                /*description*/"Мужчины ищут сбежавшего подростка, которого каждый считает своим сыном. Дуэт Пьера Ришара и Жерара Депардье",
                                /*type*/"Полнометражный",
                                /*genre*/"Комедия",
                                /*date*/LocalDate.of(1983, 11, 23)
                            ),

                        new Movie(
                                /*title*/"Молчание ягнят",
                                /*description*/"Интеллектуал-людоед помогает молодой сотруднице ФБР. Веха в жанре триллера — и гениальная игра Энтони Хопкинса",
                                /*type*/"Полнометражный",
                                /*genre*/"Триллер",
                                /*date*/LocalDate.of(1993, 1, 30)
                            ),

                        new Movie(
                                /*title*/"Девушка с татуировкой дракона",
                                /*description*/"Репортер и хакерша расследуют убийство. Мощная голливудская адаптация детективного бестселлера Стига Ларссона",
                                /*type*/"Полнометражный",
                                /*genre*/"Триллер",
                                /*date*/LocalDate.of(2011, 11, 12)
                            ),

                        new Movie(
                                /*title*/"Падал прошлогодний снег",
                                /*description*/"Давным-давно, в одной весьма пластилиновой местности, жил да был орёл-мужчина, которого как-то под новый год послала жена за ёлкой.",
                                /*type*/"Короткометражный",
                                /*genre*/"Мультфильм",
                                /*date*/LocalDate.of(1983, 12, 31)
                            ),

                        new Movie(
                                /*title*/"Белый Олеандр",
                                /*description*/"Астрид скитается по приемным семьям после ареста матери. Драма по бестселлеру Джанет Фитч с Мишель Пфайффер",
                                /*type*/"Полнометражный",
                                /*genre*/"Драма",
                                /*date*/LocalDate.of(2002, 9, 6)
                            ),

                        new Movie(
                                /*title*/"Невозможное",
                                /*description*/"Британская семья оказывается в эпицентре сокрушительного цунами. Драма о трагедии 2004 года с Наоми Уоттс",
                                /*type*/"Полнометражный",
                                /*genre*/"Драма",
                                /*date*/LocalDate.of(2012, 9, 9)
                            ),

                        new Movie(
                                /*title*/"Подтверждение",
                                /*description*/"Фильм об удивительной бесплатной парковке, бесплатных комплиментах и невероятной истории любви.",
                                /*type*/"Короткометражный",
                                /*genre*/"Комедия",
                                /*date*/LocalDate.of(2007, 3, 1)
                            ),

                        new Movie(
                                /*title*/"Книга джунглей",
                                /*description*/"История о дружбе мальчика с дикими животными. Восхитительная классика с задорными песнями и яркими танцами.",
                                /*type*/"Полнометражный",
                                /*genre*/"Мультфильм",
                                /*date*/LocalDate.of(1967, 10, 18)
                            ),

                        new Movie(
                                /*title*/"Робокоп",
                                /*description*/"Полицейский-киборг выходит патрулировать улицы Детройта. Питер Уэллер в фантастическом экшене Пола Верховен",
                                /*type*/"Полнометражный",
                                /*genre*/"Боевик",
                                /*date*/LocalDate.of(1987, 7, 17)
                            ),

                        new Movie(
                                /*title*/"Секретные материалы",
                                /*description*/"Агентам ФБР Дане Скалли и Фоксу Малдеру поручают работу над проектом «Секретные материалы». ",
                                /*type*/"Сериал",
                                /*genre*/"Фантастика",
                                /*date*/LocalDate.of(1997, 1, 1)
                            ),

                        new Movie(
                                /*title*/"Игра престолов",
                                /*description*/"Рыцари, мертвецы и драконы — в эпической битве за судьбы мира",
                                /*type*/"Сериал",
                                /*genre*/"Драма",
                                /*date*/LocalDate.of(2011, 4, 16)
                            ),

                        new Movie(
                                /*title*/"Хэллоуин",
                                /*description*/"Убийца-психопат Майкл Майерс, будучи ребенком, совершил убийство собственной сестры в Хэллоуин - День Всех Святых.",
                                /*type*/"Полнометражный",
                                /*genre*/"Ужасы",
                                /*date*/LocalDate.of(1978, 10, 25)
                            ),

                        new Movie(
                                /*title*/"Звонок",
                                /*description*/"Телефонный звонок раздаётся после просмотра некой загадочной видеокассеты. Жертве даётся ровно семь дней, а после следует неминуемая смерть.",
                                /*type*/"Полнометражный",
                                /*genre*/"Ужасы",
                                /*date*/LocalDate.of(2002, 10, 02)
                            ),

                        new Movie(
                                /*title*/"Кошмар на улице Вязов",
                                /*description*/"Четырём подросткам Спрингвуда снится один и тот же кошмарный сон, в котором за ними гонится и пытается убить человек с обожжённым лицом в шляпе и с ножами на руке.\t",
                                /*type*/"Полнометражный",
                                /*genre*/"Ужасы",
                                /*date*/LocalDate.of(1984, 11, 9)
                            ),

                        new Movie(
                                /*title*/"Мост",
                                /*description*/"История про обыкновенного человека, который однажды оказался перед трудным выбором.",
                                /*type*/"Короткометражный",
                                /*genre*/"Драма",
                                /*date*/LocalDate.of(2003, 1, 25)
                            ),

                        new Movie(
                                /*title*/"Гравити Фолз",
                                /*description*/"Близнецы проводят каникулы у странного прадядюшки. Тайны и аномалии в захватывающем мультсериале Алекса Хирша",
                                /*type*/"Сериал",
                                /*genre*/"Мультфильм",
                                /*date*/LocalDate.of(2013, 1, 4)
                            ),

                        new Movie(
                                /*title*/"Лучший стрелок",
                                /*description*/"Самоуверенный летчик-курсант влюбляется в инструкторшу. Патриотический экшен, сделавший Тома Круза звездой",
                                /*type*/"Полнометражный",
                                /*genre*/"Боевик",
                                /*date*/LocalDate.of(1986, 5, 12)
                        )

                );

        return args -> {
            movieRepository.saveAll(movieList);
        };
    }
}
