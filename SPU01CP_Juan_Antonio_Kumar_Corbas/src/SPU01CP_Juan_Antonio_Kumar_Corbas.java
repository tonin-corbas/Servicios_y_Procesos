import java.io.*;

public class SPU01CP_Juan_Antonio_Kumar_Corbas {
    public static void main(String[] args) {
        try {
            // Comando para listar archivos y carpetas en Windows
            ProcessBuilder pb1 = new ProcessBuilder("cmd.exe", "/c", "dir");
            // Comando de PowerShell para reemplazar 'd' por 'D'
            ProcessBuilder pb2 = new ProcessBuilder("powershell.exe", "-Command", "ForEach ($line in Get-Content -ReadCount 0) { $line -replace 'd', 'D' }");

            // Iniciar el primer proceso
            Process p1 = pb1.start();
            // Iniciar el segundo proceso
            Process p2 = pb2.start();

            try (InputStream lsOutput = p1.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(lsOutput))) {

                String line;
                while ((line = reader.readLine()) != null) {

                    String modifiedLine = line.replace("d", "D");
                    System.out.println(modifiedLine);
                }
            }

            try (InputStream lsOutput = p2.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(lsOutput))) {

                String line;
                while ((line = reader.readLine()) != null) {

                    String modifiedLine = line.replace("d", "D");
                    System.out.println(modifiedLine);
                }
            }

            // Esperar a que ambos procesos terminen
            p1.waitFor();
            p2.waitFor();

            // Mostrar la salida final en pantalla
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
