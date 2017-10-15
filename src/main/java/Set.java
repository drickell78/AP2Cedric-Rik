
public class Set<E extends Comparable> implements SetInterface {

	List setList;
	
	Set(){}
	
	public Set init() {
		setList = new List();
		return this;
	}
	
	@Override
	public Comparable get(Comparable d) {
		return setList.find(d);
	}
	
	@Override
	public void add(Comparable d) {
		setList.insert(d);
	}
	
	@Override
	public void remove(Comparable d) {
		setList.find(d);
		setList.remove();
	}
	
	@Override
	public Set union(Set setOne, Set setTwo) {
		Set result = init();
		
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
		Set result = init();
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
		Set result = init();
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
	
	public int size() {
		return setList.size();
	}
}
