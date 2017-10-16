
public class Set<E extends Comparable> implements SetInterface <E> {

	List setList;

	Set() {
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
	public void remove() {
		setList.remove();
	}
	
	@Override
	public boolean isEmpty() {
		return setList.isEmpty();
	}
	
	@Override
	public Set copy() {
		Set copy = new Set();
		copy.setList = setList.copy();
		return copy;
	}

	@Override
	public Set union(Set setOne, Set setTwo) {
		Set result = new Set();

		result = setOne.copy();
		setTwo.setList.goToFirst();

		for (int i = 0; i < setTwo.size(); i ++) {
			result.add(setTwo.get());
			setTwo.setList.goToNext();
		}
		return result;
	}

	@Override
	public Set intersection(Set setOne, Set setTwo) {
		Set result = new Set();
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
	public Set complement(Set setOne, Set setTwo) {
		Set result = new Set();
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
	public Set difference(Set setOne, Set setTwo) {
		Set result = new Set();
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
				result.remove();
			}
			setOne.setList.goToNext();
		}
		return null;
	}
}
