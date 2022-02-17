import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class TwoLab {

    public static void main(String[] args) {
        System.out.println("Значение аргумента | Результат функции");
        Map<Double, Double> numbers = new HashMap<>(); //Инициализируем массив для всех значений функции
        for (double i = OneLab.A; i <= OneLab.B; i = i + OneLab.H) {
            double result = OneLab.runFunction(i); //Уравнение
            System.out.println(String.format("%1$,.1f | %2$,.4f", i, result));
            numbers.put(i, result);
        }
        arithmeticAverage(numbers.values());
        double xMin = -7;
        double xMax = 4;
        double yMin = -8;
        double yMax = 6;
        int count = 0;
        for (Map.Entry<Double, Double> entry : numbers.entrySet()) {
            double x = entry.getKey();
            double y = entry.getValue();
            if (x > xMin && x < xMax && y > yMin && y < yMax) {
                count++;
           // Для отладки     System.out.println(x + " " + y);
            }
        }
        System.out.println(String.format("Количество точек внутри прямоугольника: %s", count));
    }

    private static void arithmeticAverage(Collection<Double> numbers) {
        int size = numbers.size();
        if (size > 0) {
            double sum = numbers
                    .stream() //Аналог цикла for, рекурсивный обход всех элементов
                    .mapToDouble(Double::doubleValue) //Мапинг значения из класса Double в примитивный тип double для того, чтобы работала функция sum
                    .sum(); //Считает сумму всех элементов
            System.out.println(String.format("Среднее арифметическое всех значений функций = %1$,.4f", sum / size));
        } else {
            System.out.println("Отсутствуют значения функции");
        }
    }
}

