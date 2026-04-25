"""
Proyecto Integrador – Sistema de Gestión de Soporte Técnico
Transformación UML → Python

Clases: Cliente, SolicitudSoporte, Tecnico, Servicio
"""
from datetime import date


class Servicio:
    """Representa el tipo de servicio técnico prestado."""

    def __init__(self, id_serv: int, tipo: str, descripcion: str):
        self.__id = id_serv
        self.__tipo = tipo
        self.__descripcion = descripcion

    def mostrarDetalle(self) -> str:
        return f"Servicio #{self.__id} [{self.__tipo}]: {self.__descripcion}"

    @property
    def id(self): return self.__id
    @property
    def tipo(self): return self.__tipo
    @property
    def descripcion(self): return self.__descripcion


class Tecnico:
    """Técnico responsable de atender solicitudes de soporte."""

    def __init__(self, id_tec: int, nombre: str, especialidad: str):
        self.__id = id_tec
        self.__nombre = nombre
        self.__especialidad = especialidad
        self.__disponible = True

    def atenderSolicitud(self, solicitud: 'SolicitudSoporte'):
        if not self.__disponible:
            print(f"[Técnico {self.__nombre}] No disponible actualmente.")
            return
        self.__disponible = False
        solicitud.asignarTecnico(self)
        print(f"[Técnico {self.__nombre}] Atendiendo solicitud #{solicitud.id}")

    def marcarDisponible(self):
        self.__disponible = True
        print(f"[Técnico {self.__nombre}] Ahora disponible.")

    @property
    def id(self): return self.__id
    @property
    def nombre(self): return self.__nombre
    @property
    def especialidad(self): return self.__especialidad
    @property
    def disponible(self): return self.__disponible

    def __str__(self):
        return (f"Tecnico(id={self.__id}, nombre='{self.__nombre}', "
                f"especialidad='{self.__especialidad}', disponible={self.__disponible})")


class SolicitudSoporte:
    """Solicitud de soporte técnico generada por un cliente."""

    ABIERTA    = "ABIERTA"
    EN_PROCESO = "EN_PROCESO"
    CERRADA    = "CERRADA"

    def __init__(self, id_sol: int, descripcion: str, cliente: 'Cliente'):
        self.__id = id_sol
        self.__descripcion = descripcion
        self.__cliente = cliente
        self.__fecha_apertura = date.today()
        self.__estado = self.ABIERTA
        self.__tecnico = None

    def asignarTecnico(self, tecnico: Tecnico):
        self.__tecnico = tecnico
        self.__estado = self.EN_PROCESO
        print(f"[Solicitud #{self.__id}] Técnico asignado: {tecnico.nombre}")

    def cerrarSolicitud(self):
        self.__estado = self.CERRADA
        if self.__tecnico:
            self.__tecnico.marcarDisponible()
        print(f"[Solicitud #{self.__id}] Cerrada exitosamente.")

    def cambiarEstado(self, nuevo_estado: str):
        self.__estado = nuevo_estado

    @property
    def id(self): return self.__id
    @property
    def descripcion(self): return self.__descripcion
    @property
    def estado(self): return self.__estado
    @property
    def cliente(self): return self.__cliente
    @property
    def tecnico(self): return self.__tecnico

    def __str__(self):
        return (f"SolicitudSoporte(id={self.__id}, estado='{self.__estado}', "
                f"descripcion='{self.__descripcion}')")


class Cliente:
    """Cliente que genera solicitudes de soporte."""

    def __init__(self, id_cli: int, nombre: str, email: str, telefono: str):
        self.__id = id_cli
        self.__nombre = nombre
        self.__email = email
        self.__telefono = telefono
        self.__solicitudes: list[SolicitudSoporte] = []

    def crearSolicitud(self, descripcion: str) -> SolicitudSoporte:
        solicitud = SolicitudSoporte(
            len(self.__solicitudes) + 1, descripcion, self
        )
        self.__solicitudes.append(solicitud)
        print(f"[Cliente] Solicitud creada: #{solicitud.id}")
        return solicitud

    def consultarEstado(self) -> str:
        if not self.__solicitudes:
            return "No hay solicitudes registradas."
        resultado = ""
        for s in self.__solicitudes:
            resultado += f"  Solicitud #{s.id} → {s.estado}\n"
        return resultado

    @property
    def id(self): return self.__id
    @property
    def nombre(self): return self.__nombre
    @property
    def email(self): return self.__email
    @property
    def solicitudes(self): return self.__solicitudes

    def __str__(self):
        return f"Cliente(id={self.__id}, nombre='{self.__nombre}', email='{self.__email}')"


# ── Demostración del sistema ───────────────────────────────────────────────────
if __name__ == "__main__":
    print("=" * 50)
    print("   SISTEMA DE GESTIÓN DE SOPORTE TÉCNICO")
    print("=" * 50)

    # Crear objetos
    cliente1 = Cliente(1, "Ana García", "ana@empresa.com", "300-123-4567")
    tecnico1 = Tecnico(1, "Carlos Ruiz", "Redes y conectividad")
    servicio1 = Servicio(1, "Soporte remoto", "Asistencia técnica vía escritorio remoto")

    print(f"\nCliente registrado: {cliente1}")
    print(f"Técnico disponible: {tecnico1}")
    print(f"Servicio: {servicio1.mostrarDetalle()}")

    # Flujo completo
    print("\n--- Creando solicitud ---")
    sol = cliente1.crearSolicitud("El equipo no conecta a la VPN corporativa")

    print("\n--- Asignando técnico ---")
    tecnico1.atenderSolicitud(sol)

    print("\n--- Estado de solicitudes del cliente ---")
    print(cliente1.consultarEstado())

    print("\n--- Cerrando solicitud ---")
    sol.cerrarSolicitud()

    print("\n--- Estado final ---")
    print(cliente1.consultarEstado())
    print(f"Técnico disponible nuevamente: {tecnico1.disponible}")
