
public class Set<E extends Comparable<E>> implements SetInterface <E> {

	List<E> setList;

	Set() {
		setList = new List<E>();
		setList.init();
	}

	@Override
	public E get() {
		return setList.retrieve();
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
		if (!this.contains(d)) {
			setList.insert(d);
		}
	}

	@Override
	public void remove(E d) {
		setList.find(d);
		setList.remove();
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
	public void firstElement() {
		setList.goToFirst();
	}
	
	@Override
	public void next() {
		setList.goToNext();
	}

	@Override
	public Set<E> union(SetInterface<E> setTwo) {
		Set<E> result = this.copy();
		setTwo.firstElement();

		for (int i = 0; i < setTwo.size(); i ++) {
			result.add(setTwo.get());
			setTwo.next();
		}
		return result;
	}

	@Override
	public Set<E> intersection(SetInterface<E> setTwo) {
		Set<E> result = new Set<E>();
		setTwo.firstElement();

		for (int i = 0; i < setTwo.size(); i++) {
			if (this.contains(setTwo.get())) {
				result.add(setTwo.get());
			}
			setTwo.next();
		}
		return result;
	}

	@Override
	public Set<E> complement(SetInterface<E> setTwo) {
		Set<E> result = new Set<E>();
		this.firstElement();

		for(int i = 0; i < this.size(); i++) {
			if (!setTwo.contains(this.get())) {
				result.add(this.get());
			}
			this.next();
		}
		return result;
	}

	@Override
	public Set<E> difference(SetInterface<E> setTwo) {
		Set<E> result = this.copy();
		setTwo.firstElement();

		for (int i = 0; i < setTwo.size(); i++){
			result.add(setTwo.get());
			setTwo.next();
		}
		this.setList.goToFirst();
		for (int i = 0; i < this.size(); i++){
			if (setTwo.contains(this.get())){
				result.remove(this.get());
			}
			this.next();
		}
		return result;
	}
}
