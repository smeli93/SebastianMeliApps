package sql;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion { 
    
    private String port="3306";
    private String database="veterinaria";
        public static Connection getConexion() {

        Connection connection = null;
        try {
           String driverClassName = "com.mysql.jdbc.Driver";
           String driverUrl="jdbc:mysql://localhost/veterinaria";
           Class.forName(driverClassName);
           connection = DriverManager.getConnection(driverUrl, "root","");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
