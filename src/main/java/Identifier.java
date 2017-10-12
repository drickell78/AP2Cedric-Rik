class Identifier{

  String name;

  Identifier(){



  }

  void nameSet(String name){

    this.name = name;

  }
  
  @Override
  public int hashCode() {
	  return name.hashCode();
  }

}
