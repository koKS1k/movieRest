# NotesApp

## 1. Задание
        
Текст [задания](./Task.md) в корне проекта.

## 2. Описание

Приложение написано на  Java с использованием фреймворка _**Spring Boot**_. Основные компоненты приложения:

- **Spring boot.** &ensp;Для быстрой сборки и автоконфигурации.
- **Spring Data.** &ensp;Для работы с БД.
- **Spring Web.**  &ensp;Для создания локального сервера и диспетчера сервлетов.
- **H2.** &ensp;База данных.
- **Spring Doc.** &ensp;Для создания документации _**OpenAPI**_ REST-сервиса.

Основные компоненты проекта **_src_**:

```

└── src/ 
   ├───main
│   ├───java
│   │   └───com
│   │       └───example
│   │           └───movierest
│   │               │   MovieRestApplication.java           # main.
│   │               │
│   │               ├───configurations                      # Конфигурации. 
│   │               │       RequestLoggingFilterConfig.java # Конфигурация для логгирования запросов.
│   │               │       StartConfiguration.java         # Инициализация БД при запуске приложения через CommandLineRunner .
│   │               │
│   │               ├───controller                          # Контроллеры
│   │               │       ExceptionController.java        # Контроллер обработки ошибок.
│   │               │       MovieController.java            # Основной контроллер обработки пользовательских запросов.
│   │               │
│   │               ├───exceptionHandlers                   # Каталог классов конфигураций.
│   │               │       CustomExceptionHandler.java     # Обработчик ошибок.
│   │               │       MyException.java                # Класс кастомной ошибки (Пример).
│   │               │       ResponseError.java              # Класс respons'а, содержащего данные об ошибке.
│   │               │
│   │               ├───model                               # Сущности
│   │               │       Movie.java                      # Класс сущности фильма.
│   │               │
│   │               ├───repositories                        # Репозитории
│   │               │       MovieRepository.java            # Репозиторий для БД(H2) фильмов.
│   │               │
│   │               └───services                            # Сервисы
│   │                       ExceptionService.java           # Сервия генерации ошибки.
│   │                       MovieService.java               # Основной сервис для работы с фильмами.
│   │
│   └───resources
│          application.properties                          # Свойства проекта
│          data1.sql                                       # Если убдрать 1, то БД будет заполнятсья данными из файла при запуске
│       
│       
└───test
    └───java
        └───com
            └───example
                └───movierest
                        MovieRestApplicationTests.java  
                                 

```

Также несколько важных файлов  в корневом каталоге проекта _**/movieRest/**_ :
1. Тестовые [запросы](./HTTP_requests.http).
2. Файл сохранения [логов](./log.txt).

## 3.Быстрый старт

1) Подгрузить зависимости Maven. 
2) Поменять, при необходимости, основные [свойства](./src/main/resources/application.properties) приложения (например **_server.port_**):

```properties
#SERVER
server.port=8190

#DB
spring.h2.console.enabled=true
spring.h2.console.path=/h2

spring.datasource.url=jdbc:h2:mem:moviedb;DB_CLOSE_DELAY=-1
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true

#Actuator
management.endpoints.web.exposure.include=*
management.endpoint.health.show-details=always

#Logger
logging.file.path=/
logging.file.name=log.txt
logging.level.com.example.movierest=trace
logging.level.root=info
logging.level.org.springframework.web.filter.CommonsRequestLoggingFilter=DEBUG
```

3) В _**/movieRest/target/**_ &ensp;  сформирован jar-файл movieRest-0.0.1-SNAPSHOT.jar. Запустить можно из командной строки java -jar.
4) Документация Open Api находится по стандартному адресу _**http://localhost:8190/swagger-ui/index.html**_



   
