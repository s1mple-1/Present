import java.util.ArrayList;

public class GiftBox implements Box {

    @Override
    public void add(Sweets sweets) {
        list.add(sweets);
    }

    @Override
    public void deleteByIndex(int index) {
        list.remove(index);
    }

    @Override
    public void deleteLast() {
        list.remove(list.size()-1);
    }

    @Override
    public void printInfoAboutBox() {

    }

    @Override
    public void printInfoAboutEntities() {

    }
}
