package algorithms;

/**
 * ============================================================
 * A3 - BÚSQUEDA LINEAL
 * ============================================================
 * Busca un valor en un arreglo recorriendo elemento por elemento.
 * Retorna el índice donde se encuentra el valor o -1 si no existe.
 *
 * Complejidad temporal:
 * - Iterativo:  O(n)   — recorre el arreglo linealmente
 * - Recursivo:  O(n)   — profundidad máxima de n en el call stack
 * ============================================================
 */
public class BusquedaLineal {

    // ----------------------------------------------------------------
    // VERSIÓN ITERATIVA
    // ----------------------------------------------------------------
    /**
     * Busca un elemento iterando con un ciclo for clásico.
     *
     * @param arr arreglo de enteros donde buscar
     * @param objetivo valor que deseamos encontrar
     * @return índice del objetivo, o -1 si no se encuentra
     */
    public static int iterativo(int[] arr, int objetivo) {
        if (arr == null) throw new IllegalArgumentException("El arreglo no puede ser nulo");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == objetivo) {
                return i; // Se encontró el elemento
            }
        }
        return -1; // No se encontró
    }

    // ----------------------------------------------------------------
    // VERSIÓN RECURSIVA
    // ----------------------------------------------------------------
    /**
     * Busca un elemento recursivamente evaluando un índice a la vez.
     * Para usar este método desde el Main, la primera llamada debe 
     * iniciar siempre con indice = 0.
     *
     * @param arr arreglo de enteros donde buscar
     * @param objetivo valor que deseamos encontrar
     * @param indice posición actual siendo evaluada
     * @return índice del objetivo, o -1 si no se encuentra
     */
    public static int recursivo(int[] arr, int objetivo, int indice) {
        if (arr == null) throw new IllegalArgumentException("El arreglo no puede ser nulo");

        // --- CASO BASE 1: Llegamos al final sin encontrarlo ---
        if (indice >= arr.length) return -1;

        // --- CASO BASE 2: Encontramos el elemento ---
        if (arr[indice] == objetivo) return indice;

        // --- LLAMADA RECURSIVA: Revisar el siguiente índice ---
        return recursivo(arr, objetivo, indice + 1);
    }
}