import { Song } from "./song";

export class SongCard {
    id: number;
    song: Song;
    lyrics: string;
    translation: string;

    constructor(id: number, song: Song, lyrics: string) {
        this.id = id;
        this.song = song;
        this.lyrics = lyrics;
        this.translation = "";
    }
}

export class SongCardSent {
    song: Song;
    lyrics: string;
    translation: string;

    constructor(song: Song, lyrics: string) {
        this.song = song;
        this.lyrics = lyrics;
        this.translation = "";
    }
}