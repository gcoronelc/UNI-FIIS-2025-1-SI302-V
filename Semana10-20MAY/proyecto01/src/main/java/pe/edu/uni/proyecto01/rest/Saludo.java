package pe.edu.uni.proyecto01.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/saludo")
public class Saludo {

    @GetMapping({"","/"})
    public String saludo(){
        return "Hola todos.";
    }
}
