package pe.edu.uni.apieduca.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.uni.apieduca.service.ConsultasService;

@RestController
@RequestMapping("/educaapi/consultas")
public class ConsultasRest {

    @Autowired
    private ConsultasService consultasService;

    @GetMapping("/precio/{curso}")
    public String precioCurso(@PathVariable int curso){
        double precio = consultasService.obtenerPrecioCurso(curso);
        return String.valueOf(precio);
    }


}
