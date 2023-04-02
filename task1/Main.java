import java.util.*;

public class CircularArray {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);

        List<Integer> array = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            array.add(i);
        }

        List<Integer> path = new ArrayList<>();
        int index = 0;
        while (!array.isEmpty()) {
            index = (index + m - 1) % array.size(); // получаем индекс элемента, который будет в начале следующего интервала
            path.add(array.get(index));
            array.remove(index); // удаляем его из списка
        }

        System.out.println(path.stream().mapToInt(Integer::intValue).toArray()); // выводим путь
    }
}
