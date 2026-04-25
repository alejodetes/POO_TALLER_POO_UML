import java.util.ArrayList;
import java.util.List;

/**
 * Clase Cliente – Proyecto Integrador
 * Sistema de gestión de solicitudes de soporte técnico.
 *
 * Diagrama UML:
 * ┌─────────────────────────────────┐
 * │            Cliente              │
 * ├─────────────────────────────────┤
 * │ - id        : int               │
 * │ - nombre    : String            │
 * │ - email     : String            │
 * │ - telefono  : String            │
 * ├─────────────────────────────────┤
 * │ + crearSolicitud() : Solicitud  │
 * │ + consultarEstado() : String    │
 * └─────────────────────────────────┘
 */
public class Cliente {

    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private List<SolicitudSoporte> solicitudes;

    public Cliente(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.solicitudes = new ArrayList<>();
    }

    /**
     * Crea una nueva solicitud de soporte asociada a este cliente.
     */
    public SolicitudSoporte crearSolicitud(String descripcion) {
        SolicitudSoporte solicitud = new SolicitudSoporte(
            solicitudes.size() + 1, descripcion, this
        );
        solicitudes.add(solicitud);
        System.out.println("[Cliente] Solicitud creada: " + solicitud.getId());
        return solicitud;
    }

    /**
     * Muestra el estado de todas las solicitudes del cliente.
     */
    public String consultarEstado() {
        if (solicitudes.isEmpty()) {
            return "No hay solicitudes registradas.";
        }
        StringBuilder sb = new StringBuilder();
        for (SolicitudSoporte s : solicitudes) {
            sb.append("  Solicitud #").append(s.getId())
              .append(" → ").append(s.getEstado()).append("\n");
        }
        return sb.toString();
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public String getTelefono() { return telefono; }
    public List<SolicitudSoporte> getSolicitudes() { return solicitudes; }

    @Override
    public String toString() {
        return "Cliente{id=" + id + ", nombre='" + nombre + "', email='" + email + "'}";
    }
}
