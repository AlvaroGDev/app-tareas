package es.cic._5.es.cic._5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import es.cic._5.es.cic._5.model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import static es.cic._5.es.cic._5.model.Enums.Departamento.*;
import static es.cic._5.es.cic._5.model.Enums.Estado.*;
import static es.cic._5.es.cic._5.model.Enums.Prioridad.*;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner dataInitializer(
			@Autowired es.cic._5.es.cic._5.service.PersonaService personaService,
			@Autowired es.cic._5.es.cic._5.service.TareaService tareaService
	) {
		  return args -> {
        // Crear y guardar 5 personas
        var ana = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Ana", "García", IT, "ana.garcia@email.com"));
        var luis = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Luis", "Martínez", RRHH, "luis.martinez@email.com"));
        var marta = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Marta", "López", MARKETING, "marta.lopez@email.com"));
        var carlos = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Carlos", "Sánchez", VENTAS, "carlos.sanchez@email.com"));
        var elena = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Elena", "Ruiz", IT, "elena.ruiz@email.com"));

        // Crear 2 tareas para cada persona (las que tienen persona asignada)
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 1 de Ana", "Descripción de la tarea 1 de Ana", PENDIENTE, MEDIA, ana));
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 2 de Ana", "Descripción de la tarea 2 de Ana", EN_PROGRESO, ALTA, ana));

        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 1 de Luis", "Descripción de la tarea 1 de Luis", PENDIENTE, MEDIA, luis));
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 2 de Luis", "Descripción de la tarea 2 de Luis", EN_PROGRESO, ALTA, luis));

        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 1 de Marta", "Descripción de la tarea 1 de Marta", PENDIENTE, MEDIA, marta));
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 2 de Marta", "Descripción de la tarea 2 de Marta", EN_PROGRESO, ALTA, marta));

        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 1 de Carlos", "Descripción de la tarea 1 de Carlos", PENDIENTE, MEDIA, carlos));
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 2 de Carlos", "Descripción de la tarea 2 de Carlos", EN_PROGRESO, ALTA, carlos));

        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 1 de Elena", "Descripción de la tarea 1 de Elena", PENDIENTE, MEDIA, elena));
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea 2 de Elena", "Descripción de la tarea 2 de Elena", EN_PROGRESO, ALTA, elena));

        // Crear 3 tareas sin persona asignada - CON CASTING
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea sin asignar 1", "Descripción de tarea sin asignar 1", PENDIENTE, BAJA, (Persona) null));
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea sin asignar 2", "Descripción de tarea sin asignar 2", EN_PROGRESO, MEDIA, (Persona) null));
        tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea("Tarea sin asignar 3", "Descripción de tarea sin asignar 3", COMPLETADA, ALTA, (Persona) null));
    };

}
}
