import java.time.LocalDate;

/**
 * Clase SolicitudSoporte – Proyecto Integrador
 * Representa una solicitud de soporte técnico generada por un cliente.
 *
 * Diagrama UML:
 * ┌──────────────────────────────────────┐
 * │           SolicitudSoporte           │
 * ├──────────────────────────────────────┤
 * │ - id              : int              │
 * │ - descripcion     : String           │
 * │ - fechaApertura   : Date             │
 * │ - estado          : String           │
 * ├──────────────────────────────────────┤
 * │ + asignarTecnico(t) : void           │
 * │ + cerrarSolicitud() : void           │
 * │ + cambiarEstado(e)  : void           │
 * └──────────────────────────────────────┘
 */
public class SolicitudSoporte {

    private int id;
    private String descripcion;
    private LocalDate fechaApertura;
    private String estado;
    private Cliente cliente;
    private Tecnico tecnico;

    // Estados válidos
    public static final String ABIERTA    = "ABIERTA";
    public static final String EN_PROCESO = "EN_PROCESO";
    public static final String CERRADA    = "CERRADA";

    public SolicitudSoporte(int id, String descripcion, Cliente cliente) {
        this.id = id;
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.fechaApertura = LocalDate.now();
        this.estado = ABIERTA;
        this.tecnico = null;
    }

    /**
     * Asigna un técnico a esta solicitud y cambia el estado a EN_PROCESO.
     */
    public void asignarTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
        this.estado = EN_PROCESO;
        System.out.println("[Solicitud #" + id + "] Técnico asignado: " + tecnico.getNombre());
    }

    /**
     * Cierra la solicitud una vez resuelta.
     */
    public void cerrarSolicitud() {
        this.estado = CERRADA;
        if (tecnico != null) {
            tecnico.marcarDisponible();
        }
        System.out.println("[Solicitud #" + id + "] Cerrada exitosamente.");
    }

    /**
     * Cambia el estado de la solicitud manualmente.
     */
    public void cambiarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }

    // Getters
    public int getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public LocalDate getFechaApertura() { return fechaApertura; }
    public String getEstado() { return estado; }
    public Cliente getCliente() { return cliente; }
    public Tecnico getTecnico() { return tecnico; }

    @Override
    public String toString() {
        return "SolicitudSoporte{id=" + id + ", estado='" + estado +
               "', descripcion='" + descripcion + "'}";
    }
}
