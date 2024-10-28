import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class SPU01E02_Juan_Antonio_KumarCorbas {

    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "out/production/Servicios_y_Procesos", "SPU01E02_Hijo_Juan_Antonio_KumarCorbas");
        try {
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            PrintWriter writer = new PrintWriter(process.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Haz intro para recibir un número aleatorio o escribe 'fin' para cerrar el programa:");
            while (true) {
                String input = scanner.nextLine();

                if ("fin".equalsIgnoreCase(input)) {
                    writer.println("fin"); // Enviar la señal que marca el final
                    break;
                }

                writer.println(); // Enviar señal vacía para pedir el número aleatorio
                writer.flush();

                // Breve pausa para esperar la respuesta del hijo
                Thread.sleep(100);

                // Lee el número generado por el hijo
                String randomNum = reader.readLine();
                if (randomNum != null) {
                    System.out.println("El número aleatorio generado por el hijo es: " + randomNum);
                } else {
                    System.out.println("Error: No se recibió respuesta del proceso hijo.");
                }
            }

            process.destroy();
            reader.close();
            writer.close();
            scanner.close();
            System.out.println("Programa finalizado.");

        } catch (IOException | InterruptedException e) {
            System.err.println("Error en iniciar o comunicar con el proceso hijo: " + e.getMessage());
        }
    }
}
