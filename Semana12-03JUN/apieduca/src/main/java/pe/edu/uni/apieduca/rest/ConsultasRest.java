package pe.edu.uni.apieduca.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.uni.apieduca.service.ConsultasService;

import java.util.Map;

@RestController
@RequestMapping("/educaapi/consultas")
public class ConsultasRest {

    @Autowired
    private ConsultasService consultasService;

    @GetMapping("/precio/{curso}")
    public ResponseEntity<String> precioCurso(@PathVariable int curso){
        try {
            double precio = consultasService.obtenerPrecioCurso(curso);
            return ResponseEntity.ok(String.valueOf(precio));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/cuota/{curso}/{alumno}")
    public ResponseEntity<?> obtenerCuota
            (@PathVariable int curso, @PathVariable int alumno){
        try {
            Map<String,Object> rec = consultasService.obtenerCuota(curso,alumno);
            return ResponseEntity.ok(rec);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
