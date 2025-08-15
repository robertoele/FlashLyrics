import { HttpClient } from '@angular/common/http';
import { Component, inject, input } from '@angular/core';
import { Song } from '../entities/song';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'song-details',
  imports: [],
  template: `
  <div>
    <p>Título: {{this.song()?.name}}</p>
    <p>Artista: {{this.song()?.artist}}</p>
    <p>Letra: {{this.song()?.plainLyrics}}</p>
  </div>
  `,
  styleUrl: './song-details.css'
})
export class SongDetails {
  client: HttpClient = inject(HttpClient);
  private id: number;
  private route: ActivatedRoute = inject(ActivatedRoute);
  song = input<Song>();

  constructor() {
    this.id = parseInt(this.route.snapshot.params['id'], 10);
  }
}
