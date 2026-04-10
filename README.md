# 🍿 Máquina de Snacks

Una aplicación de consola en Java que simula una máquina expendedora de snacks interactiva. El proyecto cuenta con **dos implementaciones**: una versión inicial en memoria y una versión avanzada con persistencia en archivos, arquitectura por capas y uso de interfaces.

## 📋 Descripción

Este proyecto implementa un sistema completo de máquina expendedora que gestiona un inventario de snacks, procesa compras y genera tickets de venta. A lo largo de su desarrollo, el proyecto evolucionó de una arquitectura monolítica a un diseño modular con separación de responsabilidades, aplicando principios clave de programación orientada a objetos como abstracción, encapsulación y polimorfismo.

## ✨ Características

- **🛒 Compra de Snacks**: Selecciona snacks del inventario disponible usando su ID
- **🧾 Generación de Tickets**: Visualiza un ticket detallado con todos los productos comprados y el total acumulado
- **➕ Agregar Productos**: Añade nuevos snacks al inventario de forma dinámica
- **📋 Listar Inventario**: Consulta en cualquier momento los snacks disponibles
- **💾 Persistencia en Archivos**: La versión avanzada guarda y carga el inventario desde un archivo `.txt`
- **🔌 Diseño por Interfaces**: Permite intercambiar fácilmente entre persistencia en lista o en archivo
- **🛡️ Manejo de Errores**: Validación de IDs y manejo de excepciones

## 🚀 Tecnologías Utilizadas

- **Lenguaje**: Java 21
- **Paradigma**: Programación Orientada a Objetos (POO)
- **Colecciones**: `ArrayList`, `List` para gestión de inventario
- **E/S**: `Scanner` para entrada de datos, `FileWriter` / `Files` para persistencia
- **Serialización**: Interfaz `Serializable` en el modelo de dominio
- **Diseño**: Interfaces, capas de arquitectura (Dominio, Servicio, Presentación) y uso de paquetes.

## 📁 Estructura del Proyecto

```
maquina_snacks/
│
├── src/
│   │
│   ├── 📂 maquina_snacks/ (Versión 1 - En Memoria - Empaquetado)
│   │   ├── MaquinaSnacks.java          # Clase principal con menú interactivo
│   │   ├── Snack.java                  # Modelo de datos del snack
│   │   └── Snacks.java                 # Gestión estática del inventario en memoria
│   │
│   ├── 📂 maquina_snacks_archivos/ (Versión 2 - Con persistencia)
│   │   ├── dominio/
│   │   │   └── Snack.java          # Modelo de dominio con método escribirSnack()
│   │   ├── servicio/
│   │   │   ├── IServicioSnacks.java          # Interfaz del servicio de snacks
│   │   │   ├── ServicioSnacksLista.java      # Implementación con lista en memoria
│   │   │   └── ServicioSnacksArchivos.java   # Implementación con persistencia en .txt
│   │   └── presentacion/
│   │       └── MaquinaSnacks.java  # Clase principal refactorizada (versión 2)
│
├── snacks.txt                      # Archivo de datos del inventario (generado automáticamente)
└── out/                            # Archivos compilados
```

## 🏗️ Arquitectura del Código

### Versión 1 — Inventario en Memoria (`maquina_snacks`)

| Clase | Descripción |
|---|---|
| `Snack.java` | Modelo de datos: ID autoincremental, nombre, precio. Implementa `Serializable`, `equals()`, `hashCode()` y `toString()` |
| `Snacks.java` | Clase utilitaria con lista estática. Inicializa el inventario con snacks predefinidos y expone métodos para agregar y mostrar |
| `MaquinaSnacks.java` | Clase principal. Gestiona el menú, las opciones del usuario y el flujo de compra mediante `switch` expressions |

### Versión 2 — Arquitectura por Capas con Persistencia (`maquina_snacks_archivos`)

| Clase / Interfaz | Capa | Descripción |
|---|---|---|
| `Snack.java` | Dominio | Misma lógica de V1, con el método extra `escribirSnack()` para serializar a CSV |
| `IServicioSnacks.java` | Servicio | Interfaz con los contratos: `agregarSnack()`, `mostrarSnacks()`, `getSnacks()` |
| `ServicioSnacksLista.java` | Servicio | Implementación que gestiona el inventario en una lista estática en memoria |
| `ServicioSnacksArchivos.java` | Servicio | Implementación corregida que persiste el inventario en `snacks.txt`. Crea el archivo si no existe, carga los datos correctamente en memoria al inicio y expone la lista para su uso en la aplicación |
| `MaquinaSnacks.java` | Presentación | Clase principal refactorizada que usa `IServicioSnacks` (inyección de dependencia), con opción adicional para listar inventario |

> **💡 Cambiar entre implementaciones** es tan sencillo como comentar/descomentar una línea en `maquina_snacks_archivos/presentacion/MaquinaSnacks.java`:
> ```java
> // IServicioSnacks servicioSnacks = new ServicioSnacksLista();  // ← en memoria
> IServicioSnacks servicioSnacks = new ServicioSnacksArchivos();  // ← con archivos
> ```

## 💻 Requisitos

- **Java Development Kit (JDK)** 21
- Un IDE como IntelliJ IDEA, Eclipse, o NetBeans (recomendado)

## 🔧 Instalación y Ejecución

### 1. Clonar el repositorio

```bash
git clone https://github.com/luisflorez20/maquina_snacks.git
cd maquina_snacks
```

### 2. Versión 1 — En Memoria

```bash
# Ejecutar desde tu IDE la clase:
maquina_snacks.MaquinaSnacks
```

### 3. Versión 2 — Con persistencia en archivos

```bash
# Ejecutar desde tu IDE la clase:
maquina_snacks_archivos.presentacion.MaquinaSnacks
```

> **Nota**: El proyecto ahora cuenta con la configuración de módulos de IntelliJ (`.iml`), por lo que al abrir la carpeta raíz en IntelliJ IDEA, el directorio `src/` será reconocido automáticamente y podrás ejecutar las clases principales dando clic derecho -> `Run`.

## 📖 Uso

Al ejecutar la aplicación (versión 2), verás:

```
 *** Maquina de Snacks ***
--- Snacks en el Inventario ---
Snack{idSnack=1, nombre='Papas', precio=20.0}
Snack{idSnack=2, nombre='InKaCola', precio=30.0}
Snack{idSnack=3, nombre='Palomitas', precio=40.0}

Menu:
1. Comprar snacks
2. Mostrar ticket
3. Agregar Nuevo snack
4. salir
Elige una opcion:
```

### Opciones del Menú

| Opción | Acción |
|---|---|
| `1` | **Comprar snack** — Ingresa el ID del snack para agregarlo al carrito de compra |
| `2` | **Mostrar ticket** — Visualiza todos los productos comprados y el total acumulado |
| `3` | **Agregar snack** — Ingresa nombre y precio para añadir un nuevo producto al inventario y archivo de texto |
| `4` | **Salir** — Termina la ejecución de la aplicación |

## 📝 Ejemplo de Sesión

```
Elige una opcion: 1
Que snack quieres comprar (id)? 1
Snack agregado: Snack{idSnack=1, nombre='Papas', precio=20.0}

Elige una opcion: 1
Que snack quieres comprar (id)? 3
Snack agregado: Snack{idSnack=3, nombre='Palomitas', precio=40.0}

Elige una opcion: 2
*** Ticket de Venta ***
	- Papas - $20.0
	- Palomitas - $40.0
	Total de ventas: $60.0

Elige una opcion: 3
Nombre del snack: Doritos
Precio: 25.0
Tu snack se ha agregado correctamente:
--- Snacks en el Inventario ---
Snack{idSnack=1, nombre='Papas', precio=20.0}
Snack{idSnack=2, nombre='InKaCola', precio=30.0}
Snack{idSnack=3, nombre='Palomitas', precio=40.0}
Snack{idSnack=4, nombre='Doritos', precio=25.0}
```

## 🎯 Conceptos Aplicados

- **Programación Orientada a Objetos**: Encapsulación, herencia implícita, polimorfismo vía interfaces
- **Interfaz `IServicioSnacks`**: Abstracción del servicio de inventario, facilita la inyección de dependencias
- **Bloque estático inicializador**: Carga de datos al inicializar la clase
- **Generación automática de IDs**: Contador estático incremental en la clase `Snack`
- **Manejo de archivos**: `FileWriter`, `PrintWriter` para escritura; `Files.readAllLines()` para lectura y corrección de extensiones de archivo (`.txt`).
- **Switch expressions (Java 14+)**: Sintaxis moderna con `->`
- **Text Blocks (Java 15+)**: Uso de `"""` para los menús de consola
- **Manejo de Excepciones**: Bloques `try-catch-finally` para robustez
- **Organización en Paquetes**: Separación lógica de las versiones del proyecto y sus capas (`dominio`, `servicio`, `presentacion`).

## 🛠️ Mejoras Futuras

- [ ] Control de stock y cantidades por producto
- [ ] Sistema de pago con cálculo de cambio
- [ ] Persistencia en base de datos (ej: SQLite con JDBC)
- [ ] Interfaz gráfica (JavaFX o Swing)
- [ ] Categorización y filtrado de productos
- [ ] Sistema de descuentos y promociones
- [ ] Registro de historial de ventas con fecha y hora
- [ ] Pruebas unitarias con JUnit

## 👨‍💻 Autor

**Luis Flores**
- GitHub: [@luisflorez20](https://github.com/luisflorez20)

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar este proyecto:

1. Haz un Fork del proyecto
2. Crea una rama para tu característica (`git checkout -b feature/NuevaCaracteristica`)
3. Realiza tus cambios y haz commit (`git commit -m 'Agregar nueva característica'`)
4. Sube los cambios a tu rama (`git push origin feature/NuevaCaracteristica`)
5. Abre un Pull Request

---

⭐ Si este proyecto te fue útil, considera darle una estrella en GitHub