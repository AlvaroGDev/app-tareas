import { Persona } from './persona.model';

export interface Tarea {
  id?: number;
  nombre: string;
  descripcion: string;
  estado: 'PENDIENTE' | 'EN_PROGRESO' | 'COMPLETADA';
  prioridad: 'BAJA' | 'MEDIA' | 'ALTA';
  personaAsignada?: Persona | null;
}
