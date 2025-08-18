import { Routes } from "@angular/router";
import { Home } from "./home/home";
import { SongDetails } from "./song-details/song-details";

const routeConfig: Routes = [
    {
        path: '',
        component: Home,
        title: 'Página de inicio'
    },
    {
        path: 'songs/:id',
        component: SongDetails,
        title: 'Detalles de la canción'
    }
]

export default routeConfig;
