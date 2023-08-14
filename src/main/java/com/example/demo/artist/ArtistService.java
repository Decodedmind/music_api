package com.example.demo.artist;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public static long getOne(long GenreId) {
        return GenreId;
    }

    public List<Artist> getArtists() {
        return artistRepository.findAll();
    }

    public void addNewArtist(Artist artist) {
        artistRepository.save(artist);
    }


    public void deleteArtist(Long artistId) {
        boolean exists = artistRepository.existsById(artistId);
        if (!exists) {
            throw new IllegalStateException("Artist with id " + artistId + " does not exist");
        }

        artistRepository.deleteById(artistId);
    }

    @Transactional
    public void updateArtist(Long artistId, String name, String recordLabel) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new IllegalStateException("Artist with id " + artistId + " does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(artist.getName(), name)) {
            artist.setName(name);
        }

        if (recordLabel != null && recordLabel.length() > 0 && !Objects.equals(artist.getRecordLabel(), recordLabel)) {
            artist.setRecordLabel(recordLabel);
        }


    }

    public Artist getOne(Long artistId) {
        return artistRepository.findById(artistId).get();
    }

    public Optional<Artist> findArtistById(Long artistId) {
        return artistRepository.findById(artistId);
    }
}