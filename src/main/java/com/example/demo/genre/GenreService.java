package com.example.demo.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    public void addNewGenre(Genre genre) {
        genreRepository.save(genre);
    }

    public void deleteGenre(Long genreId) {
        genreRepository.deleteById(genreId);
    }

    public void updateGenre(Long genreId, String genreName) {
        Genre genre = genreRepository.findById(genreId)
                .orElseThrow(() -> new IllegalArgumentException("Genre not found with ID: " + genreId));

        genre.setGenre(genreName);
        genreRepository.save(genre);
    }

    public Genre getOne(Long genreId) {
        return genreRepository.findById(genreId).get();
    }
}