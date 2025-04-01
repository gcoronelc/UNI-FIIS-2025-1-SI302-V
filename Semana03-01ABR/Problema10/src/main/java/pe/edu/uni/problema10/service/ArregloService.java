package pe.edu.uni.problema10.service;

import pe.edu.uni.problema10.dto.DatosDto;

public class ArregloService {
    
    public DatosDto procesar (DatosDto bean){
        //Variables
        int[] arreglo;
        
        //Procesos
        int tamanio = Math.abs( bean.getNum1() - bean.getNum2() ) + 1;
        arreglo = new int[tamanio];
        if(bean.getNum1() < bean.getNum2()){
            for (int i = 0; i < arreglo.length; i++) {
                arreglo[i] = bean.getNum1() + i; 
            }
        }else{
            for (int i = 0; i < arreglo.length; i++) {
                arreglo[i] = bean.getNum1() - i;   
            }
        }
        
        //Reporte
        bean.setDatos(arreglo);
        return bean;
    }
    
}
