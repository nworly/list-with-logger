import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");

            printMsgForUser("Введите размер списка: ");
            int size = Integer.parseInt(reader.readLine());

            printMsgForUser("Введите верхнюю границу для значений: ");
            int max = Integer.parseInt(reader.readLine());

            List<Integer> list = new ArrayList<>(size);

            for (int i = 0; i < size; i++) {
                Random random = new Random();
                list.add(random.nextInt(max + 1));
            }

            logger.log("Создаём и наполняем список");

            printMsgForUser("Вот случайный список: ");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d ", list.get(i));
            }
            System.out.println();

            logger.log("Просим пользователя ввести входные данные для фильтрации");

            printMsgForUser("Введите порог для фильтра: ");
            int f = Integer.parseInt(reader.readLine());

            Filter filter = new Filter(f);
            List<Integer> filteredList = filter.filterOut(list);

            int count = 0;

            for (int i = 0; i < size; i++) {
                int current = list.get(i);
                if (current < f) {
                    logger.log(String.format("Элемент \"%d\" проходит", current));
                    count++;
                } else {
                    logger.log(String.format("Элемент \"%d\" не проходит", current));
                }
            }

            logger.log(String.format("Прошло фильтр %d элемента из %d", count, size));
            logger.log("Выводим результат на экран");

            printMsgForUser("Отфильтрованный список: ");

            for (int i : filteredList) {
                System.out.printf("%d ", i);
            }
            System.out.println();

            logger.log("Завершаем программу");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printMsgForUser(String msg) {
        System.out.print(msg);
    }
}
