package pe.edu.uni.semana02.service;

public class Problema02Service {

    public double calculoPromedio(int C1, int C2, int EP, int EF) {
        //variables    
        double promedio;
        //proceso
        promedio = C1 * 0.20 + C2 * 0.20 + EP * 0.25 + EF * 0.35;
        return promedio;
    }

    public String estadoEstudiante(double promedio) {
        //variable 
        String estado;
        //proceso
        if (promedio >= 14) {
            estado="Aprobado";
        } else {
            estado="Desaprobado";
        }
        //reporte
        return estado;
    }
}
