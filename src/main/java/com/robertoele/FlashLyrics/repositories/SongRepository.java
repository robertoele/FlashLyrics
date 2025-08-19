package com.robertoele.FlashLyrics.repositories;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.lang.NonNullApi;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends ListCrudRepository<Song, Long> {

    @Nullable
    Song[] getByNameAndArtistName(@Nullable String name, @Nullable String artistName);
}
