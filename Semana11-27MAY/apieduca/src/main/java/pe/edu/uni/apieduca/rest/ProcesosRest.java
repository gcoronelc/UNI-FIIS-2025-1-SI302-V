package pe.edu.uni.apieduca.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.uni.apieduca.dto.MatriculaDto;
import pe.edu.uni.apieduca.service.ProcesosService;

@RestController
@RequestMapping("/educaapi/procesos")
public class ProcesosRest {

    @Autowired
    private ProcesosService procesosService;

    @PostMapping("/matricular")
    public ResponseEntity<?> matricular(@RequestBody MatriculaDto bean) {
        try {
            MatriculaDto resultado = procesosService.matricular(bean);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            // Error controlado, por ejemplo, validación de datos
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (RuntimeException e) {
            // Error controlado, por ejemplo, validación de datos
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            // Error inesperado del sistema
            return ResponseEntity.internalServerError().body("Error interno al procesar la matrícula.");
        }
    }

}
