import java.util.List;
import java.util.PriorityQueue;

public class Main2 {
    public static void main(String[] args) {
        LectorPacientes lector = new LectorPacientes();
        List<Paciente> pacientesLeidos = lector.leerArchivo("pacientes.txt");

        if (pacientesLeidos.isEmpty()) {
            System.out.println("No hay pacientes");
            return;
        }

        PriorityQueue<Paciente> colaEmergencias = new PriorityQueue<>();
        for (Paciente p : pacientesLeidos) {
            colaEmergencias.offer(p);
        }

        System.out.println("\nORDEN DE ATENCION DE PACIENTES (JCF)");
        while (!colaEmergencias.isEmpty()) {
            Paciente atendido = colaEmergencias.poll();
            System.out.println(atendido.toString());
        }
    }
}
