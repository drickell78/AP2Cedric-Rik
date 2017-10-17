
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
	
	int size();

	/**	@precondition -
	 *  @postcondition - Adds the requested element into the correct place in the set, such that the set remains sorted.
	 *
	 **/

	void add(E d);

	/**	@precondition - The set is not empty.
	 *  @postcondition - Removes the requested element from the set.
	 *
	 **/
	
	void remove();
	
	boolean isEmpty();
	
	Set<E> copy();

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements of both sets.
	 *
	 **/

	Set<E> union(Set<E> setOne, Set<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all the of the intersecting elements of both sets. Returns
	 *  				 an empty set if there are no intersecting elements.
	 *
	 **/

	Set<E> intersection (Set<E> setOne, Set<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements NOT contained in the first set.
	 *
	 **/

	Set<E> complement (Set<E> setOne, Set<E> setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements of both sets except for the
	 *  				 intersecting elements of both sets.
	 *
	 **/

	Set<E> difference (Set<E> setOne, Set<E> setTwo);
}
