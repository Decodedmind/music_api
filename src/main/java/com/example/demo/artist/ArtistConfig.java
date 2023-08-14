package com.example.demo.artist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ArtistConfig {

    @Bean
    CommandLineRunner artistCommandLineRunner(ArtistRepository repository) {
        return args -> {
            Artist badBunny = new Artist(
                          1,
                    "Bad Bunny",
                    "Record"
            );
            Artist blackbear = new Artist(
                    2,
                    "Blackbear",
                    "Interscope Records"
            );

            Artist drake = new Artist(
                    3,
                    "Drake",
                    "Young Money Entertainment"
            );

            Artist dominic  = new Artist(
                    4,
                    "Dominic Fike",
                    "Columbia Records Record"
            );

            Artist Anthonyhamilton = new Artist(
                    5,
                    "Anthony Hamilton",
                    "soul Record"
            );







            repository.saveAll(List.of(badBunny,Anthonyhamilton,blackbear,dominic,drake));
        };
    }
}