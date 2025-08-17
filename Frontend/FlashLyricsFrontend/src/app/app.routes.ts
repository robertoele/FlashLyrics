import { Routes } from "@angular/router";
import { Home } from "./home/home";
import { SongDetails } from "./song-article/song-article";

const routeConfig: Routes = [
    {
        path: '',
        component: Home,
        title: 'Página de inicio'
    },
    {
        path: 'song/:id',
        component: SongDetails,
        title: 'Detalles de la canción'
    }
]

export default routeConfig;
