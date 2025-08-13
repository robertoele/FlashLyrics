import { Component, Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Song } from '../entities/song';

@Component({
  selector: 'app-home',
  imports: [],
  template: `
    <p>home works!</p>
    <div contenteditable="true">{{this.songName}}</div>
  `,
  styleUrl: './home.css'
})
@Injectable({providedIn: 'root'})
export class Home {
  private client: HttpClient = inject(HttpClient);
  songName: String = "";
  songs: Song[] = [];
   song: Song | undefined;

  constructor() {
    this.client.get<Song>('http://localhost:8080/songs?name=engel&artist_name=rammstein').subscribe(song => {
      this.song = song;
    })
  }
}
