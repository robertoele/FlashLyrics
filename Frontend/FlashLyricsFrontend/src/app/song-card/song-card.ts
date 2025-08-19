import { Component, input } from '@angular/core';
import { SongCardData } from '../entities/songCardData';

@Component({
  selector: 'song-card',
  imports: [],
  templateUrl: './song-card.html',
  styleUrl: './song-card.css'
})
export class SongCard {
  data = input.required<SongCardData>();
  flip: boolean = false;

  toggleFlip() {
    this.flip = !this.flip;
  }
}
