package entities;

public record Song(
      Long id,
      String name,
      String trackName,
      String artistName,
      String albumName,
      Long duration,
      boolean instrumental,
      String plainLyrics,
      String syncedLyrics
) {
}
