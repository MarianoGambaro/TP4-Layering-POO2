package tp2.main;

import tp2.email.MailTrap;
import tp2.model.MensajeCumpleaños;
import tp2.model.Notificacion;
import tp2.model.RegistroEmpleados;
import tp2.persistencia.RegistroDeEmpleadosArchivo;

import java.time.LocalDate;
import java.time.MonthDay;

public class Main {
    static void main() {

        Notificacion email = new MailTrap("sandbox.smtp.mailtrap.io", "176608dbaea411","6e545bd6f295d5",25);
        RegistroEmpleados registroArchivo = new RegistroDeEmpleadosArchivo(
                "C:/Users/marti/OneDrive/Documents/UNI/3er año 26/Objetos 2/TP/-salida.txt");

        var msgCumpleaños = new MensajeCumpleaños(registroArchivo,email);
        msgCumpleaños.enviarFelizCumpleaños(MonthDay.now());

    }
}
