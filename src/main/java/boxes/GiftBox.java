package boxes;

import sweets.AbstractSweets;

import java.util.ArrayList;


public class GiftBox implements Box {
    private double weight = 0d;
    private double coast = 0d;

    private ArrayList<AbstractSweets> sweetsList = new ArrayList<AbstractSweets>();

    public void add(AbstractSweets sweets) {
        sweetsList.add(sweets);
        calculateWeightAndCoast();
    }


    public void deleteByIndex(int index) {
        sweetsList.remove(index);
        calculateWeightAndCoast();
    }


    public void deleteLast() {
        sweetsList.remove(sweetsList.size() - 1);
        calculateWeightAndCoast();
    }


    private void calculateWeightAndCoast() {
        double weight = 0d;
        double coast = 0d;
        for (AbstractSweets sweets : sweetsList) {
            weight += sweets.getWeight();
            coast += sweets.getCoast();
        }
        this.weight = weight;
        this.coast = coast;
    }

    public void printInfoAboutBox() {
        calculateWeightAndCoast();
        if (sweetsList.size() == 0) {
            System.out.println("Подарок пуст!" + "\n");
        } else {
            System.out.println("Стоимость подарка составляет: " + coast + ". Вес подарка составялет: " + weight + ".\n");

        }
    }

    public void printInfoAboutEntities() {
        if (sweetsList.size() == 0) {
            System.out.println("Подарок пуст!" + "\n");
        } else {
            for (AbstractSweets sweets : sweetsList) {
                System.out.println(sweets.toString());
            }
            System.out.println("");
        }
    }

    public void reduceWeight(double weight) {
        if (weight < this.weight) {
            while (this.weight > weight) {
                double min = Double.MAX_VALUE;
                int index = -1;
                for (int i = 0; i < sweetsList.size(); i++) {
                    if (sweetsList.get(i).getWeight() < min) {
                        min = sweetsList.get(i).getWeight();
                        index = i;
                    }
                }
                if (index >= 0) {
                    sweetsList.remove(index);
                }
                calculateWeightAndCoast();
            }
        }
    }

    public void reduceCoast(double coast) {
        if (coast < this.coast) {
            while (this.coast > coast) {
                double min = Double.MAX_VALUE;
                int index = -1;
                for (int i = 0; i < sweetsList.size(); i++) {
                    if (sweetsList.get(i).getCoast() < min) {
                        min = sweetsList.get(i).getCoast();
                        index = i;
                    }
                }
                if (index >= 0) {
                    sweetsList.remove(index);
                }
                calculateWeightAndCoast();
            }
        }
    }

    public ArrayList<AbstractSweets> getSweetsList() {
        return sweetsList;
    }
}
