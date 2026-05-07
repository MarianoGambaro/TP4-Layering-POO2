package tp3.model;

import org.junit.jupiter.api.Test;
import tp3.persistencia.FileRegistroDeConcursos;

import static org.junit.jupiter.api.Assertions.*;

class ConcursosTest {

    //hice un pequeño test porque no me funcionaba la implementacion de la bd
    @Test
    public void concursosAbiertosTest(){
        var fake = new FakeRegistroConcursos();
        var concursos = new Concursos(fake);
        concursos.concursosAbiertos();
        assertEquals(1, fake.llamadas());
    }
}