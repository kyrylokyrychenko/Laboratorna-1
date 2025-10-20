package project;

/*
Клас для чисел Фібоначі
*/
public class FibonachiNumber {
        private int index;
        private long value;

        /*
     Створює новий об'єкт числа Фібоначчі.

     @param index номер числа у послідовності
     @param value значення числа
     */
        public FibonachiNumber(int index, long value) {
            this.index = index;
            this.value = value;
        }

        /*
     Повертає значення числа Фібоначчі.

     @return значення числа
     */
        public long getValue() {
            return value;
        }

        /*
     Перевіряє, чи є число на 1 більше від деякого квадрата.

     @return true, якщо число = k² + 1
     */
        public boolean isSquarePlusOne() {
            if (value <= 1) return false;
            long k = (long) Math.pow(value, 0.5);
            return k*k == value-1 ;
        }

        public String info() {
            return "Число №" + index + " = " + value;
        }
    }

