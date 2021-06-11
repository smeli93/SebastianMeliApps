package sql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

    public static Connection getConexion() {

        Connection connection = null;
        try {
            String driverClassName = "com.mysql.jdbc.Driver";
            String driverUrl = "jdbc:mysql://localhost/bd_arriendo";
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(driverUrl, "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

}
