import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { Song } from '../entities/song';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-song-details',
  imports: [],
  template: `
    <p>{{this.song?.plainLyrics}}</p>
  `,
  styleUrl: './song-details.css'
})
export class SongDetails {
  client: HttpClient = inject(HttpClient);
  private id: number;
  private route: ActivatedRoute = inject(ActivatedRoute);
  song: Song | undefined;

  constructor() {
    this.id = parseInt(this.route.snapshot.params['id'], 10);
    this.client.get<Song>(`http://localhost:8080/songs&id=${this.id}`).subscribe(foundSong => {
      this.song = foundSong;
    });
  }
}
