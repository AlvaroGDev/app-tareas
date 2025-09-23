package es.cic._5.es.cic._5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;

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
				var ana = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Ana", "García", es.cic._5.es.cic._5.model.Persona.Departamento.IT, "ana.garcia@email.com"));
				var luis = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Luis", "Martínez", es.cic._5.es.cic._5.model.Persona.Departamento.RRHH, "luis.martinez@email.com"));
				var marta = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Marta", "López", es.cic._5.es.cic._5.model.Persona.Departamento.MARKETING, "marta.lopez@email.com"));
				var carlos = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Carlos", "Sánchez", es.cic._5.es.cic._5.model.Persona.Departamento.VENTAS, "carlos.sanchez@email.com"));
				var elena = personaService.createPersona(new es.cic._5.es.cic._5.model.Persona("Elena", "Ruiz", es.cic._5.es.cic._5.model.Persona.Departamento.IT, "elena.ruiz@email.com"));

				// Crear 2 tareas para cada persona
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 1 de Ana",
					"Descripción de la tarea 1 de Ana",
					es.cic._5.es.cic._5.model.Tarea.Estado.PENDIENTE,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.MEDIA,
					ana
				));
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 2 de Ana",
					"Descripción de la tarea 2 de Ana",
					es.cic._5.es.cic._5.model.Tarea.Estado.EN_PROGRESO,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.ALTA,
					ana
				));

				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 1 de Luis",
					"Descripción de la tarea 1 de Luis",
					es.cic._5.es.cic._5.model.Tarea.Estado.PENDIENTE,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.MEDIA,
					luis
				));
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 2 de Luis",
					"Descripción de la tarea 2 de Luis",
					es.cic._5.es.cic._5.model.Tarea.Estado.EN_PROGRESO,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.ALTA,
					luis
				));

				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 1 de Marta",
					"Descripción de la tarea 1 de Marta",
					es.cic._5.es.cic._5.model.Tarea.Estado.PENDIENTE,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.MEDIA,
					marta
				));
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 2 de Marta",
					"Descripción de la tarea 2 de Marta",
					es.cic._5.es.cic._5.model.Tarea.Estado.EN_PROGRESO,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.ALTA,
					marta
				));

				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 1 de Carlos",
					"Descripción de la tarea 1 de Carlos",
					es.cic._5.es.cic._5.model.Tarea.Estado.PENDIENTE,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.MEDIA,
					carlos
				));
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 2 de Carlos",
					"Descripción de la tarea 2 de Carlos",
					es.cic._5.es.cic._5.model.Tarea.Estado.EN_PROGRESO,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.ALTA,
					carlos
				));

				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 1 de Elena",
					"Descripción de la tarea 1 de Elena",
					es.cic._5.es.cic._5.model.Tarea.Estado.PENDIENTE,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.MEDIA,
					elena
				));
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea 2 de Elena",
					"Descripción de la tarea 2 de Elena",
					es.cic._5.es.cic._5.model.Tarea.Estado.EN_PROGRESO,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.ALTA,
					elena
				));

				// Crear 3 tareas sin persona asignada
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea sin asignar 1",
					"Descripción de tarea sin asignar 1",
					es.cic._5.es.cic._5.model.Tarea.Estado.PENDIENTE,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.BAJA,
					null
				));
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea sin asignar 2",
					"Descripción de tarea sin asignar 2",
					es.cic._5.es.cic._5.model.Tarea.Estado.EN_PROGRESO,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.MEDIA,
					null
				));
				tareaService.createTarea(new es.cic._5.es.cic._5.model.Tarea(
					"Tarea sin asignar 3",
					"Descripción de tarea sin asignar 3",
					es.cic._5.es.cic._5.model.Tarea.Estado.COMPLETADA,
					es.cic._5.es.cic._5.model.Tarea.Prioridad.ALTA,
					null
				));
			};
	}

}
