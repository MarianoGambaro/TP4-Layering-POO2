package tp3.model;

import java.time.LocalDate;

public class Concurso {

    private int id;
    private String nombre;
    private LocalDate inicioDeInscripcion;
    private LocalDate finDeInscripcion;

    public Concurso(int id, String nombre, LocalDate inicioDeInscripcion, LocalDate finDeInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.inicioDeInscripcion = inicioDeInscripcion;
        this.finDeInscripcion = finDeInscripcion;
    }

    public boolean inscripcionAbierta(){
        LocalDate hoy = LocalDate.now();
        return !hoy.isBefore(this.inicioDeInscripcion) && !hoy.isAfter(finDeInscripcion);
    }

    public String toString(){
        return this.nombre;
    }
}
