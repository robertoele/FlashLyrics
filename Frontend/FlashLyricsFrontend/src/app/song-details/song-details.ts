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
    var songCards = this.song?.plainLyrics.split("\n") || [];
    if(typeof this.song !== 'undefined') {
      var cards = songCards.filter(lyrics => lyrics.length !== 0).map(lyrics => new SongCardSent(this.song!!, lyrics));
      this.client.post<SongCardData[]>(this.base_url + "/songs/" + this.songId, cards).subscribe(coso => {
      });
    }
  }
  
}
