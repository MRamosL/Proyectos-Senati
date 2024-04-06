
package banco.nuevo.perú;
import java.sql.Connection;
import java.sql.*;

public class Conexion {
    Connection cn = null;
    public Connection conectar(){
        try{
            String url = "jdbc:mysql://localhost:3306/peru_bank_nuevo?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String user = "root";
            String password = "";
            this.cn = DriverManager.getConnection(url, user, password);
            System.out.println("Coneccion Exitosa!!");

        } catch(SQLException e){
            e.printStackTrace();   
        }
        return cn;
    }   
}