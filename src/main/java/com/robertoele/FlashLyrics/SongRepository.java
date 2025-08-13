package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.Nullable;

public interface SongRepository extends CrudRepository<Song, Long> {

    @Nullable
    Song[] getByNameAndArtistName(@Nullable String name, @Nullable String artistName);
}
