# Examen Parcial Práctico - Estructura de Datos 1

**Estudiante:** Juan Carlos Vargas Hernández  
**Carné:** 202104264  
**Catedrático:** Ing. Brandon Chitay  
**Universidad:** Universidad Da Vinci de Guatemala  

## 📌 Descripción del Proyecto
Este proyecto es un benchmark desarrollado en Java diseñado para medir, comparar y analizar el rendimiento (complejidad temporal Big-O) de cuatro algoritmos fundamentales en sus versiones **Iterativas** y **Recursivas**:

1. **A1 - Factorial:** Complejidad esperada O(n)
2. **A2 - Serie de Fibonacci:** Complejidad esperada Iterativo O(n) vs Recursivo O(2^n)
3. **A3 - Búsqueda Lineal:** Complejidad esperada O(n)
4. **A4 - Ordenamiento Burbuja:** Complejidad esperada O(n^2)

El programa ejecuta cada algoritmo con distintos volúmenes de datos (n). Para garantizar la precisión y reducir el ruido del Garbage Collector de la JVM, cada prueba se ejecuta 5 veces usando `System.nanoTime()` y se calcula un promedio. Finalmente, los resultados se exportan de forma automática a un archivo CSV para su análisis en Excel.

## 🎥 Video de Demostración
En el siguiente video se explica la estructura del código, la compilación, la ejecución y el análisis de las gráficas de rendimiento resultantes:

* **Enlace a YouTube:** [👉 https://youtu.be/GyBh2k2b9aI 👈]

---

## 📂 Estructura del Proyecto
* `src/algorithms/`: Lógica pura de los 4 algoritmos requeridos.
* `src/benchmark/`: Contiene el `Medidor` de tiempo y la clase `Main` de orquestación.
* `src/utils/`: Contiene el `GeneradorDatos` para crear los arreglos de prueba.
* `resultados/`: Carpeta autogenerada donde se exporta el archivo `tiempos.csv`.

## ⚙️ Instrucciones de Compilación y Ejecución

Para ejecutar este proyecto de forma local, asegúrate de tener instalado el JDK de Java (versión 11 o superior).

### Paso 1: Abrir la terminal
Ubícate en la carpeta raíz del proyecto (donde se encuentra este archivo README.md y la carpeta `src`).

### Paso 2: Compilar el código
Ejecuta el siguiente comando para compilar todos los archivos fuente e indicarle a Java que los guarde en la carpeta `out`:


javac -d out src/algorithms/*.java src/utils/*.java src/benchmark/*.java

### Paso3: ejecutar el código
Ejecuta el siguiente comando para que corran las salidas de los tiempos:
java -cp out benchmark.Main
