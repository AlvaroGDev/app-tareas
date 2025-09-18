package es.cic._5.es.cic._5.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String descripcion;

    private enum Estado {
        PENDIENTE, EN_PROGRESO, COMPLETADA
    }

    private enum Prioridad {
        BAJA, MEDIA, ALTA
    }
    private Estado estado;
    private Prioridad prioridad;

    @ManyToOne
    private Persona personaAsignada;
    // Constructores

    public Tarea() {
    }
        
    public Tarea(String nombre, String descripcion, Estado estado, Prioridad prioridad, Persona personaAsignada) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.personaAsignada = personaAsignada;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Persona getPersonaAsignada() {
        return personaAsignada;
    }

    public void setPersonaAsignada(Persona personaAsignada) {
        this.personaAsignada = personaAsignada;
    }



    // Getters y Setters

    @Override
    public String toString() {      
        return "Tarea [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", estado=" + estado
                + ", prioridad=" + prioridad + ", personaAsignada=" + personaAsignada + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Tarea tarea = (Tarea) obj;
        return id != null && id.equals(tarea.id);
    }
}
