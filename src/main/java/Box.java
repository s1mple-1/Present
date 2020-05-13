import java.lang.reflect.Type;
import java.util.ArrayList;

public interface Box {
    ArrayList<Sweets> list = new ArrayList<>();
    void add(Sweets sweets);
    void deleteByIndex(int index);
    void deleteLast();
    void printInfoAboutBox();
    void printInfoAboutEntities();
}
