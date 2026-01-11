import { Component, inject, input } from '@angular/core';
import { Song } from '../entities/song';
import { RouterModule } from '@angular/router';
import { MatIconModule } from '@angular/material/icon';
import { HttpClient } from '@angular/common/http';
import { log } from 'console';
@Component({
  selector: 'song-article',
  imports: [RouterModule, MatIconModule],
  template: `
  <article class="song">
    <div class="song-column data">
      <h2 class="song heading">{{this.song().name}}</h2>
      <p class="song artist">{{this.song().artistName}}</p>
    </div>
    <div class="song-column buttons">
      <button class="primary" [routerLink]="['/songs', song().id]">View</button>
      @if (edit()) {
        <button class="primary" [routerLink]="['/songs', song().id, 'edit']">Edit</button>
      }
      <button class="tertiary" (click)="deleteSong(song().id)">
        <mat-icon class="material-symbols-outlined" fontIcon="delete"></mat-icon>
      </button>
    </div>
  </article>
  `,
  styleUrl: './song-article.css'
})



export class SongArticle {
  song = input.required<Song>();
  edit = input.required<Boolean>();
  client = inject(HttpClient);
  private base_url: string = "http://localhost:8080";

  deleteSong(songId: number) {
    this.client.delete(this.base_url + "/songs/" + songId).subscribe(response => {
        
    });
  }

}
