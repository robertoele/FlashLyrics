package com.robertoele.FlashLyrics.rest;

import com.robertoele.FlashLyrics.entities.SongCard;
import com.robertoele.FlashLyrics.repositories.SongCardRepository;
import com.robertoele.FlashLyrics.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class SongCardRest {

    @Autowired
    private SongCardRepository songCardRepository;
    @Autowired
    private SongRepository songRepository;
    @GetMapping("/songs/{songId}/cards")
    ResponseEntity<SongCard[]>findSongCards(@PathVariable Long songId) {
        SongCard[] cards = songCardRepository.findAllBySongId(songId);
        if(cards.length == 0) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(cards);
    }

    @PostMapping("/songs/{songId}")
    ResponseEntity<Iterable<SongCard>> saveSongCards(@PathVariable Long songId, @RequestBody SongCard[] cards) {
        if(cards.length != 0) songRepository.save(cards[0].getSong());
        songCardRepository.saveAll(Arrays.asList(cards));
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("cards")
                        .build()
                        .toUri()
                ).build();
    }
}
