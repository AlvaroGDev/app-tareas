import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, NgForm, ReactiveFormsModule, Validators } from '@angular/forms';
import { Tarea } from '../../models/tarea.model';
import { TareaServiceService } from '../../services/tarea-service.service';

@Component({
  selector: 'app-formulario-tareas',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './formulario-tareas.component.html',
  styleUrl: './formulario-tareas.component.css'
})
export class FormularioTareasComponent {
  showToast = false;
  tareaForm: FormGroup;
  
  constructor(private TareaService: TareaServiceService, private fb: FormBuilder) { 
    this.tareaForm = this.fb.group({
      nombre: ['', Validators.required],
      descripcion: ['', Validators.required],
      estado: ['PENDIENTE', Validators.required],
      prioridad: ['MEDIA', Validators.required]
    });

  }

  tarea: Tarea = {
    nombre: '',
    descripcion: '',
    estado: 'PENDIENTE',
    prioridad: 'MEDIA'
  };

  onSubmit() {
    if (this.tareaForm.valid) {
      this.TareaService.createTarea(this.tareaForm.value).subscribe({
        next: (response) => {
          // Mostrar el toast
          this.showToast = true;
          setTimeout(() => this.showToast = false, 3000); // Se oculta después de 3 segundos
          this.tareaForm.reset();
        
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
}
