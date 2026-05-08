package tp3.main;

import tp3.model.Concursos;
import tp3.persistencia.FileRegistroDeConcursos;
import tp3.persistencia.FileRegistroDeInscripciones;
import tp3.persistencia.JdbcRegistroDeConcursos;
import tp3.persistencia.JdbcRegistroDeInscripciones;
import tp3.vista.PantallaDeInscripcion;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        //var txtConcursos = new FileRegistroDeConcursos("C:/Users/marti/OneDrive/Documents/UNI/3er año 26/Objetos 2/TP/TP 4 - Layers/-Concursos.txt");
        //var txtInscripciones = new FileRegistroDeInscripciones("C:/Users/marti/OneDrive/Documents/UNI/3er año 26/Objetos 2/TP/TP 4 - Layers/-Inscripciones.txt");
        var concursosBD = new JdbcRegistroDeConcursos("jdbc:mysql://localhost:3306/poo2_tp4_LayersPt3","root","");
        var inscripcionesBD = new JdbcRegistroDeInscripciones("jdbc:mysql://localhost:3306/poo2_tp4_LayersPt3","root","");
        new PantallaDeInscripcion(concursosBD, inscripcionesBD);
    }
}
