package pe.edu.uni.solucioneseduca.prueba;

import pe.edu.uni.solucioneseduca.dto.MatriculaDto;
import pe.edu.uni.solucioneseduca.service.ProcesoService;

public class PruebaMatricula05 {

    public static void main(String[] args) {
        // Datos
        MatriculaDto bean = new MatriculaDto();
        bean.setAlumnoId(10);
        bean.setCursoId(6);
        bean.setTipoMatricula("BECA");
        bean.setCuotas(1);
        // Proceso
        ProcesoService service = new ProcesoService();
        service.matricular(bean);
        // Reporte
        System.out.println("Precio: " + bean.getPrecio());
        System.out.println("Mensaje: " + bean.getMensaje());
    }
    
}
