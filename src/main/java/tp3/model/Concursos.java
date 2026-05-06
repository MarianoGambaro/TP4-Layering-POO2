package tp3.model;

import java.util.ArrayList;
import java.util.List;

//cree una clase Concursos que utilice una implementacion de la interfaz RegistroConcursos
//para asi poder retornar una lista con los concursos abiertos desde el modelo,
//sin necesidad de iterar en la UI para obtener los concursos abiertos.
public class Concursos {
    private List<Concurso> concursos;
    private RegistroConcursos registroConcursos;

    public Concursos(RegistroConcursos registroConcursos){
        this.registroConcursos = registroConcursos;
        concursos = new ArrayList<>();
    }

    public List<Concurso> concursosAbiertos(){
        return concursos().stream().filter(Concurso::inscripcionAbierta).toList();
    }

    public List<Concurso> concursos() {
        return registroConcursos.concursos();
    }
}