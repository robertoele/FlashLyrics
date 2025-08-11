package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SongRest {

    @Autowired
    private SongRepository repository;
    @Autowired
    private SongService service;

    @GetMapping("/songs")
    public ResponseEntity<Song> findSongByNameAndArtist(
            @RequestParam String name,
            @RequestParam("artist_name") String artistName
    ) {
        Optional<Song> localSong = repository.findTopByNameAndArtistName(name, artistName);
        Song foundSong = localSong.orElse(service.getByNameAndArtistOnline(name, artistName));
        return foundSong != null ? ResponseEntity.ok().body(foundSong) : ResponseEntity.notFound().build();
    }

    @GetMapping("/songs")
    public ResponseEntity<Iterable<Song>> getLocalSongs() {
        return ResponseEntity.ok(repository.findAll());
    }
}
