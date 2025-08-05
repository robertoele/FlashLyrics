package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.data.repository.CrudRepository;

public interface SongRepository extends CrudRepository<Song, Long> {
}
