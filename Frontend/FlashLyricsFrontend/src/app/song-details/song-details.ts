import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'song-details',
  imports: [],
  template: '<h1>Detalles de la canción</h1>',
  styleUrl: './song-details.css'
})
export class SongDetails {
  route: ActivatedRoute = inject(ActivatedRoute);
  songId = -1;

  constructor() {
    this.songId = parseInt(this.route.snapshot.params['id'], 10);
  }
}
