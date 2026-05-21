import java.util.List;

public class Main {
    public static void main(String[] args) {
        LectorPacientes lector = new LectorPacientes();
        List<Paciente> pacientesLeidos = lector.leerArchivo("pacientes.txt");

        if (pacientesLeidos.isEmpty()) {
            System.out.println("No hay pacientes");
            return;
        }

        VectorHeap<Paciente> colaEmergencias = new VectorHeap<>();
        for (Paciente p : pacientesLeidos) {
            colaEmergencias.add(p);
        }

        System.out.println("\nORDEN DE ATENCION DE PACIENTES");
        while (!colaEmergencias.isEmpty()) {
            Paciente atendido = colaEmergencias.remove();
            System.out.println(atendido.toString());
        }
    }
}
