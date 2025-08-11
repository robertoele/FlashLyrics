package com.robertoele.FlashLyrics;


import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class SongClient {

    private final String BASE_URL = "https://lrclib.net/api/search?";
    private final RestTemplate template = new RestTemplate();

    public Song[] requestSongsByName(String name) {
        return template.getForObject(BASE_URL + "track_name=" + name, Song[].class);
    }

    public Song[] requestSongsByArtist(String artistName) {
        return template.getForObject(BASE_URL + "artist_name" + artistName, Song[].class);
    }

    public Song[] requestSongsByNameAndArtist(String name, String artistName) {
        return template.getForObject(BASE_URL + "track_name=" + name + "&artist_name=" + artistName, Song[].class);
    }
}
