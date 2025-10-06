import { Component } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Tarea } from '../../models/tarea.model';

import { FormsModule } from '@angular/forms';
import { TareaServiceService } from '../../services/tarea-service.service';

@Component({
  selector: 'app-formulario-tareas',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './formulario-tareas.component.html',
  styleUrl: './formulario-tareas.component.css'
})
export class FormularioTareasComponent {

  constructor(private TareaService: TareaServiceService) { }

  tarea: Tarea = {
    nombre: '',
    descripcion: '',
    estado: 'PENDIENTE',
    prioridad: 'MEDIA'
  };

  onSubmit() {
    // Aquí puedes manejar el guardado de la tarea
    this.TareaService.createTarea(this.tarea).subscribe(response => {
      alert('Tarea guardada: ' + JSON.stringify(response));
    });

    // Resetear el formulario si quieres
    this.tarea = {
      nombre: '',
      descripcion: '',
      estado: 'PENDIENTE',
      prioridad: 'MEDIA'
    };
  }
}
