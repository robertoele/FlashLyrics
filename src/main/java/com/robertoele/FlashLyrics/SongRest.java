package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SongRest {

    @Autowired
    private SongService service;

    @GetMapping("/songs")
    public ResponseEntity<Song[]> findSongs(
            @RequestParam(required = false) String name,
            @RequestParam(name = "artist_name", required = false) String artistName
    ) {
        if(name == null && artistName == null) return ResponseEntity.badRequest().build();
        Song[] songs = service.getByNameAndArtistLocal(name, artistName);
        if(songs == null || songs.length == 0) songs = service.getByNameAndArtistOnline(name, artistName);
        if(songs == null || songs.length == 0) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(songs);
    }
}
