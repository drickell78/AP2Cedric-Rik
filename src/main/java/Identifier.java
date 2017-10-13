class Identifier{

  String name;

  Identifier(){

  }

  Identifier init(){
    return new Identifier();
  }

  void nameSet(String name){

    this.name = name;

  }
  
  @Override
  public int hashCode() {
	  return name.hashCode();
  }

  public void equals(String name){
    this.equals(name);
    
  }
}
