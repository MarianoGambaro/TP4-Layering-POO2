package tp3.persistencia;

import tp2.model.Empleado;
import tp3.model.Concurso;
import tp3.model.RegistroConcursos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileRegistroDeConcursos implements RegistroConcursos {

    private String path;

    public FileRegistroDeConcursos(String path) {
        this.path = path;
    }

    @Override
    public List<Concurso> concursos() {
        List<Concurso> concursos = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                int id = Integer.parseInt(partes[0].trim());
                String nombre = partes[1].trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate fechaInicioInsc = LocalDate.parse(partes[2].trim(),formatter);
                LocalDate fechaFinInsc = LocalDate.parse(partes[3].trim(), formatter);

                concursos.add(new Concurso(id, nombre, fechaInicioInsc, fechaFinInsc));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return concursos;
    }
}
