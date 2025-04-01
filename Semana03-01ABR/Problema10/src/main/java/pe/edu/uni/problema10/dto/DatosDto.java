package pe.edu.uni.problema10.dto;

public class DatosDto {
    
    //Datos
    private int num1;
    private int num2;
    
    //Reporte
    private int[] datos;

    public DatosDto() {
    }

    public DatosDto(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.datos = null;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public int[] getDatos() {
        return datos;
    }

    public void setDatos(int[] datos) {
        this.datos = datos;
    }
    
    
    
    
    
}
