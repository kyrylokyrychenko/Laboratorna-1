package project;
import java.util.Scanner;

class FibonacciNumber {
    private int index;
    private long value;

    public FibonacciNumber(int index, long value) {
        this.index = index;
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public boolean isSquarePlusOne() {
        if (value - 1 <= 0) return false;

        for (long k = 1; k * k <= value - 1; k++) {
            if (k * k == value - 1) {
                return true;
            }
        }
        return false;
    }

    public String info() {
        return "Число №" + index + " = " + value;
    }
}

public class Main {
    public static long fibonacci(int n) {
        if (n == 1 || n == 2) return 1;
        long a = 1, b = 1;
        long c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N;

        if (args.length > 0) {
            N = Integer.parseInt(args[0]);
            System.out.println("Введено через командний рядок: N = " + N);
        } else {
            System.out.print("Введіть кількість чисел Фібоначчі N (Не більше 80): ");
            N = scan.nextInt();
        }

        FibonacciNumber[] numbers = new FibonacciNumber[N];

        System.out.println("\nПерші " + N + " чисел Фібоначчі:");
        for (int i = 1; i <= N; i++) {
            long value = fibonacci(i);
            numbers[i - 1] = new FibonacciNumber(i, value);
            System.out.println(numbers[i - 1].info());
        }

        System.out.println("\nЧисла Фібоначчі, які можна подати як k^2 + 1:");
        boolean found = false;
        for (FibonacciNumber num : numbers) {
            if (num.isSquarePlusOne()) {
                System.out.println(num.info() + " = " + ((long)Math.pow(num.getValue()-1, 0.5)) + "^2 + 1");
                found = true;
            }
        }

        if (!found) {
            System.out.println("Серед перших " + N + " чисел таких немає.");
        }
    }
}
