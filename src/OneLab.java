import java.util.ArrayList;
import java.util.List;

public class OneLab {
    static final int A = -5; //В одном пакете можно использовать в других классах
    static final int B = 5;
    static final double H = 0.1;

    public static void main(String[] args) {
        System.out.println("Значение аргумента | Результат функции");
        List<Double> positiveNumbers = new ArrayList<>(); //Инициализируем массив для неотрицательных значений функции
        for (double i = A; i <= B; i = i + H) {
            double result = runFunction(i);
            System.out.println(String.format("%1$,.1f | %2$,.4f", i, result));
            if (result >= 0) {
                positiveNumbers.add(result);
            }
        }
        printArithmeticAverage(positiveNumbers);
    }

    static double runFunction(double x) {
        return x * Math.exp(x) + 2 * Math.sin(x) - Math.sqrt(Math.abs(Math.pow(x, 3) - Math.pow(x, 2)));
    }

    private static void printArithmeticAverage(List<Double> positiveNumbers) {
        int size = positiveNumbers.size();
        if (size > 0) {
            double sum = positiveNumbers
                    .stream() //Аналог цикла for, рекурсивный обход всех элементов
                    .mapToDouble(Double::doubleValue) //Мапинг значения из класса Double в примитивный тип double для того, чтобы работала функция sum
                    .sum(); //Считает сумму всех элементов
            System.out.println(String.format("Среднее арифметическое всех неотрицательных значений функций = %1$,.4f", sum / size));
        } else {
            System.out.println("Отсутствуют положительные значения функции");
        }
    }
}