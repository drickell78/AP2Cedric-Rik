
public class Identifier implements IdentifierInterface {
 
	String name;
	
	public Identifier (String name) {	  
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode();
	}
	
	@Override
	public boolean equals(String name) {
		return this.equals(name);   
	}
}
