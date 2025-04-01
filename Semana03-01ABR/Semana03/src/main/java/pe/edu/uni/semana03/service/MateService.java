package pe.edu.uni.semana03.service;

import pe.edu.uni.semana03.dto.MateDto;

public class MateService {
    
    
    public MateDto procesar(MateDto bean){
        // Variables
        int suma;
        int producto;
        // Proceso
        suma = bean.getNum1() + bean.getNum2();
        producto = bean.getNum1() * bean.getNum2();
        // Reporte
        bean.setSuma(suma);
        bean.setProducto(producto);
        return bean;
    }
    
}
