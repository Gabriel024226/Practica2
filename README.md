# Cave Exploration - Exploración de Cueva

Una aplicación educativa interactiva de Android que simula la exploración de una cueva, permitiendo a los usuarios aprender sobre formaciones geológicas y vida subterránea de manera inmersiva.

## Características Principales

### Modo Día/Noche Dinámico
- **Cambio de tema en tiempo real**: Alterna entre modo día y noche con un interruptor
- **Persistencia de preferencias**: Tu elección de tema se guarda automáticamente usando SharedPreferences
- **Contenido adaptativo**: Las descripciones de las cámaras cambian según el tema seleccionado para mayor inmersión

### Exploración por Cámaras

#### 1. **Entrada de la Cueva** (MainActivity)
- Punto de inicio de la exploración
- Elementos interactivos:
  - **Formación Rocosa**: Aprende sobre rocas calizas y erosión
  - **Musgo en las Paredes**: Descubre la vida vegetal en ambientes húmedos
- Indicador visual de día/noche
- Botón circular para entrar a la cueva

#### 2. **Primera Cámara** (FirstChamberActivity)
- Cámara con formaciones espectaculares
- Elementos educativos:
  - **Estalactitas**: Formaciones que cuelgan del techo
  - **Estalagmitas**: Formaciones que crecen desde el suelo
  - **Columnas**: Resultado de la unión de estalactitas y estalagmitas
- Pasaje visual para continuar la exploración

#### 3. **Cámara de la Laguna** (LagoonChamberActivity)
- Nivel más profundo de la cueva
- Contenido educativo avanzado:
  - **Laguna Subterránea**: Formación y características del agua subterránea
  - **Formaciones de Calcita**: Cristales minerales brillantes
  - **Helictitas**: Formaciones raras que desafían la gravedad
  - **Fauna de Cueva**: Vida adaptada a la oscuridad (troglobios)
- Mensaje de finalización con opción de volver al inicio

## 🔧 Tecnologías y Arquitectura

### Lenguaje y Framework
- **Kotlin**: Lenguaje principal
- **Android SDK**: API 24+ (Android 7.0+)
- **Target SDK**: 36

### Librerías Principales
- **Material Components**: UI moderna y consistente
- **AndroidX**: AppCompat, ConstraintLayout, CardView
- **View Binding**: Acceso seguro a vistas

### Patrones de Diseño
- **Singleton Pattern**: ThemeManager para gestión centralizada del tema
- **Activity Navigation**: Navegación jerárquica con soporte para "back"
- **Material Design**: Siguiendo las guías de diseño de Google

## Persistencia de Datos

### SharedPreferences
La aplicación utiliza `SharedPreferences` para almacenar las preferencias del usuario de forma local y persistente:

```kotlin
// Archivo: ThemeManager.kt
private val prefs: SharedPreferences =
    context.getSharedPreferences("cave_prefs", Context.MODE_PRIVATE)
```

**Datos almacenados:**
- `isDarkModeEnabled`: Booleano que indica si el modo oscuro está activo

**Ventajas:**
- Persistencia entre sesiones
- Almacenamiento ligero para preferencias simples
- Acceso rápido y sincronizado

## Sistema de Temas

### Tema Día (Light Mode)
- Colores tierra y cálidos (#8B7355, #D4C4A8)
- Cielo azul claro (#87CEEB)
- Descripciones que mencionan luz natural

### Tema Noche (Dark Mode)
- Colores oscuros y fríos (#2C2C2C, #1A1A1A)
- Cielo nocturno profundo (#0D47A1)
- Descripciones que enfatizan la oscuridad

## Estructura del Proyecto

```
app/src/main/
├── java/com/example/caveexploration/
│   ├── MainActivity.kt              # Pantalla de entrada
│   ├── FirstChamberActivity.kt      # Primera cámara
│   ├── LagoonChamberActivity.kt     # Cámara de la laguna
│   ├── ThemeManager.kt              # Gestión de temas
│   └── ui/theme/                    # Tema Compose (no usado actualmente)
├── res/
│   ├── layout/                      # Layouts XML
│   │   ├── activity_main.xml
│   │   ├── activity_first_chamber.xml
│   │   ├── activity_lagoon_chamber.xml
│   │   └── item_interactive_element.xml
│   ├── values/                      # Recursos día
│   │   ├── colors.xml
│   │   ├── strings.xml
│   │   └── themes.xml
│   ├── values-night/                # Recursos noche
│   │   ├── colors.xml
│   │   └── themes.xml
│   └── drawable/                    # Recursos gráficos
└── AndroidManifest.xml

```

## Cómo Ejecutar

1. **Requisitos:**
   - Android Studio (última versión)
   - JDK 11 o superior
   - Dispositivo/Emulador con Android 7.0+ (API 24+)

2. **Pasos:**
   ```bash
   git clone <repository-url>
   cd caveexploration
   # Abre el proyecto en Android Studio
   # Espera a que se sincronicen las dependencias
   # Ejecuta la app (Shift + F10)
   ```

## Capturas de Pantalla
**Tema Día**
![WhatsApp Image 2025-10-01 at 4 16 34 PM (2)](https://github.com/user-attachments/assets/3ea30b67-e424-4e21-b2d1-b6b1dee63328)
![WhatsApp Image 2025-10-01 at 4 16 34 PM](https://github.com/user-attachments/assets/1e276c33-7710-4c3e-b5cd-ef1610d88d07)
![WhatsApp Image 2025-10-01 at 4 16 34 PM (1)](https://github.com/user-attachments/assets/ea1797c8-5015-43c4-8556-57e109837d96)
**Tema Noche**
![WhatsApp Image 2025-10-01 at 4 16 34 PM (5)](https://github.com/user-attachments/assets/fd662f98-a805-4b13-9101-ffae5ded2e36)
![WhatsApp Image 2025-10-01 at 4 16 34 PM (3)](https://github.com/user-attachments/assets/1f716398-efc1-41b6-9531-ba18609208d8)
![WhatsApp Image 2025-10-01 at 4 16 34 PM (4)](https://github.com/user-attachments/assets/b7ad9d29-dbf1-4adc-86bf-89c663f49228)
