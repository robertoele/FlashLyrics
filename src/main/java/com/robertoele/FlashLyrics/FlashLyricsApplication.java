package com.robertoele.FlashLyrics;

import com.robertoele.FlashLyrics.entities.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class FlashLyricsApplication {

	@Autowired
	private SongsClient client;

	public static void main(String[] args) {
		SpringApplication.run(FlashLyricsApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(SongRepository repository) {
		return args -> {
			Song[] songs = client.requestSongsByName("Engel");
			repository.saveAll(Arrays.stream(songs).toList());
			System.out.println(Arrays.stream(songs).findFirst().get().getPlainLyrics());
		};
	}
}
