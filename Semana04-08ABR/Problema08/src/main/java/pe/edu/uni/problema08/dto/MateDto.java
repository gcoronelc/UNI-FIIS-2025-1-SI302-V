package pe.edu.uni.problema08.dto;

public class MateDto {

    // Variables de entrada
    private int n;

    // Variables de salida
    private int[] fuente; // Arreglo que se genera aleatoriamente
    private int[] impares; // Arreglos de los impares
    private int[] pares; // Arreglos de los pares
    private int sumaImpares; 
    private int sumapares;
    
    public MateDto() {
        this(10);
    }
    
    public MateDto(int n) {
        this.n = n;
        this.fuente = null;
        this.impares = null;
        this.pares = null;
        this.sumaImpares = 0;
        this.sumapares = 0;
    }
    
    public int getN() {
        return n;
    }
    
    public void setN(int n) {
        this.n = n;
    }
    
    public int[] getFuente() {
        return fuente;
    }
    
    public void setFuente(int[] fuente) {
        this.fuente = fuente;
    }
    
    public int[] getImpares() {
        return impares;
    }
    
    public void setImpares(int[] impares) {
        this.impares = impares;
    }
    
    public int[] getPares() {
        return pares;
    }
    
    public void setPares(int[] pares) {
        this.pares = pares;
    }
    
    public int getSumaImpares() {
        return sumaImpares;
    }
    
    public void setSumaImpares(int sumaImpares) {
        this.sumaImpares = sumaImpares;
    }
    
    public int getSumapares() {
        return sumapares;
    }
    
    public void setSumapares(int sumapares) {
        this.sumapares = sumapares;
    }
    
}
