package tp2.model;

import java.util.List;

public class Empleados implements RegistroEmpleados{
    //private List<Empleado> empleados;

    @Override
    public List<Empleado> empleados() {
        return List.of();
    }

//    public void agregarEmpleado(Empleado empleado){
//        empleados.add(empleado);
//    }
}
//desde esta clase guardaría los empleados para luego exportarlos a un archivo de texto.
