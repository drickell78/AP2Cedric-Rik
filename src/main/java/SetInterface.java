import java.math.BigInteger;

interface SetInterface<E extends Comparable> {

  Set init();

  E get(int index);

  void add(int index);

  void remove(int index);

  Set union(Set setOne, Set setTwo);

  Set intersection (Set setOne, Set setTwo);

  Set complement (Set setOne, Set setTwo);

  Set difference (Set setOne, Set setTwo);

  int size();


}
