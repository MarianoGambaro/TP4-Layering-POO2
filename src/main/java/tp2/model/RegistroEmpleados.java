package tp2.model;

import java.util.List;

public interface RegistroEmpleados {
    List<Empleado> empleados();

    //jdeps -verbose:package -p tp1.persistencia -p tp1.model -p tp1.email target\classes
}
