package tp3.model;

import java.util.List;

public class FakeRegistroConcursos implements RegistroConcursos{

    private int llamadas;

    @Override
    public List<Concurso> concursos() {
        llamadas ++;
        return List.of();
    }

    public int llamadas(){
        return llamadas;
    }
}
