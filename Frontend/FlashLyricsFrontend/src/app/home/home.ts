import { Component, Injectable, inject } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Song } from '../entities/song';
import { FormsModule } from '@angular/forms';
import { SourceTextModule } from 'vm';

@Component({
  selector: 'app-home',
  imports: [FormsModule],
  template: `
    <p>home works!</p>
    <p>Song name: <input id="songName" type="text" [(ngModel)]="songName"/></p>
    <p>Artist: <input id="artist" type="text" [(ngModel)]="artist"/></p>
    <button id="confirm" type="button" (click)="findSong()">Buscar</button>
    <p>Letra: {{this.lyrics}}</p>
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
  lyrics: string = "";

  findSong() {
    const params: HttpParams = new HttpParams().set("name", this.songName).set("artist_name", this.artist);
    this.client.get<Song[]>(this.base_url + "/songs", { params, headers: new HttpHeaders().set("Access-Control-Allow-Origin", "true") }).subscribe(songs => { 
      console.log("eys");
      this.lyrics = songs[0].plainLyrics;
    });
  }
}
