import { Component, Injectable, inject } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Song } from '../entities/song';
import { FormsModule } from '@angular/forms';
import { SongArticle } from '../song-article/song-article';

@Component({
  selector: 'app-home',
  imports: [FormsModule, SongArticle],
  template: `

    <p>Song name</p>
    <input id="songName" type="text" [(ngModel)]="songName"/>
    <p>Artist</p>
    <input id="artist" type="text" [(ngModel)]="artist"/>
    <button id="confirm" type="button" (click)="findSong()">Buscar</button>
    @for(song of songs; track song.id) {
      <song-article [song]="song"/>
    }
  `,
  styleUrl: './home.css'
})
@Injectable({providedIn: 'root'})
export class Home {
  private base_url: string = "http://localhost:8080"
  private client: HttpClient = inject(HttpClient);
  songName: string = "";
  artist: string = "";
  songs: Song[] = [];

  findSong() {
    const params: HttpParams = new HttpParams().set("name", this.songName).set("artist_name", this.artist);
    this.client.get<Song[]>(this.base_url + "/songs", { params, headers: new HttpHeaders().set("Access-Control-Allow-Origin", "true") }).subscribe(songs => { 
      this.songs = songs;
    });
  }
}
