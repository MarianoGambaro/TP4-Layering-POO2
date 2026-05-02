package tp1.main;

import tp1.model.Participantes;
import tp1.model.RegistroParticipantes;
import tp1.vista.AgregarParticipante;
import tp1.persistencia.JdbcRegistroDeParticipantes;

import java.awt.EventQueue;
import java.sql.SQLException;
public class Main {
    public static void main(String[] args) throws SQLException {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AgregarParticipante(new Participantes(new JdbcRegistroDeParticipantes("jdbc:derby://localhost:1527/participantes","app","app")));
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }
}