import java.io.*;

public class SPU01E01_JuanAntonio_Kumar_Corbas {
    public static void main(String[] args) {
        String[] comando = {"cmd.exe", "/c", "dir -al"};
        // Crear el comando y sus opciones a partir de los argumentos
        ProcessBuilder processBuilder = new ProcessBuilder(comando);
        try {
            // Iniciar el proceso hijo
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String line;
            System.out.println("Resultado del comando:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Esperar a que el proceso hijo termine
            int exitCode = process.waitFor();

            // Mensajes en caso de que haya habido algún error
        } catch (IOException e) {
            System.out.println("Error en la ejecución: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("El procés ha sido enterrumpido: " + e.getMessage());
        }
    }
}