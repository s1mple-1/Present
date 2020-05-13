package boxes;

import sweets.AbstractSweets;


public interface Box {

    void add(AbstractSweets sweets);

    void deleteByIndex(int index);

    void deleteLast();

    void printInfoAboutBox();

    void printInfoAboutEntities();
}
