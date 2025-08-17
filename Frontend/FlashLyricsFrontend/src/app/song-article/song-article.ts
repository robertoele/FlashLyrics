import { HttpClient } from '@angular/common/http';
import { Component, inject, input } from '@angular/core';
import { Song } from '../entities/song';
import { ActivatedRoute } from '@angular/router';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'song-article',
  imports: [RouterLink],
  template: `
  <article class="song" (click)="seeSong(this.song())">
    <h3 class="song-id">{{this.song().id}}</h3>
    <h2 class="song-heading"><a [routerLink]="['/song', this.song().id]">{{this.song().name}}</a></h2>
    <p class="song-artist">{{this.song().artistName}}</p>
  </article>
  `,
  styleUrl: './song-article.css'
})
export class SongDetails {
  client: HttpClient = inject(HttpClient);
  private route: ActivatedRoute = inject(ActivatedRoute);
  song = input.required<Song>();

  constructor() {
  }

  seeSong(songToSee: Song) {
    console.log("Me han clicao: " + songToSee.plainLyrics);
  }
}
