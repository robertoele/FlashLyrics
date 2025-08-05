package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlashLyricsApplicationTests {

	@Autowired
	SongsClient client;

	@Test
	void no_songs_found() {
		Song[] emptySongs = client.requestSongsByName("cancion ke no etsisteeeeeA");
		assertNotNull(emptySongs);
        assertEquals(0, emptySongs.length);
	}
}
