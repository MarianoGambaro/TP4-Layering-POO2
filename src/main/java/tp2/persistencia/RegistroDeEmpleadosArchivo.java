package tp2.persistencia;

import tp2.model.Empleado;
import tp2.model.RegistroEmpleados;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class RegistroDeEmpleadosArchivo implements RegistroEmpleados {
    // desde esta clase re realiza la lectura del archivo de texto
    private String path;

    public RegistroDeEmpleadosArchivo(String path) {
        this.path = path;
    }

    @Override
    public List<Empleado> empleados() {
        List<Empleado> empleados = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(path))){
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");

                String apellido = partes[0].trim();
                String nombre = partes[1].trim();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                LocalDate fecha = LocalDate.parse(partes[2].trim(),formatter);
                String email = partes[3].trim();

                empleados.add(new Empleado(apellido, nombre, fecha, email));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }
}
