package com.robertoele.FlashLyrics.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "song")
public class Song {
      @Id
      private Long id;
      @Column(name = "name")
      private String name;
      @Column(name = "trackName")
      private String trackName;
      @Column(name = "artistName")
      private String artistName;
      @Column(name = "albumName")
      private String albumName;
      @Column(name = "ration")
      private Long duration;
      @Column(name = " instrumental")
      private boolean instrumental;
      @Lob
      @Column(name = "plainLyrics", length = 1024)
      private String plainLyrics;
      @Lob
      @Column(name = "syncedLyrics", length = 1024)
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
