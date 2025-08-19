import { Component, input } from '@angular/core';
import { Song } from '../entities/song';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'song-article',
  imports: [RouterModule],
  template: `
  <article class="song">
    <div>
      <h3 class="song-id">{{this.song().id}}</h3>
      <h2 class="song-heading">{{this.song().name}}</h2>
      <p class="song-artist">{{this.song().artistName}}</p>
    </div>
    <button [routerLink]="['/songs', song().id]">View</button>
    <button [routerLink]="['/songs', song().id, 'edit']">Edit</button>
  </article>
  `,
  styleUrl: './song-article.css'
})

export class SongArticle {
  song = input.required<Song>();
}
