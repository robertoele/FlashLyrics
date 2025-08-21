import { Component, inject, input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SongCardData } from '../entities/songCardData';
import { Song } from '../entities/song';
import { SongCardEditable } from '../song-card-editable/song-card-editable';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'song-editing',
  imports: [SongCardEditable],
  templateUrl: './song-editing.html',
  styleUrl: './song-editing.css'
})
export class SongEditing {
  client = inject(HttpClient);
  song = input.required<Song>();
  route = inject(ActivatedRoute);
  songCards: SongCardData[] = [];
  songId = -1;
  private base_url: string = "http://localhost:8080";
  constructor() {
    this.songId = parseInt(this.route.snapshot.params['id'], 10);
    this.client.get<SongCardData[]>(this.base_url + "/songs/" + this.songId + "/cards").subscribe(songCards => {
      this.songCards = songCards;
    });
  }

  saveChanges() {
    console.log("Me están pulsando");
    console.log(this.base_url + "/songs/" + this.songId);
    this.client.post<SongCardData[]>(this.base_url + "/songs/" + this.songId, this.songCards).subscribe(response => {
      
    });
  }
  
}
