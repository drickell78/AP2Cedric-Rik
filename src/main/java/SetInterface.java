
interface SetInterface<E extends Comparable<E>> {

	/**	@precondition - The set is not empty.
	 *  @postcondition - Returns the current element of the set. (Current node of the linked list)
	 *
	 **/

	public E get();
	
	public boolean contains(E d);
	
	/**	@precondition -
	 *  @postcondition - Returns the number of elements in the set.
	 *
	 **/
	
	public int size();

	/**	@precondition -
	 *  @postcondition - Adds the requested element into the correct place in the set, such that the set remains sorted.
	 *
	 **/

	public void add(E d);

	/**	@precondition - The set is not empty.
	 *  @postcondition - Removes the requested element from the set.
	 *
	 **/
	
	public void remove(E d);
	
	public boolean isEmpty();
	
	public SetInterface<E> copy();
	
	public void firstElement();
	
	public void next();

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements of both sets.
	 *
	 **/

	public SetInterface<E> union(SetInterface<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all the of the intersecting elements of both sets. Returns
	 *  				 an empty set if there are no intersecting elements.
	 *
	 **/

	public SetInterface<E> intersection (SetInterface<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements NOT contained in the first set.
	 *
	 **/

	public SetInterface<E> complement (SetInterface<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements of both sets except for the
	 *  				 intersecting elements of both sets.
	 *
	 **/

	public SetInterface<E> difference (SetInterface<E> setTwo);
}
