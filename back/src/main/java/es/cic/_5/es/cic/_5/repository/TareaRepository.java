package es.cic._5.es.cic._5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.cic._5.es.cic._5.model.Tarea;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {

}
