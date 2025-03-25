package pe.edu.uni.semana02.service;

import java.util.Random;

public class Problema01Service {
    
    public int[] datos(){
        // Variables
        int[] arreglo = new int[4];
        // Proceso
        Random random = new Random();
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = random.nextInt(9) + 1;
        }
        // Reporte
        return arreglo;
        //return new int[]{5,5,5,5};
    }
    
    public int menor(int[] datos){
        // Variables
        int menor;
        // Proceso
        menor = datos[0];
        for (int i = 1; i < datos.length; i++) {
            if(menor > datos[i]){
                menor = datos[i];
            }
        }
        // Reporte
        return menor;
    }
    
    public boolean sonIguales(int[] datos){
        // Variables
        boolean iguales;
        // Proceso
        boolean caso1 = (datos[0] == datos[1]);
        boolean caso2 = (datos[2] == datos[3]);
        iguales = caso1 && caso2;
        // Reporte
        return iguales;
    }
    
}
