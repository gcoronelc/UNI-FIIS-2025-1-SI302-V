package pe.edu.uni.problema14.service;

import pe.edu.uni.problema14.dto.OperadorDto;

public class OperadorService {

    public OperadorDto procesar(OperadorDto bean) {
        //Variables
        int mcm;
        int mcd;
        //Proceso
        mcd = calcularMcd(bean.getNum1(), bean.getNum2());
        mcm = calcularMcm(bean.getNum1(), bean.getNum2());
        //Reporte
        bean.setMcd(mcd);
        bean.setMcm(mcm);
        return bean;
    }

    private int calcularMcd(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;  // Calculamos el residuo de num1 dividido por num2
            num1 = temp;          // Asignamos a num1 el valor de num2
        }
        return num1;
    }

    private int calcularMcm(int num1, int num2) {
        int mcd = calcularMcd(num1, num2);

        // Usamos la fórmula MCM = (num1 * num2) / MCD
        return Math.abs(num1 * num2) / mcd;
    }
}
