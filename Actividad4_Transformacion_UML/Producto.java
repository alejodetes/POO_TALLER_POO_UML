/**
 * Clase Producto – Actividad 4
 * Transformación UML → Java
 *
 * Diagrama UML de origen:
 * ┌──────────────────────────┐
 * │         Producto         │
 * ├──────────────────────────┤
 * │ - codigo  : String       │
 * │ - nombre  : String       │
 * │ - precio  : double       │
 * ├──────────────────────────┤
 * │ + mostrarInfo() : void   │
 * └──────────────────────────┘
 */
public class Producto {

    // Atributos (visibilidad privada indicada por "-" en UML)
    private String codigo;
    private String nombre;
    private double precio;

    // Constructor
    public Producto(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    /**
     * Método mostrarInfo() – indicado con "+" (público) en el UML
     * Imprime en consola la información del producto.
     */
    public void mostrarInfo() {
        System.out.println("=== Información del Producto ===");
        System.out.println("Código : " + codigo);
        System.out.println("Nombre : " + nombre);
        System.out.printf("Precio : $%.2f%n", precio);
    }

    // Punto de entrada para prueba
    public static void main(String[] args) {
        // Crear objeto de prueba
        Producto p1 = new Producto("P-001", "Laptop Dell Inspiron", 2499999.99);

        // Mostrar información
        p1.mostrarInfo();

        System.out.println("\n--- Modificando precio ---");
        p1.setPrecio(2299999.99);
        p1.mostrarInfo();
    }
}
