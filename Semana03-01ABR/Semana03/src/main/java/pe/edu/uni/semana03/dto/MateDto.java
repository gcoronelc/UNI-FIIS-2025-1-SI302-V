package pe.edu.uni.semana03.dto;

public class MateDto {

    // Datos de entrada
    private int num1;
    private int num2;

    // Resultado
    private int suma;
    private int producto;

    public MateDto() {
    }

    public MateDto(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
        this.suma = 0;
        this.producto = 0;
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

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    

}
