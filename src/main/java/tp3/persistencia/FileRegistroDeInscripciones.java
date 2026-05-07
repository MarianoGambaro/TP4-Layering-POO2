package tp3.persistencia;

import tp3.model.Inscripcion;
import tp3.model.RegistroInscripciones;
import java.io.FileWriter;
import java.io.IOException;


public class FileRegistroDeInscripciones implements RegistroInscripciones {

    private String path;

    public FileRegistroDeInscripciones(String path){
        this.path = path;
    }

    @Override
    public void registrarInscripcion(Inscripcion inscripcion) {
        escribir(inscripcion.toCsv());

    }

    private void escribir(String datos) {
        try (FileWriter writer = new FileWriter(path, true)) { //append true para que no se pise cada insc
            writer.write(datos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
