package com.robertoele.FlashLyrics.rest;

import com.robertoele.FlashLyrics.entities.Song;
import com.robertoele.FlashLyrics.entities.SongCard;
import com.robertoele.FlashLyrics.repositories.SongCardRepository;
import com.robertoele.FlashLyrics.repositories.SongRepository;
import com.robertoele.FlashLyrics.services.SongService;
import com.robertoele.FlashLyrics.services.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "false")
public class SongCardRest {

    @Autowired private SongCardRepository songCardRepository;
    @Autowired private SongRepository songRepository;
    @Autowired private SongService songService;
    @Autowired private TranslationService translationService;

    @GetMapping("/songs/{songId}/cards")
    ResponseEntity<SongCard[]>findSongCards(@PathVariable Long songId) {
        SongCard[] cards = songCardRepository.findAllBySongId(songId);
        if(cards.length == 0) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(cards);
    }

    @PostMapping("/songs/{songId}")
    ResponseEntity<Iterable<SongCard>> saveSongCards(@PathVariable Long songId) {
        if(!songRepository.existsById(songId)) songService.saveOnline(songId);
        Optional<Song> song = songService.getByIdLocal(songId);
        if(song.isPresent()) {

            SongCard[] cards = Arrays
                    .stream(song.get().getPlainLyrics().split("\n"))
                    .filter(verse -> !verse.isBlank())
                    .map(verse -> getSongCard(song.get(), verse))
                    .toArray(SongCard[]::new);

            songCardRepository.saveAll(Arrays.asList(cards));

            return ResponseEntity.created(
                    ServletUriComponentsBuilder
                            .fromCurrentRequest()
                            .path("cards")
                            .build()
                            .toUri()
            ).build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/songs/update")
    ResponseEntity<Iterable<SongCard>> updateCards(@RequestBody SongCard[] cards) {
        songCardRepository.saveAll(Arrays.stream(cards).toList());
        return ResponseEntity.noContent().build();
    }

    private SongCard getSongCard(Song song, String verse) {
        return new SongCard(song, verse, translationService.translate("en", verse).translatedText);
    }
}
