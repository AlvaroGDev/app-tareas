package es.cic._5.es.cic._5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic._5.es.cic._5.model.Persona;
import es.cic._5.es.cic._5.repository.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona getPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    public Persona createPersona(Persona persona) {
        return personaRepository.save(persona);
    }   

    public void deletePersona(Long id) {
        personaRepository.deleteById(id);
    }
}
