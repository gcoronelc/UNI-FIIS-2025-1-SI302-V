
package pe.edu.uni.problema14.dto;

public class OperadorDto {
    //Variables de entrada
    private int num1;
    private int num2;
    //Variables de salida
    private int mcm;
    private int mcd;

    public OperadorDto() {
    }

    public OperadorDto(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
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

    public int getMcm() {
        return mcm;
    }

    public void setMcm(int mcm) {
        this.mcm = mcm;
    }

    public int getMcd() {
        return mcd;
    }

    public void setMcd(int mcd) {
        this.mcd = mcd;
    }
    
    
}
