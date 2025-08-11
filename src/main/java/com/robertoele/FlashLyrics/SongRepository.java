package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SongRepository extends CrudRepository<Song, Long> {

    Optional<Song> findTopByNameAndArtistName(String name, String artistName);
    Song findTopByName(String name);
}
