package pe.edu.uni.apieduca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ConsultasService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public double obtenerPrecioCurso(int idCurso){
        String sql = "select cur_precio from CURSO where cur_id = ?";
        Double precio = jdbcTemplate.queryForObject(sql,Double.class,idCurso);
        return precio;
    }

}
