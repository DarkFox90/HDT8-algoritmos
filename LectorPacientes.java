import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorPacientes {
    public List<Paciente> leerArchivo(String rutaArchivo) {
        List<Paciente> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 3) {
                    Paciente p = new Paciente(datos[0], datos[1], datos[2]);
                    lista.add(p);
                }
            }
        } catch (IOException e) {
            System.err.println("error al leer el archivo: " + e.getMessage());
        }
        return lista;
    } 
}
