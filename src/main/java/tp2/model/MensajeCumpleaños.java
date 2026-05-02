package tp2.model;

import javax.management.Notification;
import java.time.MonthDay;

public class MensajeCumpleaños {
    private RegistroEmpleados registroEmpleados;
    private Notificacion notificacion;

    public MensajeCumpleaños(RegistroEmpleados registroEmpleados, Notification notification){
        this.registroEmpleados = registroEmpleados;
        this.notificacion = notification;
    }
    public void enviarFelizCumpleaños(MonthDay diaMes){
        var empleados = this.registroEmpleados.empleados(); //me devuelven una lista de empleados, independientemente de donde saquen los datos
        for(var empleado : empleados){
            if (empleado.hoyCumpleAños(diaMes)){
                this.notificacion.enviarEmail(empleado.email());
            }
        }
    }
}
