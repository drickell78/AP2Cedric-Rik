
interface SetInterface<E extends Comparable<E>> {

	/**	@precondition - 
	 *  @postcondition - Returns the current element of the set.
	 **/
	public E get();
	
	/**	@precondition -
	 *  @postcondition - Returns true if the set contains the element d, and false otherwise.
	 **/
	public boolean contains(E d);
	
	/**	@precondition -
	 *  @postcondition - Returns the number of elements in the set.
	 **/	
	public int size();

	/**	@precondition -
	 *  @postcondition - Adds the requested element into the set.
	 **/
	public void add(E d);

	/**	@precondition - 
	 *  @postcondition - Removes the requested element from the set.
	 **/
	public void remove(E d);
	
	/**	@precondition - 
	 *  @postcondition - Returns true if the set is empty, and false otherwise.
	 **/
	public boolean isEmpty();
	
	/**	@precondition - 
	 *  @postcondition - Returns a deep copy of the set.
	 **/
	public SetInterface<E> copy();
	
	/**	@precondition - 
	 *  @postcondition - Points to the first element of the set.
	 **/
	public void firstElement();
	
	/**	@precondition - 
	 *  @postcondition - Points to the next element of the set.
	 **/
	public void next();

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements of both sets.
	 **/
	public SetInterface<E> union(SetInterface<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all the of the intersecting elements of both sets. Returns
	 *  				 an empty set if there are no intersecting elements.
	 **/
	public SetInterface<E> intersection (SetInterface<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements NOT contained in the first set.
	 **/
	public SetInterface<E> complement (SetInterface<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements of both sets except for the
	 *  				 intersecting elements of both sets.
	 **/
	public SetInterface<E> difference (SetInterface<E> setTwo);
}
