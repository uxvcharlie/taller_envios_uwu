En la industria de la logística internacional moderna, las empresas manejan un flujo masivo de envíos a través de múltiples 
canales: terrestre, aéreo y marítimo. Cada medio de transporte tiene sus propias reglas de negocio, tarifas, 
requerimientos legales y mecanismos de seguimiento.

Los sistemas logísticos tradicionales (Legacy Systems) suelen estar construidos con código altamente acoplado y monolítico.
Cuando una empresa intenta agregar un nuevo método de envío o cambiar una regla de negocio
(por ejemplo, cómo se calcula el seguro de una carga marítima), los desarrolladores se ven obligados a modificar cientos de líneas
de código llenas de sentencias if/else interminables. Esto genera alta deuda técnica, código frágil (propenso a errores) y dificulta la escalabilidad.

Solucion: funciona como un "director de orquesta" súper eficiente para una empresa de logística, 
capaz de organizar y cobrar paquetes que viajan por camión, buque o avión sin confundirse.
En lugar de tener manuales de instrucciones enredados y separados para cada tipo de transporte, 
el sistema crea un molde único de reglas que todos deben respetar; de esta forma, si el día de mañana la empresa decide
innovar y empezar a hacer entregas con drones, solo necesitamos agregar a este nuevo integrante al equipo siguiendo el mismo molde, 
sin tener que desarmar, pausar o dañar el trabajo que ya están haciendo los demás transportes.


Relación entre clases
Herencia y Abstracción: La clase abstracta Envio sirve como base para todos los tipos de transporte, forzando un comportamiento común pero permitiendo que cada hijo implemente su propia lógica de costos y despacho.

Composición: Cada Envio está asociado obligatoriamente a un Cliente.

Interfaces (Contratos): IRastreable: Garantiza que todo envío, sin importar el medio, pueda informar su ubicación.

IAsegurable: Es un contrato selectivo. Solo los envíos internacionales (Aéreo/Marítimo) están obligados a implementar el cálculo de seguros.

Agregación: El GestorEnvios actúa como un servicio que administra una colección de objetos Envio mediante polimorfismo.

Documentación del archivo
Interfaces
IRastreable: Define los métodos rastrearUbicacion() y obtenerEstado().

IAsegurable: Define calcularCostoSeguro(double valorCarga) para el cálculo de pólizas.



Entidades (Models)
Envio (Abstracta): Contiene los atributos protegidos numeroGuia, cliente y estadoActual. Define los métodos abstractos procesarDespacho() y calcularCostoDespacho().

EnvioTerrestre: Especializada en logística terrestre. Utiliza distanciaKm para calcular costos.

EnvioAereo: Implementa seguros y basa su costo en pesoKg.

EnvioMaritimo: Implementa seguros y basa su costo en numeroContenedores.

Cliente: Clase simple que encapsula la información del remitente.

Servicio (Service)
GestorEnvios: Orquestador del sistema.

agregarEnvio(Envio): Registra nuevos paquetes en el inventario.

generarReporteGeneral(): Itera sobre el inventario usando polimorfismo para mostrar estados y costos.

calcularSeguros(double): Aplica un filtro de tipos (instanceof) para procesar solo aquellos envíos que califican como asegurables.


```classDiagram
    class IRastreable {
        <<interface>>
        +rastrearUbicacion() void
        +obtenerEstado() String
    }
    class IAsegurable {
        <<interface>>
        +calcularCostoSeguro(double valorCarga) double
    }
    class Envio {
        <<abstract>>
        #String numeroGuia
        #Cliente cliente
        #String estadoActual
        +procesarDespacho()* void
        +calcularCostoDespacho()* double
    }
    class EnvioTerrestre {
        -double distanciaKm
        +procesarDespacho() void
        +calcularCostoDespacho() double
    }
    class EnvioAereo {
        -double pesoKg
        +procesarDespacho() void
        +calcularCostoDespacho() double
        +calcularCostoSeguro(double valorCarga) double
    }
    class EnvioMaritimo {
        -int numeroContenedores
        +procesarDespacho() void
        +calcularCostoDespacho() double
        +calcularCostoSeguro(double valorCarga) double
    }
    class Cliente {
        -String nombre
        -String correo
        +getNombre() String
    }
    class GestorEnvios {
        -List~Envio~ inventario
        +agregarEnvio(Envio envio) void
        +generarReporteGeneral() void
        +calcularSeguros(double valorCarga) void
    }

    IRastreable <|.. Envio : Implementa
    Envio <|-- EnvioTerrestre : Hereda
    Envio <|-- EnvioAereo : Hereda
    Envio <|-- EnvioMaritimo : Hereda
    IAsegurable <|.. EnvioAereo : Implementa
    IAsegurable <|.. EnvioMaritimo : Implementa
    Envio "1" --> "1" Cliente : Posee
    GestorEnvios "1" o-- "0..*" Envio : Agrega```
