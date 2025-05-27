package pe.edu.uni.apieduca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

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

}
