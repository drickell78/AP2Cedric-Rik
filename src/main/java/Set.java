class Set<E extends Comparable> implements SetInterface{

  int numberOfElements;

  Set(){
  
  numberOfElements = 0;

  }

  public Set init(){
    return new Set();
  }

  public Comparable get(int index) {
    return null;
  }

  @Override
  public void add(int index) {

  }

  @Override
  public void remove(int index) {

  }

  @Override
  public Set union(Set setOne, Set setTwo) {
    return null;
  }

  @Override
  public Set intersection(Set setOne, Set setTwo) {
    return null;
  }

  @Override
  public Set complement(Set setOne, Set setTwo) {
    return null;
  }

  @Override
  public Set difference(Set setOne, Set setTwo) {
    return null;
  }

  public int size() {
    return 0;
  }
}
