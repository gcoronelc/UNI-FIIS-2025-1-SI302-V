package pe.edu.uni.problema14.controller;

import pe.edu.uni.problema14.dto.OperadorDto;
import pe.edu.uni.problema14.service.OperadorService;

public class OperadorController {
    
    private OperadorService operadorService;

    public OperadorController() {
        operadorService = new OperadorService();
    }
    
    public OperadorDto procesar(OperadorDto bean){
        return operadorService.procesar(bean);
    }
}
