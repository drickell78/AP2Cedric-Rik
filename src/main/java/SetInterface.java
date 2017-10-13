import java.math.BigInteger;

interface SetInterface<E extends Comparable> {

  Set init();

  E get(int index);

  void add(int index);

  void remove(int index);

  void set(int index, E data);

  int size();


}
