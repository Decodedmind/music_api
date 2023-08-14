package com.example.demo.genre;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GenreConfig {

    @Bean
    CommandLineRunner genreCommandLineRunner(GenreRepository repository) {
        return args -> {
            Genre rap = new Genre("Rap");
            Genre rock = new Genre("Rock");
            Genre pop = new Genre("Pop");
            Genre country = new Genre("Country");
            Genre jazz = new Genre("Jazz");
            Genre electronic = new Genre("Electronic");
            Genre classical = new Genre("Classical");
            Genre reggae = new Genre("Reggae");
            Genre blues = new Genre("Blues");
            Genre metal = new Genre("Metal");
            Genre folk = new Genre("Folk");
            Genre RnB = new Genre("R&B");

            repository.saveAll(List.of(rap, rock, pop, country, jazz, electronic, classical, reggae, blues, metal, folk, RnB));
        };
    }
}