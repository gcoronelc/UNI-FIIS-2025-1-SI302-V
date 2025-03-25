package pe.edu.uni.semana02.prueba;

import pe.edu.uni.semana02.service.Problema03Service;

public class Prueba03 {

    public static void main(String[] args) {
        //Variables
        int catetoA = 3;
        int catetoB = 4;

        //Proceso
        Problema03Service service = new Problema03Service();
        double hipotenusa = service.calculoHipotenusa(catetoA, catetoB);
        double area = service.area(catetoA, catetoB);
        double perimetro = service.perimetro(catetoA, catetoB);

        //Reporte
        System.out.println("Hipotenusa : " + hipotenusa);
        System.out.println("Area : " + area);
        System.out.println("Perimetro : " + perimetro);
    }

}
