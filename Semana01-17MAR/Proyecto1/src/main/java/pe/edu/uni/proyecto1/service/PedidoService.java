package pe.edu.uni.proyecto1.service;

public class PedidoService {

    // Tasa de impuesto (porcentaje)
    private static final double TASA_IMPUESTO = 0.18;  // Ejemplo: 16%

    /**
     * Método para calcular el impuesto sobre el monto del pedido.
     *
     * @param importe el importe del pedido.
     * @return el monto del impuesto.
     */
    public double calcularImpuesto(double importe) {
        if (importe < 0) {
            throw new IllegalArgumentException("El importe no puede ser negativo");
        }
        return importe * TASA_IMPUESTO;
    }

    /**
     * Método para calcular el total a pagar incluyendo el impuesto.
     *
     * @param importe el importe del pedido.
     * @return el total a pagar.
     */
    public double calcularTotal(double importe) {
        double impuesto = calcularImpuesto(importe);
        return importe + impuesto;
    }

}
