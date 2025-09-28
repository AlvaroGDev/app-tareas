import { Component, NgModule } from '@angular/core';
import { Persona } from '../../models/persona.model';
import { PersonaServiceService } from '../../services/persona-service.service';
import { HttpClientModule } from '@angular/common/http';
import { NgFor, NgIf } from '@angular/common';
import { Tarea } from '../../models/tarea.model';
import { TareaServiceService } from '../../services/tarea-service.service';
import { FormsModule, NgModel } from '@angular/forms';

@Component({
  selector: 'app-pagina-inicio',
  standalone: true,
  imports: [HttpClientModule, NgFor, NgIf, FormsModule],
  templateUrl: './pagina-inicio.component.html',
  styleUrl: './pagina-inicio.component.css'
})
export class PaginaInicioComponent {

  personas: Persona[] = [];
  tareas: Tarea[] = [];
  personaSeleccionada: { [tareaId: number]: Persona | null } = {};

  constructor(private personaService: PersonaServiceService, private tareaService: TareaServiceService) { }

  ngOnInit(): void {
    this.personaService.getPersonas().subscribe(personas => {
      this.personas = personas;
    });

    this.tareaService.getTareas().subscribe(tareas => {
      this.tareas = tareas;
    });
  }

  tareasSinAsignacion() {
    return this.tareas.filter(t => t.personaAsignada === null && t.estado === 'PENDIENTE');
  }

  tareasPendientes() {
    return this.tareas.filter(t => t.personaAsignada !== null && t.estado === 'PENDIENTE');
  }

  tareasCompletadas() {
    return this.tareas.filter(t => t.estado === 'COMPLETADA');
  }

  asignarTarea(tarea: Tarea){
    const persona = this.personaSeleccionada[tarea.id!];
    if (persona) {
      tarea.personaAsignada = persona;
      this.tareaService.updateTarea(tarea).subscribe();
    }
  }
}
