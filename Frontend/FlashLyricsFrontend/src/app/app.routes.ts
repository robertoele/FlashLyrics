import { Routes } from "@angular/router";
import { Home } from "./home/home";
import { SongDetails } from "./song-details/song-details";
import { SongEditing } from "./song-editing/song-editing";
import { SearchSong } from "./search-song/search-song";

const routeConfig: Routes = [
    {
        path: '',
        component: Home,
        title: 'Página de inicio'
    },
    {
        path: 'songs/:id/edit',
        component: SongEditing,
        title: 'Editar canción'
    },
    {
        path: 'songs/:id',
        component: SongDetails,
        title: 'Detalles de la canción'
    },
    {
        path: 'search',
        component: SearchSong,
        title: 'Buscar canción'
    }

]

export default routeConfig;
