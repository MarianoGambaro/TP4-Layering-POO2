package tp3.persistencia;

import tp3.model.Concurso;
import tp3.model.RegistroConcursos;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcRegistroDeConcursos implements RegistroConcursos {
    private String url;
    private String user;
    private String password;

    public JdbcRegistroDeConcursos(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public List<Concurso> concursos() {
        List<Concurso> concursos = new ArrayList<>();
        String sql = "SELECT id_concurso, nombre, fecha_inicio, fecha_fin FROM concursos";

        try (Connection dbConn = DriverManager.getConnection(url, user, password);
            PreparedStatement st = dbConn.prepareStatement(sql);
            ResultSet rs = st.executeQuery()) {

        while (rs.next()) {
            int id = rs.getInt("id_concurso");
            String nombre = rs.getString("nombre");

            LocalDate inicio = rs.getDate("fecha_inicio").toLocalDate();
            LocalDate fin = rs.getDate("fecha_fin").toLocalDate();

            concursos.add(new Concurso(id, nombre, inicio, fin));
        }
        } catch (SQLException e) {
            throw new RuntimeException("Error al recuperar los concursos de la base de datos", e);
        }

        return concursos;

    }
}
