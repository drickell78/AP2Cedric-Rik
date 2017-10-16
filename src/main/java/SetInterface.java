import java.math.BigInteger;

interface SetInterface<E extends Comparable> {

	/**	@precondition -
	 *  @postcondition - A new set is initialized.
	 *
	 **/

	SetInterface init();

	/**	@precondition - The set is not empty.
	 *  @postcondition - Returns the current element of the set. (Current node of the linked list)
	 *
	 **/

	E get();

	/**	@precondition -
	 *  @postcondition - Adds the requested element into the correct place in the set, such that the set remains sorted.
	 *
	 **/

	void add(E d);

	/**	@precondition - The set is not empty.
	 *  @postcondition - Removes the requested element from the set.
	 *
	 **/

	void remove(E d);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements of both sets.
	 *
	 **/

	Set union(Set setOne, Set setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all the of the intersecting elements of both sets. Returns
	 *  				 an empty set if there are no intersecting elements.
	 *
	 **/

	Set intersection (Set setOne, Set setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements NOT contained in the first set.
	 *
	 **/

	Set complement (Set setOne, Set setTwo);

	/**	@precondition - There are two sets.
	 *  @postcondition - Returns the resultant set containing all of the elements of both sets except for the
	 *  				 intersecting elements of both sets.
	 *
	 **/

	Set difference (Set setOne, Set setTwo);
	
	int size();
}
