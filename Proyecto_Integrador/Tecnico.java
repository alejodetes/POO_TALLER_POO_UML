/**
 * Clase Tecnico – Proyecto Integrador
 *
 * Diagrama UML:
 * ┌─────────────────────────────────────┐
 * │              Tecnico                │
 * ├─────────────────────────────────────┤
 * │ - id           : int                │
 * │ - nombre       : String             │
 * │ - especialidad : String             │
 * │ - disponible   : boolean            │
 * ├─────────────────────────────────────┤
 * │ + atenderSolicitud(s) : void        │
 * │ + marcarDisponible()  : void        │
 * └─────────────────────────────────────┘
 */
public class Tecnico {

    private int id;
    private String nombre;
    private String especialidad;
    private boolean disponible;

    public Tecnico(int id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.disponible = true;
    }

    public void atenderSolicitud(SolicitudSoporte solicitud) {
        if (!disponible) {
            System.out.println("[Técnico " + nombre + "] No disponible actualmente.");
            return;
        }
        disponible = false;
        solicitud.asignarTecnico(this);
        System.out.println("[Técnico " + nombre + "] Atendiendo solicitud #" + solicitud.getId());
    }

    public void marcarDisponible() {
        this.disponible = true;
        System.out.println("[Técnico " + nombre + "] Ahora disponible.");
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }
    public boolean isDisponible() { return disponible; }

    @Override
    public String toString() {
        return "Tecnico{id=" + id + ", nombre='" + nombre +
               "', especialidad='" + especialidad + "', disponible=" + disponible + "}";
    }
}
