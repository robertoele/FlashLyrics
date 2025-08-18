package com.robertoele.FlashLyrics.clients;


import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
public class SongClient {

    private final String BASE_URL = "https://lrclib.net/api/search?";
    private final RestTemplate template = new RestTemplate();

    public Song[] requestSongsByNameAndArtist(String name, String artistName) {
        if(artistName != null && name == null) return template.getForObject(BASE_URL + "q=" + artistName + "&artist_name=" + artistName, Song[].class);
        return template.getForObject(BASE_URL + "track_name=" + name + "&artist_name=" + artistName, Song[].class);
    }

    public Song requestSongById(Long id) {
        String ID_URL = "https://lrclib.net/api/get/";
        return template.getForObject(ID_URL + id, Song.class);
    }
}
