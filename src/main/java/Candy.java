public class Candy extends Sweets{
    private boolean filling; //начинка
    public Candy(int weight, int coast, String name, boolean filling) {
        super(weight, coast, name);
        this.filling = filling;
    }
}
