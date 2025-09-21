package project;
import java.util.Scanner;

/*
 Головний клас програми для роботи з числами Фібоначчі.

 У програмі можна:
 <ul>
   <li>Обчислити перші N чисел Фібоначчі.</li>
   <li>Вивести їх на екран.</li>
   <li>Знайти числа, які можна подати у вигляді k² + 1.</li>
 </ul>
 */
public class Main {

    /*
     Обчислює n-те число Фібоначчі.

     @param n порядковий номер числа (n ≥ 1)
     @return n-те число Фібоначчі
     */
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

    /*
     Точка входу в програму.

     <p>Можливості:</p>
     <ul>
       <li>Приймає число N через аргументи командного рядка.</li>
       <li>Якщо аргумент не задано – запитує N через {@link Scanner}.</li>
       <li>Обчислює перші N чисел Фібоначчі та виводить їх.</li>
       <li>Перевіряє, які з них можна подати як k² + 1.</li>
     </ul>

     @param args аргументи командного рядка; якщо args[0] задано – це число N
     */
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

        FibonachiNumber[] numbers = new FibonachiNumber[N];

        System.out.println("\nПерші " + N + " чисел Фібоначчі:");
        for (int i = 1; i <= N; i++) {
            long value = fibonacci(i);
            numbers[i - 1] = new FibonachiNumber(i, value);
            System.out.println(numbers[i - 1].info());
        }

        System.out.println("\nЧисла Фібоначчі, які можна подати як k^2 + 1:");
        boolean found = false;
        for (FibonachiNumber num : numbers) {
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
