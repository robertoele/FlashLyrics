import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from '../entities/song';
import { SongCard } from '../entities/songCard';
@Component({
  selector: 'song-details',
  imports: [],
  template: `
    <button (click)="saveSongCards()">Guardar</button>
    <h1 class="lyrics">{{this.song?.plainLyrics}}</h1>
  `,
  styleUrl: './song-details.css'
})
export class SongDetails {
  private base_url: string = "http://localhost:8080";
  route: ActivatedRoute = inject(ActivatedRoute);
  client: HttpClient = inject(HttpClient);
  songId = -1;
  song: Song | undefined;
  lyricsCards: String[] = [];
  constructor() {
    this.songId = parseInt(this.route.snapshot.params['id'], 10);
    this.client.get<Song>(this.base_url + "/songs/" + this.songId).subscribe(foundSong => {
      this.song = foundSong;
      this.lyricsCards = this.song.plainLyrics.split("/n");
    });
  }

  saveSongCards() {
    var songCards = this.song?.plainLyrics.split("\n") || [];
    if(typeof this.song !== 'undefined') {
      var cards = songCards.map(lyrics => new SongCard(this.song!!, lyrics));
      console.log(JSON.stringify(songCards));
      this.client.post<SongCard[]>(this.base_url + "/songs/" + this.songId, cards).subscribe(coso => {
        console.log("JKhkjasdjkhda");
      });
    }
  }
  
}
