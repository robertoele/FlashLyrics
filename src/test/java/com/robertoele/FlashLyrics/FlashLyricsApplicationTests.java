package com.robertoele.FlashLyrics;

import entities.Song;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class FlashLyricsApplicationTests {

	private RestTemplate template = new RestTemplate();
	private TestRestTemplate testTemplate = new TestRestTemplate();
	private final String url = "https://lrclib.net/api/search?track_name=22&artist_name=taylor+swift";

	@Test
	void should_get_taylor_swift() {
		Song[] songs = template.getForObject(url, Song[].class);
        Assertions.assertNotNull(songs);
	}

}
