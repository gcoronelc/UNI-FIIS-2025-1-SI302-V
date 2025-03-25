package pe.edu.uni.semana02.prueba;

import java.util.Arrays;
import pe.edu.uni.semana02.service.Problema01Service;

public class Prueba01 {

    public static void main(String[] args) {
        // Variables
        int datos[];
        int menor;
        boolean iguales;
        String repo;
        // Proceso
        Problema01Service problema01 = new Problema01Service();
        datos = problema01.datos();
        menor = problema01.menor(datos);
        iguales = problema01.sonIguales(datos);
        repo = "Son iguales";
        if(!iguales){
            repo = String.valueOf(menor);
        }
        // Reporte
        System.out.println("Arreglo: " + Arrays.toString(datos));
        System.out.println("Menor: " + repo);
    }
    
}
