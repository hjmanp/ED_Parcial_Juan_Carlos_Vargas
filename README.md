# Examen Parcial - Estructura de Datos 1

**Estudiante:** Juan Carlos Vargas  
**Catedrático:** Ing. Brandon Chitay  
**Universidad:** Universidad Da Vinci de Guatemala  

## 📌 Descripción del Proyecto
Este proyecto es un benchmark desarrollado en Java para medir y analizar el rendimiento de cuatro algoritmos fundamentales en sus versiones **Iterativas** y **Recursivas**:
1. Factorial ($O(n)$)
2. Serie de Fibonacci ($O(n)$ vs $O(2^n)$)
3. Búsqueda Lineal ($O(n)$)
4. Ordenamiento Burbuja ($O(n^2)$)

El programa ejecuta cada algoritmo con distintos volúmenes de datos ($n$), repite cada prueba 5 veces para calcular un promedio preciso (reduciendo el ruido de la JVM) y exporta los resultados a un archivo `.csv` para su posterior análisis de complejidad asintótica (Big-O).

## 📂 Estructura del Repositorio
El proyecto sigue una arquitectura modular estricta:
* `src/algorithms/`: Contiene la lógica pura de los 4 algoritmos requeridos.
* `src/benchmark/`: Contiene el `Medidor` de tiempo (usando `System.nanoTime()`) y el `Main` de ejecución.
* `src/utils/`: Contiene el `GeneradorDatos` para crear los arreglos aleatorios.
* `resultados/`: Carpeta autogenerada donde se exporta el archivo `tiempos.csv`.

## ⚙️ Instrucciones de Compilación y Ejecución

Para ejecutar este proyecto de forma local, asegúrate de tener instalado el JDK de Java (versión 11 o superior).

**Paso 1: Abrir la terminal**
Ubícate en la carpeta raíz del proyecto (donde se encuentra este archivo `README.md` y la carpeta `src`).

**Paso 2: Compilar el código**
Ejecuta el siguiente comando para compilar todos los archivos `.java` y enviarlos a la carpeta `out`:
```bash
javac -d out src/algorithms/*.java src/utils/*.java src/benchmark/*.java