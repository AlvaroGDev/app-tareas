import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, NgForm, ReactiveFormsModule, Validators } from '@angular/forms';
import { RouterLink, RouterLinkActive } from '@angular/router';
import { Persona } from '../../models/persona.model';
import { PersonaServiceService } from '../../services/persona-service.service';

@Component({
  selector: 'app-formulario-personas',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, FormsModule, NgFor, NgIf, ReactiveFormsModule],
  templateUrl: './formulario-personas.component.html',
  styleUrl: './formulario-personas.component.css'
})
export class FormularioPersonasComponent {

  showToast = false;
  personaForm: FormGroup;
  toastMessage = 'Persona creada con éxito';
  toastType: 'success' | 'error' = 'success'; 

  constructor(private personaService: PersonaServiceService, private fb: FormBuilder) {
    this.personaForm = this.fb.group({
      nombre: ['', [Validators.required, Validators.minLength(2)]],
      apellidos: ['', [Validators.required, Validators.minLength(2)]],
      departamento: ['IT', Validators.required],
      email: ['', [Validators.required, Validators.pattern(/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/)]]
    });
  }

  persona: Persona = {
    nombre: '',
    apellidos: '',
    departamento: 'IT',
    email: '',
    tareas: []
  };

  limpiarFormulario() {

  }

    mostrarToast(mensaje: string, tipo: 'success' | 'error') {
    this.toastMessage = mensaje;
    this.toastType = tipo;
    this.showToast = true;
    
    // Ocultar automáticamente después de 4 segundos
    setTimeout(() => {
      this.showToast = false;
    }, 4000);
  }

 onSubmit() {
    if (this.personaForm.valid) {
      const personaData = this.personaForm.value;
      
      this.personaService.createPersona(personaData).subscribe({
        next: (personaCreada) => {
          this.mostrarToast('Persona creada correctamente', 'success');
          this.personaForm.reset();
        },
        error: (error) => {
          console.error('Error creando persona:', error);
          this.mostrarToast('Error al crear la persona', 'error');
        }
      });
    } else {
      Object.keys(this.personaForm.controls).forEach(key => {
        this.personaForm.get(key)?.markAsTouched();
      });
    }
  }






}

