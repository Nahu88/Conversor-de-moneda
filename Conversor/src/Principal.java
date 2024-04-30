import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {


        ConsultaMoneda consultaMoneda = new ConsultaMoneda();
        Scanner lectura = new Scanner(System.in);

        String menu = """
        *****************************************************
        Bienvenido al Conversor de Moneda :)
        
            1) Dolar -> Peso argentino
            2) Peso argentino -> Dolar
            3) Dolar -> Real brasileño
            4) Real brasileño -> Dolar
            5) Dolar -> Peso colombiano
            6) Peso colombiano -> Dolar
            7) Salir
        
        Elija una opcion valida:
        ******************************************************
        """;
        while (true){
            System.out.println(menu);
            int opcion = lectura.nextInt();

            if (opcion == 7) {
                System.out.println("Gracias por usar mi conversor de monedas");
                System.exit(0);
            } else if (opcion < 1 || opcion > 6) {
                System.out.println("Opción de menú inválida.");
                continue;
            }
            String monedaInicial = "";
            String monedaDestino = "";

            switch (opcion) {
                case 1:
                    monedaInicial = "USD";
                    monedaDestino = "ARS";
                    break;
                case 2:
                    monedaInicial = "ARS";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaInicial = "USD";
                    monedaDestino = "BRL";
                    break;
                case 4:
                    monedaInicial = "BRL";
                    monedaDestino = "USD";
                    break;
                case 5:
                    monedaInicial = "USD";
                    monedaDestino = "COP";
                    break;
                case 6:
                    monedaInicial = "COP";
                    monedaDestino = "USD";
                    break;
                default:
                    throw new IllegalArgumentException("Opción de menú inválida.");
            }
            System.out.println("Indique la cantidad que desea convertir");
            int cantidad = lectura.nextInt();

            try {
                consultaMoneda.ConvertirMoneda(monedaInicial, monedaDestino, cantidad);
            } catch (IOException | InterruptedException e) {
                System.out.println("Ocurrio un error al convertir la moneda");
            }
        }

    }
}


