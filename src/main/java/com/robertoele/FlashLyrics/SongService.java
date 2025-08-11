package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SongService {

    @Autowired SongClient client;
    private final SongRepository repository;

    public SongService(SongRepository repository) {
        this.repository = repository;
    }

    public Song getByNameAndArtistLocal(String name, String artist) {
        Optional<Song> localSong = repository.findTopByNameAndArtistName(name, artist);
        return localSong.orElse(null);
    }

    public Song getByNameAndArtistOnline(String name, String artistName) {
        Song[] onlineSongs = client.requestSongsByNameAndArtist(name, artistName);
        if(onlineSongs.length == 0) return null;
        else return onlineSongs[0];
    }
}
