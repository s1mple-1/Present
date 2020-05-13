package sweets;

public abstract class AbstractSweets {
    private double weight;
    private double coast;
    private String name;


    public AbstractSweets(double weight, double coast, String name) {
        this.weight = weight;
        this.coast = coast;
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public double getCoast() {
        return coast;
    }

    public String getName() {
        return name;
    }
}
