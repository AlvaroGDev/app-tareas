import { Routes } from '@angular/router';
import { PaginaInicioComponent } from './components/pagina-inicio/pagina-inicio.component';
import { FormularioTareasComponent } from './components/formulario-tareas/formulario-tareas.component';
import { FormularioPersonasComponent } from './components/formulario-personas/formulario-personas.component';

export const routes: Routes = [
    { path: '', pathMatch: 'full', redirectTo: '/inicio' },
    { path: 'inicio', component: PaginaInicioComponent },
    { path: 'tareas', component: FormularioTareasComponent },
    { path: 'personas', component: FormularioPersonasComponent }
];
