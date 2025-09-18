package es.cic._5.es.cic._5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic._5.es.cic._5.model.Persona;
import es.cic._5.es.cic._5.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    // Inyección del servicio de Persona
    @Autowired
    private PersonaService personaService;

    // Métodos para manejar las solicitudes HTTP
    // (Crear, Leer, Actualizar, Eliminar)

    @GetMapping
    public List<Persona> getAllPersonas(){
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    public Persona getPersonaById(Long id){
        return personaService.getPersona(id);
    }

   @PostMapping
   public Persona createPersona(@RequestBody Persona persona){
       return personaService.createPersona(persona);
   }

   @PutMapping("/{id}")
   public void updatePersona(@RequestBody Persona persona, @PathVariable Long id){

    persona.setId(id);
    personaService.createPersona(persona);

   }

   @DeleteMapping("/{id}")
   public void deletePersona(@PathVariable Long id){
    personaService.deletePersona(id);
   }

}
