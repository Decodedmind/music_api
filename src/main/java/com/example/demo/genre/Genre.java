package com.example.demo.genre;

import com.example.demo.song.Song;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @JsonIgnore
    @ManyToMany(mappedBy = "genres")
    private Set<Song> songs = new HashSet<>();

    public Genre() {

    }
    public Long getId() {
        return id;
    }

    public Genre(String genre) {
        this.name = genre;
    }

    public String getGenre() {
        return name;
    }

    public void setGenre(String genre) {
        this.name = genre;
    }


    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + name + '\'' +
                '}';
    }


}