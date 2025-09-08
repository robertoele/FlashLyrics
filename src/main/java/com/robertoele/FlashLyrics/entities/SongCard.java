package com.robertoele.FlashLyrics.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "songCard")
public class SongCard {

    protected SongCard() {}

    public SongCard(Song song, String lyrics, String translation) {
        this.song = song;
        this.lyrics = lyrics;
        this.translation = translation;
    }

    public SongCard(Long id, Song song, String lyrics, String translation) {
        this.id = id;
        this.song = song;
        this.lyrics = lyrics;
        this.translation = translation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="song")
    @ManyToOne
    private Song song;

    private String lyrics;
    private String translation;

    public Long getId() { return id; }
    public Song getSong() { return song; }
    public String getTranslation() { return translation; }
    public String getLyrics() { return lyrics; }
}
