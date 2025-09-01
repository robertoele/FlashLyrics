import { RenderMode, ServerRoute } from '@angular/ssr';

export const serverRoutes: ServerRoute[] = [
  {
    path: '',
    renderMode: RenderMode.Prerender
  },
  {
    path: 'songs/:id/edit',
    renderMode: RenderMode.Server
  },
  {
    path: 'songs/:id',
    renderMode: RenderMode.Server
  },
  {
    path: 'search',
    renderMode: RenderMode.Prerender
  }
];
