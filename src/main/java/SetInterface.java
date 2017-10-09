import java.math.BigInteger;

interface SetInterface<E extends Comparable> {

  E get(int index);

  void set(int index, E data);

  int size();

  

}
