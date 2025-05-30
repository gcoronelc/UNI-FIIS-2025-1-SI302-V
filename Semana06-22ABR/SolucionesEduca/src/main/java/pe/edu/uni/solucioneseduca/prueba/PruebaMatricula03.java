package pe.edu.uni.solucioneseduca.prueba;

import pe.edu.uni.solucioneseduca.dto.MatriculaDto;
import pe.edu.uni.solucioneseduca.service.ProcesoService;

public class PruebaMatricula03 {

    public static void main(String[] args) {
        // Datos
        MatriculaDto bean = new MatriculaDto();
        bean.setAlumnoId(10);
        bean.setCursoId(6);
        bean.setTipoMatricula("LIBRE");
        // Proceso
        ProcesoService service = new ProcesoService();
        service.matricular(bean);
        // Reporte
        System.out.println("Mensaje: " + bean.getMensaje());
    }
    
}
