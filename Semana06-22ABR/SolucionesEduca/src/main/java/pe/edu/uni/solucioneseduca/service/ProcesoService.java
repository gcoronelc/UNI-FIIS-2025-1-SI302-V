package pe.edu.uni.solucioneseduca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.solucioneseduca.db.AccesoDB;
import pe.edu.uni.solucioneseduca.dto.MatriculaDto;

public class ProcesoService extends ServiceAbstract{
    
    public MatriculaDto matricular(MatriculaDto bean){
        // Variables
        Connection cn = null;
        PreparedStatement pstm;
        ResultSet rs;
        String sql;
        Double precio;
        // Estado inicial
        this.setEstado(true);
        this.setMensaje("Proceso ok.");
        // Proceso
        try {
            // Inicio de TX
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            // Flujo
            validarAlumno(cn,bean.getAlumnoId());
            validarCurso(cn,bean.getCursoId());
            //precio = obtenerPrecio(cn,bean.getCursoId());
            //bean.setPrecio(precio);
            //registrarMatricula(cn,bean);
            // Fin de TX
            cn.commit();
        } catch (SQLException e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            this.setEstado(false);
            this.setMensaje(e.getMessage());
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            this.setEstado(false);
            this.setMensaje("Error en el proceso, intentelo de nuevo.");
        } finally{
            try {
                cn.close();
            } catch (Exception e1) {
            }
        }
        // Reporte
        bean.setExitoso(this.isEstado());
        bean.setMensaje(this.getMensaje());
        return bean;
    }

    private void validarAlumno(Connection cn, Integer alumnoId) throws SQLException {
        // Variables
        String sql = "select count(1) cont from ALUMNO where alu_id = ?";
        // Proceso
        PreparedStatement pstm = cn.prepareStatement(sql);
        pstm.setInt(1, alumnoId);
        ResultSet rs = pstm.executeQuery();
        rs.next();
        int cont = rs.getInt("cont");
        if(cont==0){
            throw new SQLException("Alumno no existe.");
        }
    }

    private void validarCurso(Connection cn, Integer cursoId) throws SQLException {
        // Variables
        String sql = """
                     select cur_vacantes, cur_matriculados 
                     from CURSO where cur_id = ?
                     """;
        // Proceso
        PreparedStatement pstm = cn.prepareStatement(sql);
        pstm.setInt(1, cursoId);
        ResultSet rs = pstm.executeQuery();
        if(!rs.next()){
            throw new SQLException("Curso no existe.");
        }
        int vacantes = rs.getInt(1);
        int matriculados = rs.getInt(2);
        if(matriculados>=vacantes){
            throw new SQLException("No hay vacantes.");
        }
    }
    
    
    
    
}
