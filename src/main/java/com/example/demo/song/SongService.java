package com.example.demo.song;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class SongService {
    private final SongRepository songRepository;
    @Autowired

    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getSongs() {
        return songRepository.findAll();
    }

    public Song getSong(long songId, long genreId) {
        return (Song) songRepository;
    }
    public void addNewSong(Song song) {
        Optional<Song> songOptional = songRepository.findById(song.getId());

        if (songOptional.isPresent()) {
            throw new IllegalStateException("Song with ID already exists");
        }

        songRepository.save(song);
    }

    public void deleteSong(Long songId) {
        boolean exists = songRepository.existsById(songId);
        if (!exists) {
            throw new IllegalStateException("Song with id " + songId + " does not exist");
        }

        songRepository.deleteById(songId);
    }

    @Transactional
    public void updateSong(Long songId, String songTitle, String artist, String genre) {
        Song song = songRepository.findById(songId)
                .orElseThrow(() -> new IllegalStateException("Song with id " + songId + " does not exist"));

        if (songTitle != null && songTitle.length() > 0 && !Objects.equals(song.getSongTitle(), songTitle)) {
            song.setSongTitle(songTitle);
        }

        if (artist != null && artist.length() > 0 && !Objects.equals(song.getArtist(), artist)) {
            song.setArtist(artist);
        }

        if (genre != null && genre.length() > 0 && !Objects.equals(song.getGenre(), genre)) {
            ;
        }
    }

    public Song getOne(Long songId) {
        return songRepository.findById(songId).get();
    }


    public Song save(Song song) {
        return songRepository.save(song);
    }

    public Optional<Song> findSongBySongId(Long songId) {
        return songRepository.findById(songId);
    }}

