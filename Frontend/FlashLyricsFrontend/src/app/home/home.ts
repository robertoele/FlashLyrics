import { Component, Injectable, inject } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Song } from '../entities/song';
import { FormsModule } from '@angular/forms';
import { SongArticle } from '../song-article/song-article';

@Component({
  selector: 'app-home',
  imports: [FormsModule, SongArticle],
  templateUrl: 'home.html',
  styleUrl: './home.css'
})
@Injectable({providedIn: 'root'})
export class Home {
  private base_url: string = "http://localhost:8080"
  private client: HttpClient = inject(HttpClient);
  songName: string = "";
  artist: string = "";
  songs: Song[] = [];

  constructor() {
    const params: HttpParams = new HttpParams().set("local", true);
    this.client.get<Song[]>(this.base_url + "/songs", { params }).subscribe(songs => {
      this.songs = songs;
    });
  }

  findSong() {
    const params: HttpParams = new HttpParams().set("name", this.songName).set("artist_name", this.artist);
    this.client.get<Song[]>(this.base_url + "/songs", { params }).subscribe(songs => { 
      this.songs = songs;
    });
  }
}
