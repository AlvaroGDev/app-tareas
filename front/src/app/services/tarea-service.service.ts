import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Tarea } from '../models/tarea.model';

@Injectable({
  providedIn: 'root'
})
export class TareaServiceService {

  constructor(private httpClient: HttpClient) { }

  private apiUrl = '/api/tareas';

  getTareas() {
    return this.httpClient.get<Tarea[]>(this.apiUrl);
  }

  createTarea(tarea: Tarea) {
    return this.httpClient.post<Tarea>(this.apiUrl, tarea);
  }

  updateTarea(tarea: Tarea) {
    return this.httpClient.put<Tarea>(`${this.apiUrl}/${tarea.id}`, tarea);
  }

  deleteTarea(id: number) {
    return this.httpClient.delete(`${this.apiUrl}/${id}`);
  }
}
