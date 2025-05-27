package pe.edu.uni.apieduca.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MatriculaDto {

    private int idCurso;
    private int idAlumno;
    private int idEmpleado;
    private String tipo;
    private String fecha;
    private double precio;
    private int cuotas;
    private int nota;

}
