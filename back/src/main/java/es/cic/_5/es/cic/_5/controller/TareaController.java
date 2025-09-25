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

import es.cic._5.es.cic._5.model.Tarea;
import es.cic._5.es.cic._5.service.TareaService;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    @Autowired
    private TareaService tareaService;

    @GetMapping
    public List<Tarea> getAllTareas() {
        return tareaService.findAll();
    }
    
    @GetMapping("/{id}")
    public Tarea getTarea(@PathVariable Long id) {
        return tareaService.getTarea(id);
    }

    @PostMapping
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return tareaService.createTarea(tarea);
    }

    @PutMapping("/{id}")
    public void updateTarea(@RequestBody Tarea tarea, @PathVariable Long id) {
        tarea.setId(id);
        tareaService.updateTarea(tarea);
    }

    @DeleteMapping("/{id}")
    public void deleteTarea(@PathVariable Long id) {
        tareaService.deleteTarea(id);
    }
}
