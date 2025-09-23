package es.cic._5.es.cic._5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic._5.es.cic._5.model.Tarea;
import es.cic._5.es.cic._5.repository.TareaRepository;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    public Tarea getTarea(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    public Tarea createTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }   

    public void updateTarea(Tarea tarea) {
        tareaRepository.save(tarea);
    }

    public void deleteTarea(Long id) {
        tareaRepository.deleteById(id);
    }
}
