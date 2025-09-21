package project;

public class FibonachiNumber {
        private int index;
        private long value;

        public FibonachiNumber(int index, long value) {
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

