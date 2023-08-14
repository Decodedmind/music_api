package com.example.demo.song;

import com.example.demo.artist.Artist;
import com.example.demo.artist.ArtistService;
import com.example.demo.genre.Genre;
import com.example.demo.genre.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/song")
public class SongController {

    private SongService songService;

    private final GenreService genreService;

    private final ArtistService artistService;

    @Autowired
    public SongController(SongService songService, GenreService genreService, ArtistService artistService) {
        this.songService = songService;
        this.genreService = genreService;
        this.artistService = artistService;
    }

    @PostMapping(path = "{songId}")
    public void createNewSong(@PathVariable("songId") Long songId, @RequestBody Song song) {
        song.setId(songId);
        songService.addNewSong(song);
    }

    @GetMapping(path = "{songId}")
    public Optional<Song> findSongBySongId(@PathVariable("songId") Long songId) {
        return songService.findSongBySongId(songId);
    }

    @GetMapping
    public List<Song> getSongs() {
        return songService.getSongs();
    }

    @PostMapping
    public void addNewSong(@RequestBody Song song) {
        songService.addNewSong(song);
    }

    @DeleteMapping(path = "{songId}")
    public void deleteSong(@PathVariable("songId") Long songId) {
        songService.deleteSong(songId);
    }

    @PutMapping(path = "{songId}")
    public void updateSong(
            @PathVariable("songId") Long songId,
            @RequestParam(required = false) String songTitle,
            @RequestParam(required = false) String artist,
            @RequestParam(required = false) String genre) {
        songService.updateSong(songId, songTitle, artist, genre);
    }


    @PutMapping("/{songId}/genres/{genreId}")
    Song genreToSong(

            @PathVariable Long songId,
            @PathVariable Long genreId
    ){
        Song song = songService.getOne(songId);
        Genre genre = genreService.getOne(genreId);

        if (song != null && genre != null) {
            song.addGenre(genre);
            return songService.save(song);
        } else {
            return null;
        }
    }

    @PutMapping("/{songId}/artist/{artistId}")
    Song genreToArtist(

            @PathVariable Long songId,
            @PathVariable Long artistId
    ){
        Song song = songService.getOne(songId);
        Artist artist = artistService.getOne(artistId);

        if (song != null && artist != null) {
            song.addArtist(artist);
            return songService.save(song);
        } else {
            return null;
        }
    }
}