import service.ApiService;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ApiService apiService = new ApiService();
        Map<String, Double> tasas = apiService.obtenerTasas();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\nSea bienvenido/a al Conversor de Moneda =]");
            System.out.println("1) Dólar => Peso argentino");
            System.out.println("2) Peso argentino => Dólar");
            System.out.println("3) Dólar => Real brasileño");
            System.out.println("4) Real brasileño => Dólar");
            System.out.println("5) Dólar => Peso colombiano");
            System.out.println("6) Peso colombiano => Dólar");
            System.out.println("7) Salir");
            System.out.print("Elija una opción válida: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1 -> convertir(tasas, "USD", "ARS", entrada);
                case 2 -> convertir(tasas, "ARS", "USD", entrada);
                case 3 -> convertir(tasas, "USD", "BRL", entrada);
                case 4 -> convertir(tasas, "BRL", "USD", entrada);
                case 5 -> convertir(tasas, "USD", "COP", entrada);
                case 6 -> convertir(tasas, "COP", "USD", entrada);
                case 7 -> System.out.println("¡Gracias por usar el conversor!");
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public static void convertir(Map<String, Double> tasas, String origen, String destino, Scanner entrada) {
        System.out.print("Ingrese la cantidad en " + origen + ": ");
        double cantidad = entrada.nextDouble();

        double tasaOrigen = tasas.getOrDefault(origen, 1.0);
        double tasaDestino = tasas.getOrDefault(destino, 1.0);

        double resultado = cantidad / tasaOrigen * tasaDestino;
        System.out.printf("Resultado: %.2f %s\n", resultado, destino);
    }
}
