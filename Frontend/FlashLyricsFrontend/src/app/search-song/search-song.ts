import { Component, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Song } from '../entities/song';
import { SongArticle } from '../song-article/song-article';

@Component({
  selector: 'app-search-song',
  imports: [FormsModule, SongArticle],
  templateUrl: './search-song.html',
  styleUrl: './search-song.css'
})
export class SearchSong {
  name: string = "";
  artist: string = "";
  client = inject(HttpClient);
  baseUrl: string = "http://localhost:8080";
  songs: Song[] = [];
  searchSong() {
    this.client.get<Song[]>(this.baseUrl + "/songs?name=" + this.name + "&artist_name=" + this.artist).subscribe(songs => {
      console.log("Aki vuscando");
      this.songs = songs;
    });
  }
}
