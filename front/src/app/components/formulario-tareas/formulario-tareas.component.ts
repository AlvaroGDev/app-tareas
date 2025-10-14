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
  showToast = false;
  
  constructor(private TareaService: TareaServiceService) { }

  tarea: Tarea = {
    nombre: '',
    descripcion: '',
    estado: 'PENDIENTE',
    prioridad: 'MEDIA'
  };

  onSubmit() {
    this.TareaService.createTarea(this.tarea).subscribe({
      next: (response) => {
        // Mostrar el toast
        this.showToast = true;
        setTimeout(() => this.showToast = false, 3000); // Se oculta después de 3 segundos
        
        // Resetear el formulario
        this.tarea = {
          nombre: '',
          descripcion: '',
          estado: 'PENDIENTE',
          prioridad: 'MEDIA'
        };
      },
      error: (error) => {
        console.error('Error al crear la tarea:', error);
      }
    });
  }
}
