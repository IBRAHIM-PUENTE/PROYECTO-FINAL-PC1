package proyectoabyssrúbrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    final DatosConexion datos = new DatosConexion();
    final String servidor = datos.servidor;
    final String basededatos = datos.basededatos;
    final String usuario = datos.usuario;
    final String contrasena = datos.contrasena;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://" + servidor + ":3306/" + basededatos, usuario, contrasena);
            System.out.println(conexion);
            return conexion;
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception);
            return null;
        }
    }

    public void quitConexion(Connection conexion_a_cerrar) {
        try {
            if (conexion_a_cerrar != null && !conexion_a_cerrar.isClosed()) {
                conexion_a_cerrar.close();
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
    }

}
