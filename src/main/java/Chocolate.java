public class Chocolate extends Sweets {
    private Type type;
    public Chocolate(int weigth, int coast, String name,Type type) {
        super(weigth, coast, name);
        this.type = type;
    }

    enum Type {
        БЕЛЫЫЙ,
        ТЕМНЫЙ
    }
}
