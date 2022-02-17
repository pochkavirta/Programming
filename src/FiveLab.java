import java.util.Arrays;
import java.util.List;

public class FiveLab {
    private static final int A = -100;
    private static final int B = 100;

    public static void main(String[] args) {
        int[] massive = initMassive();
        if (massive == null) {
            return;
        }
        //Вывести массив
        printArray(massive);
        //Найти минимальное значение в массиве
        Result min = findMin(massive);
        System.out.println(String.format("Минимальное значение в массиве: %s, номер элемента: %s",
                min.getValueArray(), min.getNumberArray()));
        //Найти максимальное значение в массиве
        Result max = findMax(massive);
        System.out.println(String.format("Максимальное значение в массиве: %s, номер элемента: %s",
                max.getValueArray(), max.getNumberArray()));
        //Найти среднее арифметическое минимального и максимального элемента
        double average = (max.getValueArray() + min.getValueArray()) / 2.0;
        System.out.println(String.format("Среднее арифметическое минимального и максимального элемента: %s", average));
        //Найти номер элемент наиболее близкого к среднему арифметическому
        List<Result> results = findAverage(massive, average);
        System.out.println(String.format("Ближайшее минимальное значение к среднему арифметическому = %s, номер элемента = %s",
                results.get(0).getValueArray(), results.get(0).getNumberArray()));
        System.out.println(String.format("Ближайшее максимальное значение к среднему арифметическому = %s, номер элемента = %s",
                results.get(1).getValueArray(), results.get(1).getNumberArray()));
    }

    static int[] initMassive() {
        System.out.println("Выберите режим работы, для заполнения массива");
        System.out.println("0 - заполнить автоматически, 1 - заполнить вручную, другое число - для выхода из программы");
        int mode = FourLab.readLine();
        int[] massive = null;
        if (mode == 0) {
            massive = generateRandomArray(A, B);
        } else if (mode == 1) {
            massive = readArray();
        }
        return massive;
    }

    private static List<Result> findAverage(int[] massive, double average) {
        int numberArrayMin = 0;
        int numberArrayMax = 0;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < massive.length; i++) {
            if (massive[i] <= average && min < massive[i]) {
                min = massive[i];
                numberArrayMin = i;
            } else if (massive[i] >= average && max > massive[i]) {
                max = massive[i];
                numberArrayMax = i;
            }
        }
        return Arrays.asList(new Result(min, numberArrayMin), new Result(max, numberArrayMax));
    }


    static Result findMin(int[] massive) {
        int min = massive[0];
        int numberMin = 0;
        for (int i = 1; i < massive.length; i++) {
            if (min > massive[i]) {
                min = massive[i];
                numberMin = i;
            }
        }
        return new Result(min, numberMin);
    }

    static Result findMax(int[] massive) {
        int max = massive[0];
        int numberMax = 0;
        for (int i = 1; i < massive.length; i++) {
            if (max < massive[i]) {
                max = massive[i];
                numberMax = i;
            }
        }
        return new Result(max, numberMax);
    }

    static void printArray(int[] massive) {
        for (int i = 0; i < massive.length; i++) {
            System.out.println(massive[i]);
        }
    }

    private static int[] readArray() {
        System.out.println("Введите длину массива");
        int lengthMassive = FourLab.readLine();
        int[] arrayRnd = new int[lengthMassive];
        System.out.println("Введите числа массива");
        for (int i = 0; i < lengthMassive; i++) {
            arrayRnd[i] = FourLab.readLine();
        }
        return arrayRnd;
    }

    private static int[] generateRandomArray(int A, int B) {
        System.out.println("Введите длину массива");
        int lengthMassive = FourLab.readLine();
        int[] arrayRnd = new int[lengthMassive];
        for (int i = 0; i < lengthMassive; i++) {
            arrayRnd[i] = (int) ((Math.random() * (B * 2 + 2)) + (A - 1));
        }
        return arrayRnd;
    }

    public static class Result {
        private int valueArray;
        private int numberArray;

        public int getValueArray() {
            return valueArray;
        }

        public int getNumberArray() {
            return numberArray;
        }

        public Result(int valueArray, int numberArray) {
            this.valueArray = valueArray;
            this.numberArray = numberArray;
        }
    }
}
