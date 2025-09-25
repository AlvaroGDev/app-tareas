import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Persona } from '../models/persona.model';

@Injectable({
  providedIn: 'root'
})
export class PersonaServiceService {

  private apiUrl = '/api/personas';
  
  constructor(private httpClient: HttpClient) { }

  getPersonas() {
    return this.httpClient.get<Persona[]>(this.apiUrl);
  }

  createPersona(persona: Persona) {
    return this.httpClient.post<Persona>(this.apiUrl, persona);
  }

  updatePersona(persona: Persona) {
    return this.httpClient.put<Persona>(`${this.apiUrl}/${persona.id}`, persona);
  }

  deletePersona(id: number) {
    return this.httpClient.delete(`${this.apiUrl}/${id}`);
  }
}
