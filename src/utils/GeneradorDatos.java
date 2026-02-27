package utils;

import java.util.Random;

/**
 * ============================================================
 * CLASE UTILITARIA - GENERADOR DE DATOS
 * ============================================================
 * Se encarga de crear arreglos de enteros con valores aleatorios
 * para las pruebas de Búsqueda Lineal y Ordenamiento Burbuja.
 * ============================================================
 */
public class GeneradorDatos {

    /**
     * Genera un arreglo de tamaño 'n' lleno de números enteros aleatorios.
     * * @param n El tamaño del arreglo a generar.
     * @return Un arreglo de enteros desordenados.
     */
    public static int[] generarArregloAleatorio(int n) {
        int[] arreglo = new int[n];
        Random random = new Random();
        
        for (int i = 0; i < n; i++) {
            // Genera números aleatorios entre 1 y 10,000
            arreglo[i] = random.nextInt(10000) + 1; 
        }
        
        return arreglo;
    }
}