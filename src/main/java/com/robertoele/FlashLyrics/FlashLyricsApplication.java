package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlashLyricsApplication {

	@Autowired
	private SongService service;

	public static void main(String[] args) {
		SpringApplication.run(FlashLyricsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner() {
		Song ascheZuAsche = service.getByNameAndArtistOnline("Asche zu Asche", "Rammstein");
		return _ -> System.out.println(ascheZuAsche.getPlainLyrics());
	}
}
