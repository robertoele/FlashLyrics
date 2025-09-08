import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Song } from '../entities/song';
import { SongCardData, SongCardSent } from '../entities/songCardData';
import { SongCard } from '../song-card/song-card';
@Component({
  selector: 'song-details',
  imports: [SongCard],
  templateUrl: 'song-details.html',
  styleUrl: './song-details.css'
})
export class SongDetails {
  private base_url: string = "http://localhost:8080";
  route: ActivatedRoute = inject(ActivatedRoute);
  client: HttpClient = inject(HttpClient);
  songId = -1;
  song: Song | undefined;
  cards: SongCardData[] = [];

  constructor() {
    this.songId = parseInt(this.route.snapshot.params['id'], 10);
    this.client.get<Song>(this.base_url + "/songs/" + this.songId).subscribe(foundSong => {
      this.song = foundSong;
    });
    this.client.get<SongCardData[]>(this.base_url + "/songs/" + this.songId + "/cards").subscribe(cards => {
      this.cards = cards;
    });
  }

  saveSongCards() {
    if(typeof this.song !== 'undefined') {
      this.client.post<SongCardData[]>(this.base_url + "/songs/" + this.songId, "").subscribe(_ => { window.location.reload(); });
    }
  }
}
