import { Component, OnInit, inject } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Song } from '../entities/song';
import { SongArticle } from '../song-article/song-article';
import { RouterLink } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search-song',
  imports: [FormsModule, SongArticle, RouterLink],
  templateUrl: './search-song.html',
  styleUrl: './search-song.css'
})
export class SearchSong implements OnInit {
  name: string = "";
  artist: string = "";
  route: ActivatedRoute = inject(ActivatedRoute);
  client = inject(HttpClient);
  baseUrl: string = "http://localhost:8080";
  songs: Song[] = [];

  ngOnInit(): void {
      this.route.queryParamMap.subscribe((params) => {
        this.name = params.get("name") || "";
        this.artist = params.get("artist") || "";
        if(this.name || this.artist) this.searchSong();
      });
  }

  searchSong() {
    this.client.get<Song[]>(this.baseUrl + "/songs?name=" + this.name + "&artist_name=" + this.artist).subscribe(songs => {
      this.songs = songs;
    });
  }
}
