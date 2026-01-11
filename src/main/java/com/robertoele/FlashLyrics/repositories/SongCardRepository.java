package com.robertoele.FlashLyrics.repositories;

import com.robertoele.FlashLyrics.entities.SongCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongCardRepository extends CrudRepository<SongCard, Long> {

    SongCard[] findAllBySongId(Long song);
    void deleteAllBySongId(Long song);
}
