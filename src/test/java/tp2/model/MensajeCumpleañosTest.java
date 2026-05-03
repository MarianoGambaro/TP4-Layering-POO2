package tp2.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MensajeCumpleañosTest {

    @Test
    public void envioFelizCumpleañosADosEmpleadosTest(){
        //setup
        var fake = new FakeNotificacion();

        var msgCumple = new MensajeCumpleaños(new RegistroEmpleados() {
            @Override
            public List<Empleado> empleados() {
                return List.of(
                        new Empleado("Juan", "Garcia", LocalDate.of(2002, 5,2), "juancito@gmail.com"),
                        new Empleado("Mariano", "Gamb", LocalDate.of(2000, 5, 3), "margamb@gmail.com"),
                        new Empleado("Lau","Ramirez", LocalDate.of(2003,5,2), "lauramirez@gmailcom")
                );
            }
        }, fake);
        msgCumple.enviarFelizCumpleaños(MonthDay.of(5,2));
        assertEquals(2, fake.cantidadEnviados());
        assertTrue(fake.contieneA("juancito@gmail.com"));
        assertTrue(fake.contieneA("lauramirez@gmailcom"));
    }

}