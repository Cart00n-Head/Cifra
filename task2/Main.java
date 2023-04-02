import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // читаем элементы массива из файла
        List<Integer> numsList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(args[0]))) {
            while (scanner.hasNextInt()) {
                numsList.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            return;
        }

        // находим минимальный и максимальный элементы массива
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : numsList) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // находим количество ходов для приведения всех элементов к одному числу
        int moves = Integer.MAX_VALUE; // количество ходов, начальное значение - максимальное число для int
        for (int target = min; target <= max; target++) { // перебираем все возможные значения одного числа в массиве
            int curMoves = 0; // количество ходов для текущего значения

            // вычисляем количество ходов для текущего значения
            for (int num : numsList) {
                curMoves += Math.abs(target - num);
            }

            // обновляем минимальное количество ходов
            moves = Math.min(moves, curMoves);
        }

        // выводим результат
        System.out.println(moves);
    }
}