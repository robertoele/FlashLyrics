import { Song } from "./song";

export class SongCard {
    song: Song;
    lyrics: string;
    translation: string;

    constructor(song: Song, lyrics: string) {
        this.song = song;
        this.lyrics = lyrics;
        this.translation = "";
    }
}