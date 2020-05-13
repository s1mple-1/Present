package sweets;

public class Candy extends AbstractSweets {
    private boolean filling; //начинка

    public Candy(double weight, double coast, String name, boolean filling) {
        super(weight, coast, name);
        this.filling = filling;
    }

    public boolean isFilling() {
        return filling;
    }

    @Override
    public String toString() {
        String fil;
        if (filling) {
            fil = "c начинкой";
        } else fil = "без начинки";

        return "Конфета " +
                super.getName() +
                ", вес " +
                super.getWeight() +
                ", стоимость " +
                super.getCoast() +
                ", " +
                fil;

    }
}
