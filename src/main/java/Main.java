import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вам необходимо добавить сладости в подарок");
        int chose = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("Выберете сладость которую вы хотите добавить:");
            System.out.println("для конфеты введите - 1");
            System.out.println("для шоколадки введите - 2");
            System.out.println("для завершение - 3");
            try {
                chose = Integer.parseInt(bufferedReader.readLine());
                if (chose == 1) {
                    System.out.println("Вы добалвяете конфету.");
                    getInstance(1);
                } else if (chose == 2) {
                    System.out.println("Вы добалвяете шоколадку.");
                    getInstance(2);
                } else if (chose == 3) {
                    break;
                } else {
                    System.out.println("Вы ввели неверное значение. Попробуйте снова");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверное значение. Попробуйте снова");
            }
        }
        System.out.println("Подарок готов. Вы можете получить обшую информацию о коробке - введите 1. Или детальную информацию о ее содержимом - введите 2");
    }

    private static Sweets getInstance(int param) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название");
        String name = bufferedReader.readLine();
        System.out.println("Введите вес в граммах.(Целое число)");
        int weight = Integer.parseInt(bufferedReader.readLine());
        System.out.println("Введите стоимость в рублях.(Целое число)");
        int coast = Integer.parseInt(bufferedReader.readLine());
        if (param == 1) {
            System.out.println("Конфета с начинкой? Да - 1/Нет - 2");
            int filling = Integer.parseInt(bufferedReader.readLine());
            if (filling == 1) {
                return new Candy(weight, coast, name, true);
            } else if (filling == 2) {
                return new Candy(weight, coast, name, false);
            } else throw new NumberFormatException();
        } else {
            System.out.println("Выберете тип шоколада. Белый - 1/Темный - 2");
            int type = Integer.parseInt(bufferedReader.readLine());
            if (type == 1) {
                return new Chocolate(weight, coast, name, Chocolate.Type.БЕЛЫЫЙ);
            } else if (type == 2) {
                return new Chocolate(weight, coast, name, Chocolate.Type.ТЕМНЫЙ);
            } else throw new NumberFormatException();
        }
    }
}
