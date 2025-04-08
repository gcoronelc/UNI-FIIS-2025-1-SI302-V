package pe.edu.uni.problema14.prueba;

import pe.edu.uni.problema14.dto.OperadorDto;
import pe.edu.uni.problema14.service.OperadorService;

public class Prueba01 {
    public static void main(String[] args) {
        //Datos
        OperadorDto dto = new OperadorDto(15, 20);
        //Proceso
        OperadorService service = new OperadorService();
        dto=service.procesar(dto);
        
        //Reporte
        System.out.println("MCD:"+dto.getMcd());
        System.out.println("MCM: "+dto.getMcm());
        
    }
    
}
