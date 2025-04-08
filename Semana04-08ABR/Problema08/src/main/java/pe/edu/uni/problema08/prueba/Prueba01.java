package pe.edu.uni.problema08.prueba;

import java.util.Arrays;
import pe.edu.uni.problema08.dto.MateDto;
import pe.edu.uni.problema08.service.MateService;

public class Prueba01 {
    
    public static void main(String[] args) {
        // Datos
        int n = 8;
        // Proceso
        MateDto bean = new MateDto(n);
        MateService service = new MateService();
        bean = service.procesar(bean);
        // Reporte
        System.out.println("Fuente: " + Arrays.toString(bean.getFuente()));
        System.out.println("Pares: " + Arrays.toString(bean.getPares()));
        System.out.println("Suma: " + bean.getSumapares());
        System.out.println("Impares: " + Arrays.toString(bean.getImpares()));
        System.out.println("Suma: " + bean.getSumaImpares());
    }
    
}
