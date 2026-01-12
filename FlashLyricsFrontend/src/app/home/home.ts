import { Component, Injectable, inject } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Song } from '../entities/song';
import { FormsModule } from '@angular/forms';
import { SongArticle } from '../song-article/song-article';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  imports: [FormsModule, SongArticle, RouterLink],
  templateUrl: 'home.html',
  styleUrl: './home.css'
})
@Injectable({providedIn: 'root'})
export class Home {
  private base_url: string = "http://localhost:8080"
  private client: HttpClient = inject(HttpClient);
  songs: Song[] = [];

  constructor() {
    const params: HttpParams = new HttpParams().set("local", true);
    this.client.get<Song[]>(this.base_url + "/songs", { params }).subscribe(songs => {
      this.songs = songs;
    });
  }

  deleteSong(song: Song) {
    const index = this.songs.indexOf(song, 0);
    if(index > -1) this.songs.splice(index, 1);
  }
}
