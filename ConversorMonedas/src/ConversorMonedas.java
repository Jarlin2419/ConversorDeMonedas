import java.io.IOException;
import java.util.Scanner;

public class ConversorMonedas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nBienvenido al Conversor de Monedas");

            // Mostrar opciones al usuario
            System.out.println("Seleccione la conversión que desea realizar:");
            System.out.println("1. Dólar a Peso Argentino");
            System.out.println("2. Peso Argentino a Dólar");
            System.out.println("3. Dólar a Real Brasileño");
            System.out.println("4. Real Brasileño a Dólar");
            System.out.println("5. Dólares a Pesos Colombianos");
            System.out.println("6. Pesos Colombianos a Dólares");
            System.out.println("7. Salir");

            // Leer la opción seleccionada
            int opcion = scanner.nextInt();

            // Verificar si el usuario quiere salir
            if (opcion == 7) {
                continuar = false;
                System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
                break;
            }

            // Leer la cantidad de dinero a convertir
            System.out.print("Ingrese la cantidad de dinero: ");
            double cantidad = scanner.nextDouble();

            double resultado = 0;

            try {
                // Realizar la conversión utilizando las tasas de cambio obtenidas de la API
                switch (opcion) {
                    case 1: // Dólar a Peso Argentino
                        double tasaDolarPesoArgentino = ExchangeRateAPI.obtenerTasaDeCambio("USD", "ARS");
                        resultado = cantidad * tasaDolarPesoArgentino;
                        System.out.println(cantidad + " dólares son " + resultado + " pesos argentinos.");
                        break;
                    case 2: // Peso Argentino a Dólar
                        double tasaPesoArgentinoDolar = ExchangeRateAPI.obtenerTasaDeCambio("ARS", "USD");
                        resultado = cantidad * tasaPesoArgentinoDolar;
                        System.out.println(cantidad + " pesos argentinos son " + resultado + " dólares.");
                        break;
                    case 3: // Dólar a Real Brasileño
                        double tasaDolarRealBrasileno = ExchangeRateAPI.obtenerTasaDeCambio("USD", "BRL");
                        resultado = cantidad * tasaDolarRealBrasileno;
                        System.out.println(cantidad + " dólares son " + resultado + " reales brasileños.");
                        break;
                    case 4: // Real Brasileño a Dólar
                        double tasaRealBrasilenoDolar = ExchangeRateAPI.obtenerTasaDeCambio("BRL", "USD");
                        resultado = cantidad * tasaRealBrasilenoDolar;
                        System.out.println(cantidad + " reales brasileños son " + resultado + " dólares.");
                        break;
                    case 5: // Dólares a Pesos Colombianos
                        double tasaDolarPesoColombiano = ExchangeRateAPI.obtenerTasaDeCambio("USD", "COP");
                        resultado = cantidad * tasaDolarPesoColombiano;
                        System.out.println(cantidad + " dólares son " + resultado + " pesos colombianos.");
                        break;
                    case 6: // Pesos Colombianos a Dólares
                        double tasaPesoColombianoDolar = ExchangeRateAPI.obtenerTasaDeCambio("COP", "USD");
                        resultado = cantidad * tasaPesoColombianoDolar;
                        System.out.println(cantidad + " pesos colombianos son " + resultado + " dólares.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
