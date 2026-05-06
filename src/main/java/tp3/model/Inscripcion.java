package tp3.model;

import javax.swing.*;

//no cree una clase participante ya que me parecio que sería una clase anemica solo con atributos
public class Inscripcion {
    private int id;
    private int idConcurso;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String telefono;

    public Inscripcion(String nombre, String apellido, String dni, String email, String telefono) {
        if(!validarNombre(nombre)){
            throw new RuntimeException("Nombre no puede ser vacio");
        }
        if(!validarApellido(apellido)){
            throw new RuntimeException("Apellido no puede ser vacio");
        }
        if(!validarDni(dni)){
            throw new RuntimeException("Dni no puede ser vacio");
        }
        if(!checkEmail(email)){
            throw new RuntimeException("Email debe ser válido");
        }
        if(!checkPhone(telefono)){
            throw new RuntimeException("El teléfono debe ingresarse de la siguiente forma: NNNN-NNNNNN");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }


    private boolean validarNombre(String nombre){
        return nombre.isEmpty();
    }
    private boolean validarApellido(String apellido){
        return apellido.isEmpty();
    }
    private boolean validarDni(String dni){
        return dni.isEmpty();
    }
    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono.matches(regex);
    }
}
