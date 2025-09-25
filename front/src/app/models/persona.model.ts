import { Tarea } from "./tarea.model";

export interface Persona {
  id?: number;
  nombre: string;
  apellidos: string;
  departamento: 'RRHH' | 'IT' | 'MARKETING' | 'VENTAS';
  email: string;
  tareas?: Tarea[];
  // Puedes añadir tareas si necesitas la relación inversa
  // tareas?: Tarea[];
}
