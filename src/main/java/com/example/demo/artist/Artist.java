package com.example.demo.artist;

import com.example.demo.song.Song;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @JsonIgnore
    @OneToMany(mappedBy = "artistName")
    private Set<Song> songs = new HashSet<>();

    private String name;

    private String recordLabel;


    public Artist(long id,String name, String recordLabel) {
        this.id = id;
        this.name = name;
        this.recordLabel = recordLabel;
    }

    public Artist() {

    }


    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public void setRecordLabel(String recordLabel) {
        this.recordLabel = recordLabel;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", recordLabel='" + recordLabel + '\'' +
                '}';
    }


    public void setId(Long artistId) {
    }
}