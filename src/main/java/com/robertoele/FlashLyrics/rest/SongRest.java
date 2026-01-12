package com.robertoele.FlashLyrics.rest;

import com.robertoele.FlashLyrics.entities.Song;
import com.robertoele.FlashLyrics.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongRest {

    @Autowired
    private SongService service;

    @GetMapping("/songs")
    public ResponseEntity<Song[]> findSongs(
            @RequestParam(required = false, defaultValue = "false") boolean local,
            @RequestParam(required = false) String name,
            @RequestParam(name = "artist_name", required = false) String artistName
    ) {
        if(local) return ResponseEntity.ok(service.getAllLocal().toArray(new Song[0]));
        if(name == null && artistName == null) return ResponseEntity.badRequest().build();
        Song[] songs = service.getByNameAndArtistLocal(name, artistName);
        if(songs == null || songs.length == 0) songs = service.getByNameAndArtistOnline(name, artistName);
        if(songs == null || songs.length == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(songs);
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> findSong(@PathVariable Long id) {
        if(id == null) return ResponseEntity.badRequest().build();
        Song foundSong = service.getByIdLocal(id).orElse(service.getByIdOnline(id));
        if(foundSong == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(foundSong);
    }

    @DeleteMapping("/songs/{id}")
    public ResponseEntity<?> deleteSong(@PathVariable Long id) {
        Optional<Song> songToDelete = service.getByIdLocal(id);
        if(songToDelete.isPresent()) {
            service.delete(songToDelete.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
