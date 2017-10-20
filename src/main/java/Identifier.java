
public class Identifier implements IdentifierInterface {
 
	StringBuffer name;
	
	public Identifier (StringBuffer name) {	  
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(Object name) {
		return this.equals(name);
	}
}
