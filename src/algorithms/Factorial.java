package algorithms;

/**
 * ============================================================
 * A1 - FACTORIAL
 * ============================================================
 * Calcula n! (n factorial). Caso base: 0! = 1
 *
 * Complejidad temporal:
 * - Iterativo:  O(n)   — un ciclo lineal
 * - Recursivo:  O(n)   — n llamadas recursivas en el call stack
 *
 * ADVERTENCIA PEDAGÓGICA:
 * El factorial crece de forma extremadamente rápida.
 * A partir de 21!, el resultado excede la capacidad máxima
 * de un tipo 'long' en Java (64 bits con signo).
 * Por eso limitamos n <= 20.
 * ============================================================
 */
public class Factorial {

    // ----------------------------------------------------------------
    // VERSIÓN ITERATIVA
    // ----------------------------------------------------------------
    /**
     * Calcula n! usando un ciclo for.
     *
     * Traza para n = 4:
     * resultado = 1
     * i=1 → resultado = 1 * 1 = 1
     * i=2 → resultado = 1 * 2 = 2
     * i=3 → resultado = 2 * 3 = 6
     * i=4 → resultado = 6 * 4 = 24  ← retorna 24
     *
     * @param n número al que se le calculará el factorial
     * @return el factorial de n
     */
    public static long iterativo(int n) {
        if (n < 0) throw new IllegalArgumentException("n no puede ser negativo");
        if (n > 20) throw new IllegalArgumentException("Limita n <= 20 para evitar desbordamiento de memoria (overflow)");

        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // ----------------------------------------------------------------
    // VERSIÓN RECURSIVA
    // ----------------------------------------------------------------
    /**
     * Calcula n! con recursión directa.
     *
     * Fórmula recursiva:
     * 0! = 1              ← caso base
     * 1! = 1              ← caso base
     * n! = n * (n-1)!     ← llamada recursiva
     *
     * @param n número al que se le calculará el factorial
     * @return el factorial de n
     */
    public static long recursivo(int n) {
        if (n < 0) throw new IllegalArgumentException("n no puede ser negativo");
        if (n > 20) throw new IllegalArgumentException("Limita n <= 20 para evitar desbordamiento de memoria (overflow)");

        // --- CASOS BASE ---
        if (n == 0 || n == 1) return 1;

        // --- LLAMADA RECURSIVA ---
        return n * recursivo(n - 1);
    }
}