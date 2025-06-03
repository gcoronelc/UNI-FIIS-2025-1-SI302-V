package pe.edu.uni.apieduca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsultasService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double obtenerPrecioCurso(int idCurso){
        String sql = "SELECT cur_precio FROM CURSO WHERE cur_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, Double.class, idCurso);
        } catch (EmptyResultDataAccessException e) {
            throw new IllegalArgumentException("Curso con ID " + idCurso + " no existe.");
        }
    }

    public Map<String,Object> obtenerCuota(int idCurso, int idAlumno){
        String sql = """
                    SELECT count(1) cont FROM MATRICULA 
                    WHERE cur_id = ? AND alu_id = ?
                """;
        int cont = jdbcTemplate.queryForObject(sql, Integer.class, idCurso, idAlumno);
        if(cont == 0) {
            throw new RuntimeException("Matricula no existe.");
        }
        sql = """
                with
                -- Paso 1: Datos de matricula
                MAT as (
                	select 
                		cur_id idCurso, alu_id idAlumno,
                		mat_tipo tipo, mat_precio precio, mat_cuotas cuotas
                	from MATRICULA
                	where cur_id=? and alu_id=?
                ),
                -- Paso 2: Lo pagado
                PAG as (
                	select 
                		ISNULL(MAX(pag_cuota),0) cuota,
                		ISNULL(SUM(pag_importe),0) pagado
                	from PAGO
                	where cur_id=? and alu_id=?
                )
                select
                	MAT.idCurso, MAT.idAlumno,
                	MAT.tipo, MAT.precio, MAT.cuotas,
                	PAG.cuota, PAG.pagado
                from MAT cross join PAG
              """;
        Map<String,Object> rec = jdbcTemplate.queryForMap(sql,idCurso, idAlumno,idCurso,idAlumno);
        // Falta trabajar el rec
        return rec;
    }
}
