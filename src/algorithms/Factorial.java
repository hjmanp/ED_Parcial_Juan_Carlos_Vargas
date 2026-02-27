package algorithms;

public class Factorial {
    // Versión Iterativa O(n)
    public long factorialIterativo(int n) {
        long resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Versión Recursiva O(n)
    public long factorialRecursivo(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorialRecursivo(n - 1);
    }
}