/**
 * Clase Servicio – Proyecto Integrador
 * Representa el tipo de servicio técnico prestado.
 *
 * Diagrama UML:
 * ┌──────────────────────────────────┐
 * │             Servicio             │
 * ├──────────────────────────────────┤
 * │ - id          : int              │
 * │ - tipo        : String           │
 * │ - descripcion : String           │
 * ├──────────────────────────────────┤
 * │ + mostrarDetalle() : String      │
 * └──────────────────────────────────┘
 */
public class Servicio {

    private int id;
    private String tipo;
    private String descripcion;

    public Servicio(int id, String tipo, String descripcion) {
        this.id = id;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public String mostrarDetalle() {
        return "Servicio #" + id + " [" + tipo + "]: " + descripcion;
    }

    // Getters
    public int getId() { return id; }
    public String getTipo() { return tipo; }
    public String getDescripcion() { return descripcion; }
}
