package tp2.model;

import java.time.LocalDate;
import java.time.MonthDay;

public class Empleado {
    private String nombre;
    private String email;
    private LocalDate fechaNacimiento;

    public Empleado(String nombre, String email, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean hoyCumpleAños(MonthDay diaMes){
        return MonthDay.from(this.fechaNacimiento).equals(diaMes);
    }

    public String email(){
        return email;
    }
}
