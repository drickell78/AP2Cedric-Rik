
public class Set<E extends Comparable> implements SetInterface {

	List setList;
	E currentElement;
	
	Set(){

		setList = new List();


	}
	
	public Set init() {

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

	@Override
	public Set intersection(Set setOne, Set setTwo) {
		Set result = init();
		setOne.setList.goToFirst();
		setOne.setList.goToFirst();
		
		for (int i = 0; i < setOne.size(); i++) {
			if (setTwo.setList.find(setOne.setList.retrieve())) {
				result.add(setOne.setList.retrieve());
			}
			setOne.setList.goToNext();
		}
		return result;
	}
	
	@Override
	public Set complement(Set setOne, Set setTwo) {
		Set result = init();
		setOne.setList.goToFirst();
		setTwo.setList.goToFirst();
		
		for(int i = 0; i < setOne.size(); i++) {
			if (!setTwo.setList.find(setOne.get(setOne.setList.retrieve())) {
				result.add(setOne.get(setOne.setList.retrieve()));
			}
			setOne.setList.goToNext();
		}
		return result;
	}
	
	@Override
	public Set difference(Set setOne, Set setTwo) {
		Set result = init();
		setOne.setList.goToFirst();
		setTwo.setList.goToFirst();

		for (int i = 0; i < setOne.size(); i++){
			result.add(setOne.get(setOne.setList.retrieve()));
			setOne.setList.goToNext();
		}
		for (int i = 0; i < setTwo.size(); i++){
			result.add(setTwo.setList.retrieve());
			setTwo.setList.goToNext();
		}
		setOne.setList.goToFirst();
		setTwo.setList.goToFirst();
		for (int i = 0; i < setOne.size(); i++){
			if (setTwo.setList.find(setOne.get(setOne.setList.retrieve())){
				result.remove(setOne.get(setOne.setList.retrieve()));
			}
			setOne.setList.goToNext();
		}


		return null;
	}
	
	public int size() {
		return setList.size();
	}
}
