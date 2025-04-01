package pe.edu.uni.semana03.prueba;

import pe.edu.uni.semana03.dto.MateDto;
import pe.edu.uni.semana03.service.MateService;

public class Prueba01 {
    
    public static void main(String[] args) {
        // Datos
        MateDto bean = new MateDto(45, 23);
        // Proceso
        MateService service = new MateService();
        bean = service.procesar(bean);
        // Reporte
        System.out.println("DATOS");
        System.out.println("Numero 1: " + bean.getNum1());
        System.out.println("Numero 2: " + bean.getNum2());
        System.out.println("REPORTE");
        System.out.println("Suma: " + bean.getSuma());
        System.out.println("Producto: " + bean.getProducto());
    }
    
}
