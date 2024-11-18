package Ejercicio_Facturacion;

import java.util.Scanner;

public class Facturacion { private static final String[][] articulos = {
        {"101", "Leche", "25"},
        {"102", "Gaseosa", "30"},
        {"103", "Fideos", "15"},
        {"104", "Arroz", "28"},
        {"105", "Vino", "120"},
        {"106", "Manteca", "20"},
        {"107", "Lavandina", "18"},
        {"108", "Detergente", "46"},
        {"109", "Jabón en Polvo", "96"},
        {"110", "Galletas", "60"}
};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Factura factura = new Factura();

        System.out.println("Ingrese la fecha de la factura:");
        factura.setFechaFactura(scanner.nextLine());

        System.out.println("Ingrese el número de factura:");
        long numeroFactura;
        while (true) {
            numeroFactura = scanner.nextLong();
            if (numeroFactura > 0) break;
            System.out.println("El número de factura debe ser mayor a 0. Intente nuevamente:");
        }
        factura.setNumeroFactura(numeroFactura);
        scanner.nextLine();

        System.out.println("Ingrese el nombre del cliente:");
        String cliente;
        while (true) {
            cliente = scanner.nextLine();
            if (!cliente.isEmpty()) break;
            System.out.println("El nombre del cliente no puede estar vacío. Intente nuevamente:");
        }
        factura.setCliente(cliente);

        while (true) {
            System.out.println("Ingrese el código del artículo a facturar (o '0' para finalizar):");
            String codigo = scanner.nextLine();

            if (codigo.equals("0")) break;

            String[] articulo = buscarArticulo(codigo);
            if (articulo == null) {
                System.out.println("El código ingresado no existe, intente nuevamente.");
                continue;
            }

            System.out.println("Ingrese la cantidad:");
            int cantidad = scanner.nextInt();
            scanner.nextLine();

            DetallesdeFactura detalle = new DetallesdeFactura(
                    articulo[0], articulo[1], cantidad, Double.parseDouble(articulo[2]));
            factura.agregarDetalle(detalle);
        }

        factura.calcularMontoTotal();

        System.out.println("\n--- Detalle de la Factura ---");
        System.out.println(factura);

        scanner.close();
    }

    private static String[] buscarArticulo(String codigo) {
        for (String[] articulo : articulos) {
            if (articulo[0].equals(codigo)) return articulo;
        }
        return null;
    }
}
