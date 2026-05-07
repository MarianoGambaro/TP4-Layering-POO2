package tp3.model;

import javax.swing.*;

//no cree una clase participante ya que me parecio que sería una clase anémica solo con atributos
public class Inscripcion {
    private String dni;
    private int idConcurso;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    public Inscripcion(String nombre, String apellido, String dni, String telefono, String email, int idConcurso) {
        if(validarVacio(nombre)){
            throw new RuntimeException("Nombre no puede ser vacio");
        }
        if(validarVacio(apellido)){
            throw new RuntimeException("Apellido no puede ser vacio");
        }
        if(validarVacio(dni)){
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
        this.idConcurso = idConcurso;
    }

    private boolean checkEmail(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email != null && email.matches(regex);
    }
    private boolean validarVacio(String txt){
        return txt == null || txt.trim().isEmpty();
    }
    private boolean checkPhone(String telefono) {
        String regex = "\\d{4}-\\d{6}";
        return telefono != null && telefono.matches(regex);
    }


    //El archivo inscriptos.txt debe quedar así:
    //apellido, nombre, teléfono, email, idconcurso
    public String toCsv() {
        return apellido + ", " + nombre + ", " + telefono + ", "
                + email + ", " + idConcurso + System.lineSeparator();
    }

    public String nombre(){
        return nombre;
    }
    public String apellido() {
        return apellido;
    }
    public String telefono() {
        return telefono;
    }
    public String email() {
        return email;
    }
    public String dni() {
        return dni;
    }
    public int idConcurso() {
        return idConcurso;
    }
}
