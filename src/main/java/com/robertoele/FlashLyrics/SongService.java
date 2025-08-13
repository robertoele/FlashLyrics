package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService {

    @Autowired private SongClient client;
    @Autowired private SongRepository repository;

    public Song[] getByNameAndArtistLocal(String name, String artist) {
        return repository.getByNameAndArtistName(name, artist);
    }

    public Song[] getByNameAndArtistOnline(String name, String artistName) {
        return client.requestSongsByNameAndArtist(name, artistName);
    }
}
