package pe.edu.uni.apieduca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uni.apieduca.dto.MatriculaDto;

@Service
public class ProcesosService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     *
     * @param bean
     * @return
     */
    @Transactional(propagation= Propagation.REQUIRES_NEW, rollbackFor=Exception.class)
    public MatriculaDto matricular(MatriculaDto bean){
        // Variables
        String sql;
        double precio;
        // Validaciones
        validarEmpleado(bean.getIdEmpleado());
        validarAlumno(bean.getIdAlumno());
        validarCurso(bean.getIdCurso());
        validarMatricula(bean.getIdCurso(),bean.getIdAlumno());
        validarVacantes(bean.getIdCurso());
        validarTipoMatricula(bean.getTipo(),bean.getCuotas());
        // Proceso
        sql = "select cur_precio from CURSO where cur_id=?";
        precio = jdbcTemplate.queryForObject(sql,Double.class,bean.getIdCurso());
        sql = """
                insert into MATRICULA(cur_id,alu_id,emp_id,mat_tipo,
                mat_fecha,mat_precio,mat_cuotas) 
                values(?,?,?,?,GETDATE(),?,?)
                """;
        Object [] datos = {
          bean.getIdCurso(),bean.getIdAlumno(),bean.getIdEmpleado(),
          bean.getTipo(),precio,bean.getCuotas()
        };
        jdbcTemplate.update(sql,datos);
        sql = """
                update CURSO
                set cur_matriculados = cur_matriculados + 1
                where cur_id=?
              """;
        jdbcTemplate.update(sql,bean.getIdCurso());
        sql = """
                select CONVERT(varchar(20),mat_fecha,103) fecha
                from MATRICULA
                where cur_id=? and alu_id=?
              """;
        String fecha = jdbcTemplate.queryForObject(sql,String.class, bean.getIdCurso(), bean.getIdAlumno());
        // Fin
        bean.setPrecio(precio);
        bean.setFecha(fecha);
        return bean;
    }

    /**
     *
     * @param tipo
     * @param cuotas
     */
    private void validarTipoMatricula(String tipo, int cuotas) {
        // Validar el tipo
        String tipos[] = {"REGULAR","BECA","MEDIABECA"};
        int cont = 0;
        for(String op: tipos) {
            cont += op.equals(tipo)?1:0;
        }
        if(cont != 1){
            throw new RuntimeException("Lo sentimos... el tipo es incorrecto.");
        }
        // Validar cuotas de tipos: BECA y MEDIABECA
        if(tipo.equals("BECA") && cuotas!=1){
            throw new RuntimeException("Lo sentimos... la cantidad de cuotas es incorrecto.");
        }
        if(tipo.equals("MEDIABECA") && cuotas!=1){
            throw new RuntimeException("Lo sentimos... la cantidad de cuotas es incorrecto.");
        }
        // Validar cuotas para tipo REGULAR
        if(tipo.equals("REGULAR") && (cuotas<1 || cuotas>3)){
            throw new RuntimeException("Lo sentimos... la cantidad de cuotas es incorrecto.");
        }
    }

    /**
     *
     * @param idCurso
     */
    private void validarVacantes(int idCurso) {
        String sql = """
                select cur_vacantes - cur_matriculados cont
                 from curso where cur_id = ?
               """;
        int cont = jdbcTemplate.queryForObject(sql,Integer.class,idCurso);
        if(cont<=0){
            throw new RuntimeException("Lo sentimos... el curso no tiene vacantes.");
        }
    }

    /**
     *
     * @param idCurso
     * @param idAlumno
     */
    private void validarMatricula(int idCurso, int idAlumno) {
        String sql = """
                select count(1) cont from MATRICULA
                where cur_id=? AND alu_id=?
               """;
        int cont = jdbcTemplate.queryForObject(sql,Integer.class,idCurso,idAlumno);
        if(cont==1){
            throw new RuntimeException("Matricula ya existe.");
        }
    }

    /**
     *
     * @param idCurso
     */
    private void validarCurso(int idCurso) {
        String sql = "select count(1) cont from CURSO where cur_id=?";
        int cont = jdbcTemplate.queryForObject(sql,Integer.class,idCurso);
        if(cont==0){
            throw new RuntimeException("Curso " + idCurso + " no existe.");
        }
    }

    /**
     *
     * @param idAlumno
     */
    private void validarAlumno(int idAlumno) {
        String sql = "select count(1) cont from ALUMNO where alu_id=?";
        int cont = jdbcTemplate.queryForObject(sql,Integer.class,idAlumno);
        if(cont==0){
            throw new RuntimeException("Alumno " + idAlumno + " no existe.");
        }
    }

    /**
     * Este metodo verifica que el ID de empleado exista en la tabla EMPLEADO.
     * En caso que el ID no exista, genera una excepcion de
     * tipo RuntimeException.
     *
     * @param idEmpleado Representa el ID del empleado a verificar en la BD.
     */
    private void validarEmpleado(int idEmpleado) {
        String sql = "select count(1) cont from EMPLEADO where emp_id=?";
        int cont = jdbcTemplate.queryForObject(sql,Integer.class,idEmpleado);
        if(cont==0){
            throw new RuntimeException("Empleado " + idEmpleado + " no existe.");
        }
    }

}
