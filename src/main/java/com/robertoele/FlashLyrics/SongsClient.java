package com.robertoele.FlashLyrics;


import entities.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Controller
public class SongsClient {

    private final RestTemplate template = new RestTemplate();

    public String getLyricsBySongName(String name) {
        Song[] songs = template.getForObject("https://lrclib.net/api/search?q=" + name, Song[].class);
        Optional<Song> songFound = Arrays.stream(songs)
                .filter(song -> song.plainLyrics() != null && !song.plainLyrics().isBlank())
                .findFirst();
        return songFound.get().plainLyrics();
    }
}
