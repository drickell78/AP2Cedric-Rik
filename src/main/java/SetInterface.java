import java.math.BigInteger;

interface SetInterface<E extends Comparable> {
	
	public E get();
	
	public void add(E d);
	
	public void contains(E d);
	
	public int size();
	
	public void remove(E d);
	
	public boolean isEmpty();
	
	public Set copy();
	
	public Set union(Set setOne, Set setTwo);
	
	public Set intersection (Set setOne, Set setTwo);
	
	public Set complement (Set setOne, Set setTwo);
	
	public Set difference (Set setOne, Set setTwo);	
}
