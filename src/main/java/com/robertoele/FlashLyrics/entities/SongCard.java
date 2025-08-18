package com.robertoele.FlashLyrics.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "songCard")
public class SongCard {

    protected SongCard() {}

    public SongCard(Long id, Song song, Long songId, String lyrics, String translation) {
        this.id = id;
        this.song = song;
        this.songId = songId;
        this.lyrics = lyrics;
        this.translation = translation;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name="song_id", insertable = false, updatable = false)
    @ManyToOne(targetEntity = Song.class, fetch = FetchType.EAGER)
    private Song song;

    @Column(name="song_id")
    private Long songId;
    private String lyrics;
    private String translation;

    public Long getId() { return id; }
    public Song getSong() { return song; }
    public String getTranslation() { return translation; }
    public String getLyrics() { return lyrics; }
}
