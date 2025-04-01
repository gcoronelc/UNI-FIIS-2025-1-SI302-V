package pe.edu.uni.problema10.prueba;

import java.util.Arrays;
import pe.edu.uni.problema10.dto.DatosDto;
import pe.edu.uni.problema10.service.ArregloService;

public class Prueba01 {
    
    public static void main(String[] args) {
        
        //Datos
        DatosDto bean = new DatosDto(8, 5);
        
        //Procesos
        ArregloService arregloService = new ArregloService();
        bean = arregloService.procesar(bean);
        
        //Reporte
        System.out.println("Reporte: " + Arrays.toString(bean.getDatos()));
        
    }
    
}
