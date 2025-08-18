import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from '../entities/song';

@Component({
  selector: 'song-details',
  imports: [],
  template: '<h1>{{this.song?.plainLyrics}}</h1>',
  styleUrl: './song-details.css'
})
export class SongDetails {
  private base_url: string = "http://localhost:8080";
  route: ActivatedRoute = inject(ActivatedRoute);
  client: HttpClient = inject(HttpClient);
  songId = -1;
  song: Song | undefined;

  constructor() {
    this.songId = parseInt(this.route.snapshot.params['id'], 10);
    this.client.get<Song>(this.base_url + "/songs/" + this.songId).subscribe(foundSong => {
      this.song = foundSong;
    });
  }
}
