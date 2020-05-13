package sweets;

public class Chocolate extends AbstractSweets {
    private ChocolateType type;

    public Chocolate(double weight, double coast, String name, ChocolateType type) {
        super(weight, coast, name);
        this.type = type;
    }

    public ChocolateType getType() {
        return type;
    }

    public enum ChocolateType {
        БЕЛЫЫЙ,
        ТЕМНЫЙ
    }

    @Override
    public String toString() {
        return "Шоколад " +
                super.getName() +
                " , " +
                getType() +
                ", вес " +
                super.getWeight() +
                ", стоимость " +
                super.getCoast();
    }
}
