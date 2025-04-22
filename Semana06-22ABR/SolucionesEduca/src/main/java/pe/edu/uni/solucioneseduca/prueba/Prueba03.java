package pe.edu.uni.solucioneseduca.prueba;

import pe.edu.uni.solucioneseduca.service.ConsultaService;

public class Prueba03 {

    public static void main(String[] args) {
        // Datos
        int codCurso = 30;
        int vacantes;
        String mensaje;
        // Proceso
        ConsultaService service = new ConsultaService();
        vacantes = service.vacantesPorCurso(codCurso);
        mensaje = service.isEstado()?"Vacantes: " + vacantes:service.getMensaje();
        // Reporte
        System.out.println(mensaje);
    }
    
}
