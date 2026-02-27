package benchmark;

import algorithms.Factorial;
import algorithms.Fibonacci;
import algorithms.BusquedaLineal;
import algorithms.OrdenamientoBurbuja;
import utils.GeneradorDatos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ============================================================
 * PUNTO DE ENTRADA — BENCHMARK EXAMEN PARCIAL
 * ============================================================
 * Ejecuta los 4 algoritmos requeridos en sus versiones 
 * iterativas y recursivas, respetando los tamaños de 'n'
 * solicitados en la rúbrica.
 * ============================================================
 */
public class Main {

    // 1. TAMAÑOS DE DATOS EXACTOS SEGÚN EL EXAMEN
    // Para Factorial (Max 20) y Fibonacci (Max 30)
    private static final int[] TAMANOS_MATEMATICOS = {5, 10, 15, 20, 25, 30}; 
    
    // Para Búsqueda y Burbuja (Tamaños mayores)
    private static final int[] TAMANOS_ARREGLOS = {100, 500, 1000, 5000, 10000};

    private static final String CSV_PATH = "resultados/tiempos.csv";

    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println("  INICIANDO BENCHMARK - EXAMEN PARCIAL");
        System.out.println("============================================================\n");

        // StringBuilder para almacenar el CSV tal cual lo pide el excel: Algoritmo | Version | n | Tiempo_ms
        StringBuilder csv = new StringBuilder();
        csv.append("Algoritmo,Version,n,Tiempo_ms\n");

        // ==========================================================
        // A1 - FACTORIAL (O(n)) - Límite n = 20
        // ==========================================================
        System.out.println("  A1 - FACTORIAL [Esperado: O(n)]");
        Medidor.imprimirEncabezado();
        for (int n : TAMANOS_MATEMATICOS) {
            if (n > 20) break; // Regla: Limita n a 20 máximo

            double tIter = Medidor.medir(() -> Factorial.iterativo(n));
            Medidor.imprimirFila("Factorial", "Iterativo", n, tIter);
            csv.append(String.format("Factorial,Iterativo,%d,%.6f%n", n, tIter));

            double tRec = Medidor.medir(() -> Factorial.recursivo(n));
            Medidor.imprimirFila("Factorial", "Recursivo", n, tRec);
            csv.append(String.format("Factorial,Recursivo,%d,%.6f%n", n, tRec));
        }

        // ==========================================================
        // A2 - FIBONACCI - Límite n = 30
        // ==========================================================
        System.out.println("\n  A2 - FIBONACCI [Esperado: Iterativo O(n) | Recursivo O(2^n)]");
        Medidor.imprimirEncabezado();
        for (int n : TAMANOS_MATEMATICOS) {
            if (n > 30) break; // Regla: Limita n a 30 máximo

            double tIter = Medidor.medir(() -> Fibonacci.iterativo(n));
            Medidor.imprimirFila("Fibonacci", "Iterativo", n, tIter);
            csv.append(String.format("Fibonacci,Iterativo,%d,%.6f%n", n, tIter));

            double tRec = Medidor.medir(() -> Fibonacci.recursivo(n));
            Medidor.imprimirFila("Fibonacci", "Recursivo", n, tRec);
            csv.append(String.format("Fibonacci,Recursivo,%d,%.6f%n", n, tRec));
        }

        // ==========================================================
        // A3 - BÚSQUEDA LINEAL (O(n))
        // ==========================================================
        System.out.println("\n  A3 - BUSQUEDA LINEAL [Esperado: O(n)]");
        Medidor.imprimirEncabezado();
        for (int n : TAMANOS_ARREGLOS) {
            // Generar datos AFUERA del bloque a medir (como indica el examen)
            // Asumiendo que tienes este método en utils.GeneradorDatos
            int[] datos = GeneradorDatos.generarArregloAleatorio(n); 
            
            // Buscamos un número que probablemente NO esté (Peor caso)
            int objetivo = -1; 

            double tIter = Medidor.medir(() -> BusquedaLineal.iterativo(datos, objetivo));
            Medidor.imprimirFila("Busqueda", "Iterativo", n, tIter);
            csv.append(String.format("Busqueda Lineal,Iterativo,%d,%.6f%n", n, tIter));

            // Nota: Asumo que tu método recursivo recibe (arreglo, objetivo, indiceInicial)
            double tRec = Medidor.medir(() -> BusquedaLineal.recursivo(datos, objetivo, 0));
            Medidor.imprimirFila("Busqueda", "Recursivo", n, tRec);
            csv.append(String.format("Busqueda Lineal,Recursivo,%d,%.6f%n", n, tRec));
        }

        // ==========================================================
        // A4 - ORDENAMIENTO BURBUJA (O(n^2))
        // ==========================================================
        System.out.println("\n  A4 - ORDENAMIENTO BURBUJA [Esperado: O(n^2)]");
        Medidor.imprimirEncabezado();
        for (int n : TAMANOS_ARREGLOS) {
            int[] datos = GeneradorDatos.generarArregloAleatorio(n);

            // Usamos .clone() para que cada una de las 5 repeticiones ordene un arreglo desordenado.
            double tIter = Medidor.medir(() -> OrdenamientoBurbuja.iterativo(datos.clone()));
            Medidor.imprimirFila("Burbuja", "Iterativo", n, tIter);
            csv.append(String.format("Burbuja,Iterativo,%d,%.6f%n", n, tIter));

            // Nota: Asumo que tu método recursivo recibe (arreglo, n_elementos)
            double tRec = Medidor.medir(() -> OrdenamientoBurbuja.recursivo(datos.clone(), n));
            Medidor.imprimirFila("Burbuja", "Recursivo", n, tRec);
            csv.append(String.format("Burbuja,Recursivo,%d,%.6f%n", n, tRec));
        }

        // 5. EXPORTAR RESULTADOS
        exportarCSV(csv.toString());
    }

    // ==========================================================
    // MÉTODO PARA EXPORTAR A CSV
    // ==========================================================
    private static void exportarCSV(String contenido) {
        File archivoCsv = new File(CSV_PATH);
        File directorio = archivoCsv.getParentFile();
        
        if (directorio != null && !directorio.exists()) {
            directorio.mkdirs(); // Crea la carpeta 'resultados' si no existe
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(archivoCsv))) {
            pw.print(contenido);
            System.out.println("\n============================================================");
            System.out.println("  ✓ Resultados exportados exitosamente a: " + CSV_PATH);
            System.out.println("  (Abre este archivo en Excel para generar tus gráficas)");
            System.out.println("============================================================");
        } catch (IOException e) {
            System.err.println("  ✗ Error al escribir el archivo CSV: " + e.getMessage());
        }
    }
}