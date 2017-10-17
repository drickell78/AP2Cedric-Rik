
public class Set<E extends Comparable<E>> implements SetInterface <E> {

	List<E> setList;

	Set() {
		setList = new List<E>();
		setList.init();
	}

	@Override
	public E get() {
		return (E) setList.retrieve();
	}

	@Override
	public boolean contains(E d) {
		return setList.find(d);
	}

	@Override
	public int size() {
		return setList.size();
	}
	
	@Override
	public void add(E d) {
		setList.insert(d);
	}

	@Override
	public void remove(E d) {
		//setList.find(d);
		//setList.remove();
	}
	
	@Override
	public boolean isEmpty() {
		return setList.isEmpty();
	}
	
	@Override
	public Set<E> copy() {
		Set<E> copy = new Set<E>();
		copy.setList = setList.copy();
		return copy;
	}

	@Override
	public Set<E> union(Set<E> setOne, Set<E> setTwo) {
		Set<E> result = new Set<E>();

		result = setOne.copy();
		setTwo.setList.goToFirst();

		for (int i = 0; i < setTwo.size(); i ++) {
			result.add(setTwo.get());
			setTwo.setList.goToNext();
		}
		return result;
	}

	@Override
	public Set<E> intersection(Set<E> setOne, Set<E> setTwo) {
		Set<E> result = new Set<E>();
		setOne.setList.goToFirst();
		setOne.setList.goToFirst();

		for (int i = 0; i < setOne.size(); i++) {
			if (setTwo.contains(setOne.get())) {
				result.add(setOne.get());
			}
			setOne.setList.goToNext();
		}
		return result;
	}

	@Override
	public Set<E> complement(Set<E> setOne, Set<E> setTwo) {
		Set<E> result = new Set<E>();
		setOne.setList.goToFirst();
		setTwo.setList.goToFirst();

		for(int i = 0; i < setOne.size(); i++) {
			if (!setTwo.contains(setOne.get())) {
				result.add(setOne.get());
			}
			setOne.setList.goToNext();
		}
		return result;
	}

	@Override
	public Set<E> difference(Set<E> setOne, Set<E> setTwo) {
		Set<E> result = new Set<E>();
		setOne.setList.goToFirst();
		setTwo.setList.goToFirst();

		result = setOne.copy();
		for (int i = 0; i < setTwo.size(); i++){
			result.add(setTwo.get());
			setTwo.setList.goToNext();
		}
		setTwo.setList.goToFirst();
		for (int i = 0; i < setOne.size(); i++){
			if (setTwo.contains(setOne.get())){
				result.remove(setOne.get());
			}
			setOne.setList.goToNext();
		}
		return null;
	}
}
