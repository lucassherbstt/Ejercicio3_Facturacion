package Ejercicio_Facturacion;

public class DetallesdeFactura {
    private String codigoArticulo;
    private String nombreArticulo;
    private int cantidad;
    private double precioUnitario;
    private double descuentoItem;
    private double subtotal;

    public DetallesdeFactura(String codigoArticulo, String nombreArticulo, int cantidad, double precioUnitario) {
        this.codigoArticulo = codigoArticulo;
        this.nombreArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.descuentoItem = (cantidad > 5) ? precioUnitario * 0.1 : 0;
        this.subtotal = (precioUnitario - descuentoItem) * cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return codigoArticulo + "\t" + nombreArticulo + "\t" + cantidad + "\t" +
                precioUnitario + "\t" + descuentoItem + "\t" + subtotal;
    }
}
