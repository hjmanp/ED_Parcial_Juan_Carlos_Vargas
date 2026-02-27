package algorithms;

/**
 * ============================================================
 * A4 - ORDENAMIENTO BURBUJA (BUBBLE SORT)
 * ============================================================
 * Ordena un arreglo de n enteros de menor a mayor empujando
 * el valor más grande al final del arreglo en cada pasada.
 *
 * Complejidad temporal:
 * - Iterativo:  O(n^2) — dos ciclos anidados dependientes de n
 * - Recursivo:  O(n^2) — un ciclo interno y una llamada recursiva externa
 * ============================================================
 */
public class OrdenamientoBurbuja {

    // ----------------------------------------------------------------
    // VERSIÓN ITERATIVA
    // ----------------------------------------------------------------
    /**
     * Ordena el arreglo usando doble ciclo for.
     *
     * @param arr arreglo de enteros a ordenar (se modifica in-place)
     */
    public static void iterativo(int[] arr) {
        if (arr == null) throw new IllegalArgumentException("El arreglo no puede ser nulo");

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // El último elemento 'i' ya está ordenado, no necesitamos revisarlo
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Intercambio (Swap)
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ----------------------------------------------------------------
    // VERSIÓN RECURSIVA
    // ----------------------------------------------------------------
    /**
     * Ordena el arreglo de forma recursiva.
     * La llamada inicial debe ser con n = arr.length.
     *
     * @param arr arreglo de enteros a ordenar (se modifica in-place)
     * @param n tamaño de la porción del arreglo que aún no está ordenada
     */
    public static void recursivo(int[] arr, int n) {
        if (arr == null) throw new IllegalArgumentException("El arreglo no puede ser nulo");

        // --- CASO BASE: Si el tamaño es 1, el arreglo ya está ordenado ---
        if (n <= 1) return;

        // --- PASADA INTERNA: Empuja el elemento más grande al final ---
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                // Intercambio (Swap)
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }

        // --- LLAMADA RECURSIVA ---
        // El elemento más grande ya está en la posición n-1, 
        // por lo que ordenamos el subarreglo de tamaño n-1.
        recursivo(arr, n - 1);
    }
}