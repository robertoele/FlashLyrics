package com.robertoele.FlashLyrics;


import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class SongsClient {

    private final String BASE_URL = "https://lrclib.net/api/search?";
    private final RestTemplate template = new RestTemplate();

    public Song[] requestSongsByName(String name) {
        Song[] songs = template.getForObject(BASE_URL + "track_name=" + name, Song[].class);
        return songs;
    }
}
