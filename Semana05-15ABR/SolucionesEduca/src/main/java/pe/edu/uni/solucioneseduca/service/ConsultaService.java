package pe.edu.uni.solucioneseduca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.solucioneseduca.db.AccesoDB;

public class ConsultaService extends ServiceAbstract{
    
    
    
    public int vacantesPorCurso(int codCurso){
        // Variables
        String sql = """
                     select cur_vacantes - cur_matriculados vacantes
                     from CURSO where cur_id=?
                     """;
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        int vacantes = 0;
        // Asumir que no hay error
        this.setEstado(true);
        this.setMensaje("Proceso ejecutado correctamente");
        // Proceso
        try {
            // Paso 1: Conexion
            cn = AccesoDB.getConnection();
            // Paso 2: El Objeto pstm
            pstm = cn.prepareStatement(sql);
            pstm.setInt(1, codCurso);
            // Paso 3: Ejecutar sentencia
            rs = pstm.executeQuery();
            // Paso 4: Verificar resultado
            if(!rs.next()){
                throw  new SQLException("Curso no existe.");
            }
            // Paso 5: Obtener resultado
            vacantes = rs.getInt("vacantes");
            // Paso 6: Cerrando objetos
            rs.close();
            pstm.close();
        } catch (SQLException e) {
            this.setEstado(false);
            this.setMensaje(e.getMessage());
        } catch (Exception e) {
            this.setEstado(false);
            this.setMensaje("Error en el proceso.");
        } finally{
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        // Reporte
        return vacantes;
    }
    
    
    
    
}
