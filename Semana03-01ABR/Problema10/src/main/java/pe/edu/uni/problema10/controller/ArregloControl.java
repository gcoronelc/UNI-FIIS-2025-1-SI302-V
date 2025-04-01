package pe.edu.uni.problema10.controller;

import pe.edu.uni.problema10.dto.DatosDto;
import pe.edu.uni.problema10.service.ArregloService;


public class ArregloControl {
    private ArregloService arregloService;

    public ArregloControl() {
        arregloService=new ArregloService();
    }
    
    public DatosDto procesar(DatosDto bean){
        return arregloService.procesar(bean);
    }
    
}
