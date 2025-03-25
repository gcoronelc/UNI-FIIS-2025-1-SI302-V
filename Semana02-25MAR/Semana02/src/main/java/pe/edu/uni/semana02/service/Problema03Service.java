package pe.edu.uni.semana02.service;

public class Problema03Service {

    public double calculoHipotenusa(int catetoA, int catetoB) {

        //Variables
        double hipotenusa;

        //Proceso
        hipotenusa = Math.pow(catetoA, 2);
        hipotenusa += Math.pow(catetoB, 2);
        hipotenusa = Math.sqrt(hipotenusa);

        //Reporte
        return hipotenusa;

    }

    public double perimetro(int catetoA, int catetoB){
        //Variables
        double perimetro;
        
        //Proceso
        perimetro = catetoA + catetoB ;
        perimetro += calculoHipotenusa(catetoA, catetoB);
        
        //Reporte
        return perimetro;
    
    }
    
    
    public double area(int catetoA , int catetoB){
        //Variables
        double area;
        
        //Proceso
        area = (catetoA * catetoB)/2 ;
        
        //Report
        return area;
        
   
    }
    
    
}
