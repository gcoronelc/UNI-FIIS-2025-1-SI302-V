package pe.edu.uni.solucioneseduca.prueba;

import java.sql.Connection;
import pe.edu.uni.solucioneseduca.db.AccesoDB;

public class Prueba01 {
    
    public static void main(String[] args) {
        
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion Ok.");
            cn.close();
        } catch (Exception e) {
            System.err.println("ERRORRRRRRRRRRRRRRRR");
            System.err.println(e.getMessage());
        }
        
        
    }
    
}
