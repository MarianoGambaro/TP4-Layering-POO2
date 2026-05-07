package tp3.persistencia;

import tp3.model.Inscripcion;
import tp3.model.RegistroInscripciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcRegistroDeInscripciones implements RegistroInscripciones {
    private String url;
    private String user;
    private String password;

    public JdbcRegistroDeInscripciones(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public void registrarInscripcion(Inscripcion inscripcion) {
        try (Connection dbConn = DriverManager.getConnection(url, user, password);
             PreparedStatement st = dbConn.prepareStatement(
                     "INSERT INTO inscripciones(apellido, nombre, telefono, email, dni, id_concurso) VALUES(?,?,?,?,?,?)")){

            st.setString(1, inscripcion.apellido());
            st.setString(2, inscripcion.nombre());
            st.setString(3, inscripcion.telefono());
            st.setString(4, inscripcion.email());
            st.setString(5, inscripcion.dni());
            st.setInt(6, inscripcion.idConcurso());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al persistir en la base de datos.", e);
        }
    }
}

