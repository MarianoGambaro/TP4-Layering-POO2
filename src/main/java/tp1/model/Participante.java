package tp1.model;

import javax.swing.*;

public class Participante {

    private String nombre;
    private String telefono;
    private String region;

    public Participante(String nombre, String telefono, String region){
        validarNombreVacio();
        validarTelefonoVacio();
        validarRegion();
        if(!validarTelefono(telefono)){
            throw new RuntimeException("El telefono ingresado no es valido");
        }
        this.nombre = nombre;
        this.telefono = telefono;
        this.region = region;
    }

    private boolean validarTelefono(String telefono) {
        String regex = "\\d{4}-\\d{6}"; //esto me marca que es de java swing y hay un import de swing en esta clase
        return telefono.matches(regex);
    }

    private void validarNombreVacio() {
        if (nombre.isEmpty()) {
            throw new RuntimeException("Debe cargar un nombre.");
        }
    }
    private void validarTelefonoVacio() {
        if (telefono.isEmpty()) {
            throw new RuntimeException("Debe cargar un telefono");
        }
    }
    private void validarRegion() {
        if (!region.equals("China") && !region.equals("US") && !region.equals("Europa")) {
            throw new RuntimeException("Region desconocida. Las conocidas son: China, US, Europa");
        }
    }

    public String nombre(){
        return nombre;
    }

    public String region(){
        return region;
    }
    public String telefono(){
        return telefono;
    }

}
