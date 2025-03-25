
package pe.edu.uni.semana02.prueba;

import pe.edu.uni.semana02.service.Problema02Service;


public class Prueba02 {
    public static void main(String[] args) {
        //variables
        int pc1=12;
        int pc2=11;
        int ef=20;
        int ep=10;
        
        //operacion
        Problema02Service service=new Problema02Service();
        double promedio=service.calculoPromedio(pc1, pc2, ep, ef);
        String estado=service.estadoEstudiante(promedio);
        //reporte
        System.out.println("Promedio: "+promedio);
        System.out.println("Estado: "+estado);
    }
}
