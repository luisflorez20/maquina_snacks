# 🍿 Máquina de Snacks

Una aplicación de consola en Java que simula una máquina expendedora de snacks interactiva. Este proyecto permite a los usuarios comprar snacks, ver su ticket de compra, y agregar nuevos productos al inventario.

## 📋 Descripción

Este proyecto implementa un sistema completo de máquina expendedora que gestiona un inventario de snacks, procesa compras y genera tickets de venta. La aplicación utiliza conceptos de programación orientada a objetos y manejo de colecciones en Java.

## ✨ Características

- **🛒 Compra de Snacks**: Selecciona snacks del inventario disponible usando su ID
- **🧾 Generación de Tickets**: Visualiza un ticket detallado con todos los productos comprados y el total
- **➕ Agregar Productos**: Añade nuevos snacks al inventario de forma dinámica
- **📦 Inventario Predefinido**: Incluye snacks iniciales (Papas Lays, Maquis, Inka Cola)
- **🛡️ Manejo de Errores**: Validación de IDs y manejo de excepciones

## 🚀 Tecnologías Utilizadas

- **Lenguaje**: Java
- **Paradigma**: Programación Orientada a Objetos
- **Colecciones**: ArrayList para gestión de inventario
- **E/S**: Scanner para entrada de datos por consola

## 📁 Estructura del Proyecto

```
maquina_snacks/
│
├── src/
│   ├── MaquinaSnacks.java    # Clase principal con la lógica de la aplicación
│   ├── Snack.java             # Modelo de datos para los snacks
│   └── Snacks.java            # Gestión del inventario de snacks
│
└── out/                       # Archivos compilados
```

## 🏗️ Arquitectura del Código

### `Snack.java`
- Clase modelo que representa un producto snack
- Implementa `Serializable` para persistencia
- Incluye generación automática de IDs
- Sobrescribe `equals()`, `hashCode()` y `toString()`

### `Snacks.java`
- Clase de utilidad para gestionar el inventario
- Contiene una lista estática de snacks disponibles
- Proporciona métodos para agregar y mostrar snacks
- Inicializa el inventario con productos predefinidos

### `MaquinaSnacks.java`
- Clase principal con el método `main()`
- Implementa el menú interactivo de la aplicación
- Gestiona el flujo de compra y generación de tickets
- Manejo de excepciones y validaciones

## 💻 Requisitos

- **Java Development Kit (JDK)** 11 o superior
- Un IDE como IntelliJ IDEA, Eclipse, o NetBeans (opcional)

## 🔧 Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/luisflorez20/maquina_snacks.git
   cd maquina_snacks
   ```

2. **Compilar el proyecto**:
   ```bash
   javac src/*.java -d out
   ```

3. **Ejecutar la aplicación**:
   ```bash
   java -cp out MaquinaSnacks
   ```

## 📖 Uso

Al ejecutar la aplicación, verás el siguiente menú:

```
*** Maquina de Snacks ***
--- Snacks en el Inventario ---
Snack{idSnack=1, nombre='Papas Lays', precio=20.0}
Snack{idSnack=2, nombre='Maquis', precio=30.0}
Snack{idSnack=3, nombre='Inka Cola', precio=40.0}

Menu:
1. Comprar snacks
2. Mostrar ticket
3. Agregar Nuevo snack
4. salir
Elige una opcion:
```

### Opciones del Menú

1. **Comprar snacks**: 
   - Ingresa el ID del snack que deseas comprar
   - El snack se agregará a tu carrito
   
2. **Mostrar ticket**: 
   - Visualiza todos los productos comprados
   - Muestra el total acumulado
   
3. **Agregar Nuevo snack**: 
   - Ingresa el nombre y precio del nuevo snack
   - El producto se añadirá al inventario
   
4. **Salir**: 
   - Termina la ejecución del programa

## 📝 Ejemplo de Uso

```
Que snack quieres comprar (id)? 1
Snack agregado: Snack{idSnack=1, nombre='Papas Lays', precio=20.0}

Que snack quieres comprar (id)? 3
Snack agregado: Snack{idSnack=3, nombre='Inka Cola', precio=40.0}

*** Ticket de Venta ***
	- Papas Lays - $20.0
	- Inka Cola - $40.0
	Total de ventas: $60.0
```

## 🎯 Características Técnicas

- **Generación Automática de IDs**: Los snacks tienen IDs únicos incrementales
- **Persistencia en Memoria**: El inventario se mantiene durante la sesión
- **Validación de Entrada**: Verifica que los IDs ingresados existan
- **Manejo de Excepciones**: Captura y gestiona errores de entrada
- **Diseño Modular**: Separación clara de responsabilidades entre clases

## 🛠️ Mejoras Futuras

- [ ] Persistencia de datos en archivos o base de datos
- [ ] Control de stock y cantidades
- [ ] Sistema de pago con cálculo de cambio
- [ ] Interfaz gráfica (GUI)
- [ ] Categorización de productos
- [ ] Sistema de descuentos y promociones
- [ ] Registro de historial de ventas

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

## 📞 Contacto

Si tienes preguntas o sugerencias sobre este proyecto, no dudes en contactarme a través de GitHub.

---

⭐ Si este proyecto te fue útil, considera darle una estrella en GitHub
