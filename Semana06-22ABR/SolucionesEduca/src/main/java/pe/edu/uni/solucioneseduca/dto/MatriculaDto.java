package pe.edu.uni.solucioneseduca.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class MatriculaDto {
    
    // Datos de entrada
    private Integer alumnoId;
    private Integer cursoId;
    private String tipoMatricula;
    private Integer cuotas;
    private Integer empleadoId;
    
    // Datos de salida
    private String fecha;
    private Double precio;
    private Boolean exitoso;
    private String mensaje;

    public MatriculaDto(Integer alumnoId, Integer cursoId, String tipoMatricula, Integer cuotas, Integer empleadoId) {
        this.alumnoId = alumnoId;
        this.cursoId = cursoId;
        this.tipoMatricula = tipoMatricula;
        this.cuotas = cuotas;
        this.empleadoId = empleadoId;
        this.fecha = "";
        this.precio = 0.0;
        this.exitoso = false;
        this.mensaje = "";
    }
    
    
    
}
