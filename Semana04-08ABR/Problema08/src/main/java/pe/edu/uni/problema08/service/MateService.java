package pe.edu.uni.problema08.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import pe.edu.uni.problema08.dto.MateDto;

public class MateService {

    private final int LIMITE_INFERIOR = 15;
    private final int LIMITE_SUPERIOR = 30;

    public MateDto procesar(MateDto bean){
        // Variables
        int[] fuente;
        int[] impares;
        int[] pares;
        int sumaImpares;
        int sumaPares;
        // Proceso
        fuente = generarFuente(bean.getN());
        impares = obtenerImpares(fuente);
        pares = obtenerPares(fuente);
        sumaImpares = obtenerSuma(impares);
        sumaPares = obtenerSuma(pares);
        // Reporte
        bean.setFuente(fuente);
        bean.setImpares(impares);
        bean.setPares(pares);
        bean.setSumaImpares(sumaImpares);
        bean.setSumapares(sumaPares);
        return bean;
    }

    private int[] generarFuente(int n) {
        // Variables
        int[] fuente;
        // Proceso
        fuente = new int[n];
        Random random = new Random();
        for (int i = 0; i < fuente.length; i++) {
            fuente[i] = random.nextInt(LIMITE_INFERIOR, LIMITE_SUPERIOR + 1);
        }
        // Reporte
        return fuente;
    }

    private int[] obtenerImpares(int[] fuente) {
        // Variables
        List<Integer> impares = new ArrayList();
        // Proceso
        for (Integer valor : fuente) {
            if(valor % 2 == 1){
                impares.add(valor);
            }
        }
        // Reporte
        return listToArray(impares);
    }
    
    private int[] obtenerPares(int[] fuente) {
        // Variables
        List<Integer> pares = new ArrayList();
        // Proceso
        for (Integer valor : fuente) {
            if(valor % 2 == 0){
                pares.add(valor);
            }
        }
        // Reporte
        return listToArray(pares);
    }
    
    private int obtenerSuma(int[] arreglo){
        // Variables
        int suma = 0;
        // Proceso
        for (int i : arreglo) {
            suma+=i;
        }
        // Reporte
        return suma;
    }

    private int[] listToArray(List<Integer> lista) {
        // Variable
        int[] array = new int[lista.size()];
        // Proceso
        for (int i = 0; i < lista.size(); i++) {
            array[i] = lista.get(i);
        }
        // Reporte
        return array;
    }

    
}
