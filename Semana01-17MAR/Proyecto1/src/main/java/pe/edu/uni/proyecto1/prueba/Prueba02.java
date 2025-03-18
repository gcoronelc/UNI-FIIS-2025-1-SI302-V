package pe.edu.uni.proyecto1.prueba;

import pe.edu.uni.proyecto1.service.PedidoService;

public class Prueba02 {
  public static void main(String[] args) {
        
        // Variables
        PedidoService pedidoService = new PedidoService();

        // Datos
        double importePedido = -1000.00; // Ejemplo de importe de pedido

        // Proceso
        double impuesto = pedidoService.calcularImpuesto(importePedido);
        double total = pedidoService.calcularTotal(importePedido);

        // Reporte
        System.out.printf("Importe del pedido: %.2f\n", importePedido);
        System.out.printf("Impuesto: %.2f\n", impuesto);
        System.out.printf("Total a pagar: %.2f\n", total);
        
    }
}
