
public class Identifier implements IdentifierInterface {
 
	StringBuffer name;
	
	public Identifier (char c) {
		this.name = null;
		this.name.append(c);
	}

	void addChar(char c){
		name.append(c);
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object that) {
		return this.equals(that);
	}
}
