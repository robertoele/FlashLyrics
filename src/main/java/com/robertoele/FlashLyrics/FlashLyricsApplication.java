package com.robertoele.FlashLyrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlashLyricsApplication {

	@Autowired
	private SongsClient client;

	public static void main(String[] args) {
		SpringApplication.run(FlashLyricsApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return _ -> System.out.println(client.getLyricsBySongName("Sehnsucht"));
	}
}
