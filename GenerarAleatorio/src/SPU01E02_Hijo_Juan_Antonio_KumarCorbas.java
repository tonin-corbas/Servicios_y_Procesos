import java.util.Random;
import java.util.Scanner;

public class SPU01E02_Hijo_Juan_Antonio_KumarCorbas {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Espera a recibir una entrada para generar el siguiente número
            if (!scanner.hasNextLine()) {
                break; // Termina si no hay entrada (cuando el proceso principal envía "fin")
            }
            scanner.nextLine();  // Lee la señal vacía del proceso principal

            // Genera un número aleatorio entre 0 y 10
            int numeroAleatorio = random.nextInt(11);
            System.out.println(numeroAleatorio);
            System.out.flush();  // Asegura que el número se envía al proceso padre
        }
    }
}
