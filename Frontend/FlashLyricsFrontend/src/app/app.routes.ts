import { Routes } from "@angular/router";
import { Home } from "./home/home";
import { SongDetails } from "./song-details/song-details";
import { SongEditing } from "./song-editing/song-editing";

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
    }

]

export default routeConfig;
