package com.example.demo.song;

import com.example.demo.artist.Artist;
import com.example.demo.genre.Genre;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Song {
    @jakarta.persistence.Id
    @Id
    @SequenceGenerator(
            name = "song_sequence",
            sequenceName = "songs_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_sequence"
    )
    private Long id;

    private String songTitle;
    private String artist;

    @ManyToMany
    @JoinTable(
            name = "genre_song",
            joinColumns = @JoinColumn(name = "song_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id",referencedColumnName = "id")
    private Artist artistName;

    public Song() {
    }


    public Song(String songTitle) {
        this.songTitle = songTitle;
    }


    public Song(Long id, String songTitle, String artist) {
        this.id = id;
        this.songTitle = songTitle;
        this.artist = artist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Set<Genre> getGenre() {
        return genres;
    }

    public void setGenre(Set<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", songTitle='" + songTitle + '\'' +
                ", artist='" + artist + '\'' +
                ", genres=" + genres +
                '}';
    }

    public void addGenre(Genre genre) {
        genres.add(genre);
    }

    public void addArtist(Artist artist) {
        this.artistName = artist;

    }}