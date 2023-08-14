package com.example.demo.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/artist")
public class ArtistController {

    private final ArtistService artistService;

    @Autowired
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getArtists() {
        return artistService.getArtists();
    }

    @PostMapping
    public void addNewArtist(@RequestBody Artist artist) {
        artistService.addNewArtist(artist);
    }

    @DeleteMapping(path = "{artistId}")
    public void deleteArtist(@PathVariable("artistId") Long artistId) {
        artistService.deleteArtist(artistId);
    }

    @PutMapping(path = "{artistId}")
    public void updateArtist(
            @PathVariable("artistId") Long artistId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String recordLabel,
            @RequestParam(required = false) String genre) {
        artistService.updateArtist(artistId, name, recordLabel);
    }
    @GetMapping(path = "{artistId}")
    public Optional<Artist> findArtistById(@PathVariable("artistId") Long artistId) {
        return artistService.findArtistById(artistId);
    }
    @PostMapping(path = "{artistId}")
    public void createNewArtist(@PathVariable("artistId") Long artistId, @RequestBody Artist artist) {
        artist.setId(artistId);
        artistService.addNewArtist(artist);
    }

}