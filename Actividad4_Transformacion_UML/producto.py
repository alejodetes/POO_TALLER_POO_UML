"""
Clase Producto – Actividad 4
Transformación UML → Python

Diagrama UML de origen:
┌──────────────────────────┐
│         Producto         │
├──────────────────────────┤
│ - codigo  : String       │
│ - nombre  : String       │
│ - precio  : double       │
├──────────────────────────┤
│ + mostrarInfo() : void   │
└──────────────────────────┘
"""


class Producto:
    """
    Representa un producto con código, nombre y precio.
    Los atributos se declaran como 'privados' usando convención de doble guion bajo (__).
    """

    def __init__(self, codigo: str, nombre: str, precio: float):
        # En Python no existe modificador 'private' como en Java.
        # Se usa la convención __atributo para indicar acceso restringido (name mangling).
        self.__codigo = codigo
        self.__nombre = nombre
        self.__precio = precio

    # --- Getters ---
    @property
    def codigo(self) -> str:
        return self.__codigo

    @property
    def nombre(self) -> str:
        return self.__nombre

    @property
    def precio(self) -> float:
        return self.__precio

    # --- Setters ---
    @codigo.setter
    def codigo(self, valor: str):
        self.__codigo = valor

    @nombre.setter
    def nombre(self, valor: str):
        self.__nombre = valor

    @precio.setter
    def precio(self, valor: float):
        if valor < 0:
            raise ValueError("El precio no puede ser negativo.")
        self.__precio = valor

    # --- Método mostrarInfo() equivalente al UML ---
    def mostrarInfo(self):
        """Imprime en consola la información del producto."""
        print("=== Información del Producto ===")
        print(f"Código : {self.__codigo}")
        print(f"Nombre : {self.__nombre}")
        print(f"Precio : ${self.__precio:,.2f}")


# ── Objeto de prueba ──────────────────────────────────────────────────────────
if __name__ == "__main__":
    # Crear objeto de prueba
    p1 = Producto("P-001", "Laptop Dell Inspiron", 2499999.99)

    # Mostrar información
    p1.mostrarInfo()

    print("\n--- Modificando precio ---")
    p1.precio = 2299999.99
    p1.mostrarInfo()
