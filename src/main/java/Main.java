import boxes.GiftBox;
import sweets.AbstractSweets;
import sweets.Candy;
import sweets.Chocolate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        createGiftBox();
    }

    private static GiftBox createGiftBox() {
        GiftBox giftBox = new GiftBox();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int choose;
            System.out.println("Общая информация о подарке - введите - 1.");
            System.out.println("Детальная информация о содержимом подарка введите - 2.");
            System.out.println("Для редактирования подарка - введите - 3.");
            System.out.println("Для завершения программы - введите - 4.");

            try {
                choose = Integer.parseInt(bufferedReader.readLine());
                if (choose == 1) {
                    giftBox.printInfoAboutBox();
                } else if (choose == 2) {
                    giftBox.printInfoAboutEntities();
                } else if (choose == 3) {
                    editGiftBox(giftBox);
                } else if (choose == 4) {
                    System.out.println("Программа закрывается.");
                    break;
                } else {
                    System.out.println("Вы ввели неверное значение. Попробуйте снова.\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверное значение. Попробуйте снова.\n");
            }
        }
        return giftBox;
    }

    private static void editGiftBox(GiftBox giftBox) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int choose;
            try {
                System.out.println("Для добавления сладости введите - 0");
                System.out.println("Для удаление последней сладости в коробке введите - 1.");
                System.out.println("Для удаления по индексу сладости введите - 2.");
                System.out.println("Для умного удаление по весу введите - 3.");
                System.out.println("Для умного удаление по стоимости введите - 4.");

                choose = Integer.parseInt(bufferedReader.readLine());
                if (choose == 0) {
                    addSweets(giftBox);
                    break;
                } else if (choose == 1) {
                    if (checkGiftBox(giftBox)) {
                        giftBox.deleteLast();
                        break;
                    }
                } else if (choose == 2) {
                    if (checkGiftBox(giftBox)) {
                        System.out.println("Ведите индекс для удаления.");
                        choose = Integer.parseInt(bufferedReader.readLine());
                        giftBox.deleteByIndex(choose);
                        break;
                    }
                } else if (choose == 3) {
                    if (checkGiftBox(giftBox)) {
                        System.out.println("Введите предельный вес подарка.");
                        double max = Double.parseDouble(bufferedReader.readLine());
                        giftBox.reduceWeight(max);
                        break;
                    }
                } else if (choose == 4) {
                    if (checkGiftBox(giftBox)) {
                        System.out.println("Введите предельную стоимость подарка.");
                        double max = Double.parseDouble(bufferedReader.readLine());
                        giftBox.reduceCoast(max);
                        break;
                    }
                } else {
                    System.out.println("Вы ввели неверное значение. Попробуйте снова.\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверное значение. Попробуйте снова.\n");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Вы ввели неверное значение. Попробуйте снова.\n");
            }
        }
    }

    private static boolean checkGiftBox(GiftBox giftBox) {
        if (giftBox.getSweetsList().size() == 0) {
            System.out.println("Удаление невозможно. Подарок пуст.\n");
            return false;
        }
        return true;
    }

    private static void addSweets(GiftBox giftBox) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int choose;
            System.out.println("Выберете сладость которую вы хотите добавить.");
            System.out.println("для конфеты введите - 1.");
            System.out.println("для шоколада введите - 2.");
            try {
                choose = Integer.parseInt(bufferedReader.readLine());
                if (choose == 1) {
                    System.out.println("Вы добалвяете конфету.");
                    giftBox.add(getSweetsInstance(1));
                    System.out.println("Конфета добалвена.\n");
                    break;
                } else if (choose == 2) {
                    System.out.println("Вы добалвяете шоколад.");
                    giftBox.add(getSweetsInstance(2));
                    System.out.println("Шоколад добавлен.\n");

                    break;
                } else {
                    System.out.println("Вы ввели неверное значение. Попробуйте снова.\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели неверное значение. Попробуйте снова.\n");
            }
        }
    }

    private static AbstractSweets getSweetsInstance(int param) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите название.");
        String name = bufferedReader.readLine();
        System.out.println("Введите вес.");
        double weight = Double.parseDouble(bufferedReader.readLine());
        System.out.println("Введите стоимость.");
        double coast = Double.parseDouble(bufferedReader.readLine());
        if (param == 1) {
            System.out.println("Конфета с начинкой? Да - 1/Нет - 2.");
            int filling = Integer.parseInt(bufferedReader.readLine());
            if (filling == 1) {
                return new Candy(weight, coast, name, true);
            } else if (filling == 2) {
                return new Candy(weight, coast, name, false);
            } else throw new NumberFormatException();
        } else {
            System.out.println("Выберете тип шоколада. Белый - 1/Темный - 2.");
            int type = Integer.parseInt(bufferedReader.readLine());
            if (type == 1) {
                return new Chocolate(weight, coast, name, Chocolate.ChocolateType.БЕЛЫЫЙ);
            } else if (type == 2) {
                return new Chocolate(weight, coast, name, Chocolate.ChocolateType.ТЕМНЫЙ);
            } else throw new NumberFormatException();
        }
    }
}
