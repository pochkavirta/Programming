import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FourLab {
    //Найти количество четных чисел последовательности, сумма цифр в которых не превышает заданного числа P.
    public static void main(String[] args) {
        System.out.println("Введите число P");
        int P = readLine();
        if (P == 0) {
            System.out.println("P не может равняться 0");
            return;
        }
        int i; //Вводимое с клавиатуры число
        int count = 0; //Количество чисел подходящее под условие
        do {
            System.out.println("Введите число, для завершения введите 0");
            i = readLine();
            if (i != 0 && isValidNumber(i, P)) {
                count++;
            }
        }
        while (i != 0);
        System.out.println(String.format("Количество четных чисел последовательности, сумма цифр в " +
                "которых не превышает заданного числа P(%d) = %d", P, count));
    }

    static int readLine() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(reader.readLine());
        } catch (Exception exception) { //Проверка на ввод букв
            System.out.println("Введено неправильное число, введите снова");
            return readLine();
        }
    }

    private static boolean isValidNumber(int i, int P) {
        if (i % 2 != 0) {
            return false;
        }
        return P >= Arrays
                .stream(String.valueOf(i) //Преобразует примитив числа в строку
                        .replace("-", "") //Убирает знак минус
                        .split("")) //Разбивает число на цифры (137 на {1, 3, 7})
                .mapToInt(Integer::parseInt) //Преобразует строку в Integer
                .sum(); //Считает сумму цифр
    }
}
