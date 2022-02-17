public class SixLab {
    public static void main(String[] args) {
        int[] massive = FiveLab.initMassive();
        //Вывести массив
        FiveLab.printArray(massive);
        //Найти минимальное значение в массиве
        FiveLab.Result min = FiveLab.findMin(massive);
        System.out.println(String.format("Минимальное значение в массиве: %s, номер элемента: %s",
                min.getValueArray(), min.getNumberArray()));
        //Найти максимальное значение в массиве
        FiveLab.Result max = FiveLab.findMax(massive);
        System.out.println(String.format("Максимальное значение в массиве: %s, номер элемента: %s",
                max.getValueArray(), max.getNumberArray()));
        massive = moveOneElementLeft(massive);
        FiveLab.printArray(massive);
    }

    private static int[] moveOneElementLeft(int[] massive) {
        int lastIndex = massive.length - 1;
        // Сохранить первый элемент
        int firstValue = massive[0];
        // Сдвинуть массив влево
        for (int i = 0; i < lastIndex; i++) {
            massive[i] = massive[i + 1];
        }
        massive[lastIndex] = firstValue;
        return massive;
    }
}
