public class ThreeLab {
    public static void main(String[] args) {
        System.out.println("Введите число n");
        int n = FourLab.readLine();
        double sum = sumFunction(n);
        System.out.println(String.format("Сумма первых n членов ряда с использованием функции равна: %s", sum));
    }

    private static double sumFunction(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += 3 / (Math.pow(i, 2) + 2 * i);
        }
        return sum;
    }
}