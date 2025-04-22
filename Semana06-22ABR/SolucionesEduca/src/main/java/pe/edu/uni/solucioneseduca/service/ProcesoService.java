package pe.edu.uni.solucioneseduca.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.uni.solucioneseduca.db.AccesoDB;
import pe.edu.uni.solucioneseduca.dto.MatriculaDto;

public class ProcesoService extends ServiceAbstract {

    public MatriculaDto matricular(MatriculaDto bean) {
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
            validarAlumno(cn, bean.getAlumnoId());
            validarCurso(cn, bean.getCursoId());
            validarTipoMatricula(bean.getTipoMatricula());
            validarCuotas(bean.getCuotas(), bean.getTipoMatricula());
            precio = obtenerPrecio(cn, bean.getCursoId(), bean.getTipoMatricula());
            bean.setPrecio(precio);

            registrarMatricula(cn, bean);
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
        } finally {
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
        rs.close();
        pstm.close();
        if (cont == 0) {
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
        if (!rs.next()) {
            throw new SQLException("Curso no existe.");
        }
        int vacantes = rs.getInt(1);
        int matriculados = rs.getInt(2);
        rs.close();
        pstm.close();
        if (matriculados >= vacantes) {
            throw new SQLException("No hay vacantes.");
        }
    }

    private void validarTipoMatricula(String tipoMatricula) throws SQLException {
        String opciones = "REGULAR,BECA,MEDIABECA";
        if (opciones.indexOf(tipoMatricula) == -1) {
            throw new SQLException("Tipo de Matricula es incorrecto.");
        }
    }

    private void validarCuotas(Integer cuotas, String tipoMatricula) throws SQLException {
        if (cuotas < 1 || cuotas > 3) {
            throw new SQLException("Cantidad de cuotas es incorrecto.");
        }
        if (tipoMatricula.equals("REGULAR")) {
            return;
        }
        if (cuotas != 1) {
            throw new SQLException("Cantidad de cuotas es incorrecto.");
        }
    }

    private Double obtenerPrecio(Connection cn, Integer cursoId, String tipoMatricula) throws SQLException {
        // Variables
        String sql = """
                     select cur_precio 
                     from CURSO where cur_id = ?
                     """;
        // Proceso
        PreparedStatement pstm = cn.prepareStatement(sql);
        pstm.setInt(1, cursoId);
        ResultSet rs = pstm.executeQuery();
        if (!rs.next()) {
            throw new SQLException("Curso no existe.");
        }
        Double precio = rs.getDouble(1);
        rs.close();
        pstm.close();
        Double precioFinal = 0.0;
        switch (tipoMatricula) {
            case "REGULAR" ->
                precioFinal = precio;
            case "MEDIABECA" ->
                precioFinal = precio / 2;
            case "BECA" ->
                precioFinal = precio / 10;
        }
        return precioFinal;
    }

    private void registrarMatricula(Connection cn, MatriculaDto bean) throws SQLException {
        // Variables
        String sql1 = """
                        update curso 
                        set cur_matriculados = cur_matriculados + 1
                        where cur_id = ?
                     """;
        String sql2 = """
                        insert into matricula(cur_id,alu_id,emp_id,mat_tipo,mat_fecha,mat_precio,mat_cuotas,mat_nota)
                        values(?,?,?,?,GETDATE(),?,?,?)
                      """;
        // Proceso
        PreparedStatement pstm = cn.prepareStatement(sql1);
        pstm.setInt(1,bean.getCursoId());
        int filas = pstm.executeUpdate();
        if(filas!=1){
            throw new SQLException("Error en el proceso.");
        }
        pstm.close();
        pstm = cn.prepareStatement(sql2);
        pstm.setInt(1, bean.getCursoId());
        pstm.setInt(2, bean.getAlumnoId());
        pstm.setInt(3, bean.getEmpleadoId());
        pstm.setString(4, bean.getTipoMatricula());
        pstm.setDouble(5, bean.getPrecio());
        pstm.setInt(6, bean.getCuotas());
        pstm.setInt(7, bean.getCuotas());
        pstm.executeUpdate();
        pstm.close();
    }

}
