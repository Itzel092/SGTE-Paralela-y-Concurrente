import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        SistemaTarjetas sistemaTarjetas = new SistemaTarjetas(5, 100); // 5 tarjetas con saldo inicial de 100
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("-------------------------------------------------------------");
        System.out.println("         ¡Bienvenido a Tarjetronic!");
        System.out.println("Un sistema de gestión de tarjetas electrónicas...");
        System.out.println("-------------------------------------------------------------");

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1. Cargar saldo");
            System.out.println("2. Realizar pago");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el código de la tarjeta (000-004): ");
                    String codigoCargar = scanner.nextLine();
                    try {
                        System.out.print("Ingrese el monto a cargar: ");
                        double montoCargar = scanner.nextDouble();
                        sistemaTarjetas.getTarjeta(codigoCargar).cargarSaldo(montoCargar);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el código de la tarjeta (000-004): ");
                    String codigoPago = scanner.nextLine();
                    try {
                        System.out.print("Ingrese el monto a pagar: ");
                        double montoPago = scanner.nextDouble();
                        sistemaTarjetas.getTarjeta(codigoPago).realizarPago(montoPago);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código de la tarjeta (000-004): ");
                    String codigoConsultar = scanner.nextLine();
                    try {
                        double saldo = sistemaTarjetas.getTarjeta(codigoConsultar).consultarSaldo();
                        System.out.println("El saldo actual de la tarjeta " + codigoConsultar + " es: " + saldo);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el sistema. ¡Adiós!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, intente nuevamente.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
