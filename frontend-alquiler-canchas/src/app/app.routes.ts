import { Routes } from '@angular/router';
import { LoginComponent } from './auth/login.component';
import { LandingInicioComponent } from './Landingpage/inicio/landinginicio.component';
import { ReservaComponent } from './reservas/reserva.component'; // Ejemplo

export const routes: Routes = [
  { path: '', redirectTo: '/landing', pathMatch: 'full' }, // Página de inicio
  { path: 'landing', component: LandingInicioComponent },
  { path: 'reservas', component: ReservaComponent }, // Software de reservas
  { path: 'login', component: LoginComponent },
  // Otras rutas
];
