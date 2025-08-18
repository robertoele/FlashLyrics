package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.clients.SongClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FlashLyricsApplicationTests {

	@Autowired
    SongClient client;

}
