
public class Set<E extends Comparable> implements SetInterface <E> {

	List<E> setList;
	
	Set() {
		setList.init();
	}
	
	@Override
	public E get() {
		return setList.retrieve();
	}
	
	@Override
	public void add(E d) {
		setList.insert(d);
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
		copy.setList.copy();
		return copy;
	}
	
	@Override
	public Set union(Set setOne, Set setTwo) {
		Set result = new Set();
		
		result.setList = setOne.setList.copy();
		setTwo.setList.goToFirst();
		
		for (int i = 0; i < setTwo.setList.numberOfElements; i ++) {
			result.add(setTwo.setList.retrieve());
			setTwo.setList.goToNext();
		}  
		return result;
	}
	
	Set isLonger (Set setOne, Set setTwo) {
		if (setOne.size() > setTwo.size()) {
			return setOne;
		} else {
			return setTwo;
		}
	}
	
	Set isShorter (Set setOne, Set setTwo) {
		if (setOne.size() < setTwo.size()) {
			return setOne;
		} else {
			return setTwo;
		}
	}
	
	@Override
	public Set intersection(Set setOne, Set setTwo) {
		Set result = new Set();
		Set longer = isLonger(setOne,setTwo);
		Set shorter = isShorter(setOne,setTwo);
		shorter.setList.goToFirst();
		longer.setList.goToFirst();
		
		for (int i = 0; i < longer.size(); i++) {
			if (shorter.setList.find(longer.setList.retrieve())) {
				result.add(longer.setList.retrieve());
			}
			longer.setList.goToNext();
		}
		return result;
	}
	
	@Override
	public Set complement(Set setOne, Set setTwo) {
		Set result = new Set();
		Set longer = isLonger(setOne,setTwo);
		Set shorter = isShorter(setOne,setTwo);
		shorter.setList.goToFirst();
		longer.setList.goToFirst();
		
		for(int i = 0; i < longer.size(); i++) {
			if (!shorter.setList.find(longer.setList.retrieve())) {
				result.add(longer.setList.retrieve());
			}
			longer.setList.goToNext();
		}
		return result;
	}
	
	@Override
	public Set difference(Set setOne, Set setTwo) {
		return null;
	}
	
}
