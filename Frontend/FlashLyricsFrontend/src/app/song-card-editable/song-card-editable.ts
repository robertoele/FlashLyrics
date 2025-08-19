import { Component, input } from '@angular/core';
import { SongCardData } from '../entities/songCardData';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'song-card-editable',
  imports: [FormsModule],
  templateUrl: './song-card-editable.html',
  styleUrl: './song-card-editable.css'
})
export class SongCardEditable {
  cardData = input.required<SongCardData>();
}
