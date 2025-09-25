import { Component } from '@angular/core';
import { Persona } from '../../models/persona.model';
import { PersonaServiceService } from '../../services/persona-service.service';
import { HttpClientModule } from '@angular/common/http';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-pagina-inicio',
  standalone: true,
  imports: [HttpClientModule, NgFor],
  templateUrl: './pagina-inicio.component.html',
  styleUrl: './pagina-inicio.component.css'
})
export class PaginaInicioComponent {
  
  
  personas: Persona[] = [];

  constructor(private personaService: PersonaServiceService) { }

  ngOnInit(): void {
    this.personaService.getPersonas().subscribe(personas => {
      this.personas = personas;
    });
  }


}
