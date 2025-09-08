package com.robertoele.FlashLyrics.entities;


import jakarta.persistence.*;

import java.util.Arrays;

@Entity
@Table(name = "song")
public class Song {
      @Id
      private Long id;
      @Column(name = "name")
      private String name;
      @Column(name = "track_name")
      private String trackName;
      @Column(name = "artist_name")
      private String artistName;
      @Column(name = "album_name")
      private String albumName;
      @Column(name = "duration")
      private Long duration;
      @Column(name = " instrumental")
      private boolean instrumental;
      @Lob
      @Column(name = "plain_lyrics", length = 1024)
      private String plainLyrics;
      @Lob
      @Column(name = "synced_lyrics", length = 1024)
      private String syncedLyrics;

      protected Song() {}

      public Song(
            String name,
            String trackName,
            String artistName,
            String albumName,
            Long duration,
            boolean instrumental,
            String plainLyrics,
            String syncedLyrics
      ) {
            this.name = name;
            this.trackName = trackName;
            this.artistName = artistName;
            this.albumName = albumName;
            this.duration = duration;
            this.instrumental = instrumental;
            this.plainLyrics = plainLyrics;
            this.syncedLyrics = syncedLyrics;
      }

      public Long getId() { return id; }
      public String getName() { return name; }
      public String getTrackName() { return trackName; }
      public String getArtistName() { return artistName; }
      public String getAlbumName() { return albumName; }
      public Long getDuration() { return duration; }
      public boolean getInstrumental() { return instrumental; }
      public String getPlainLyrics() { return plainLyrics; }
      public String getSyncedLyrics() { return syncedLyrics; }
}
