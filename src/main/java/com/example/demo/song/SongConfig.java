package com.example.demo.song;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class SongConfig {

    @Bean
    CommandLineRunner songCommandLineRunner(SongRepository repository) {
        return args -> {
            Song mojabiGhost = new Song(
                    1L,
                    "MojabiGhost",
                    "Bad Bunny"
            );
            Song dakiti = new Song(
                    2L,
                    "Dákiti",
                    "Bad Bunny ft. Jhay Cortez"
            );

            Song Angel = new Song(
                    3L,
                    "Angel",
                    "Shaggy"
            );

            Song tennesse = new Song(
                    4L,
                    "Talkin Tennesse",
                    "Morgan Wallen"
            );


            Song dontStartNow = new Song(
                    6L,
                    "Don't Start Now",
                    "Dua Lipa"
            );


            Song trust = new Song(
                    7L,
                    "Trust",
                    "Brent Faiyaz"
            );

            Song tooDeep = new Song(
                    8L,
                    "Too Deep For The Intro",
                    "J Cole "
            );



            Song madrid = new Song(
                    9L,
                    "Madrid",
                    "Maluma"
            );
            repository.saveAll(
                    List.of(mojabiGhost,dakiti,Angel,tennesse,dontStartNow,trust,tooDeep,madrid)
            );
        };
    }
}