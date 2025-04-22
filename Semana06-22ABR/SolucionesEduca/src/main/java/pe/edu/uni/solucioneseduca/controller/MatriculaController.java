package pe.edu.uni.solucioneseduca.controller;

import pe.edu.uni.solucioneseduca.dto.MatriculaDto;
import pe.edu.uni.solucioneseduca.service.ProcesoService;


public class MatriculaController {
    
    private ProcesoService procesoService;

    public MatriculaController() {
        procesoService = new ProcesoService();
    }
    

    public void procesar(MatriculaDto bean) {
        procesoService.matricular(bean);
    }
    
}
