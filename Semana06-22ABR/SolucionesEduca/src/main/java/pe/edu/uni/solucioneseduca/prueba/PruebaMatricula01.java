package pe.edu.uni.solucioneseduca.prueba;

import pe.edu.uni.solucioneseduca.dto.MatriculaDto;
import pe.edu.uni.solucioneseduca.service.ProcesoService;

public class PruebaMatricula01 {

    public static void main(String[] args) {
        // Datos
        MatriculaDto bean = new MatriculaDto();
        bean.setAlumnoId(1000);
        // Proceso
        ProcesoService service = new ProcesoService();
        service.matricular(bean);
        // Reporte
        System.out.println("Mensaje: " + bean.getMensaje());
    }
    
}
