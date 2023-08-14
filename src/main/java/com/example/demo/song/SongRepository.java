package com.example.demo.song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    // SELECT * FROM song WHERE songTitle = ?

    Optional<Song> findSongBySongTitle(String songTitle);

}