package com.robertoele.FlashLyrics.services;

import com.robertoele.FlashLyrics.clients.SongClient;
import com.robertoele.FlashLyrics.entities.Song;
import com.robertoele.FlashLyrics.repositories.SongCardRepository;
import com.robertoele.FlashLyrics.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    @Autowired private SongClient client;
    @Autowired private SongRepository repository;
    @Autowired private SongCardRepository cardRepository;

    public Song[] getByNameAndArtistLocal(String name, String artist) {
        return repository.getByNameAndArtistName(name, artist);
    }

    public List<Song> getAllLocal() {
        return repository.findAll();
    }

    public Optional<Song> getByIdLocal(Long id) {
        return repository.findById(id);
    }

    public Song getByIdOnline(Long id) {
        return client.requestSongById(id);
    }

    public Song[] getByNameAndArtistOnline(String name, String artistName) {
        return client.requestSongsByNameAndArtist(name, artistName);
    }

    public void saveOnline(Long id) {
        Song newSong = getByIdOnline(id);
        if(newSong != null) repository.save(newSong);
    }

    @Transactional
    public void delete(Song songToDelete) {
        cardRepository.deleteAllBySongId(songToDelete.getId());
        repository.delete(songToDelete);
    }
}
