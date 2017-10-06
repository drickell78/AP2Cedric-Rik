public class List<E extends Comparable> implements ListInterface <E> {
	Node current, head, tail;
	int numberOfElements;

    private class Node {
        E data;
        Node prior, next;

        public Node(E d) {
            this(d, null, null);
        }

        public Node(E data, Node prior, Node next) {
            this.data = data == null ? null : data;
            this.prior = prior;
            this.next = next;
        }

    }
    
    List() {
    	
    }

    public boolean isEmpty() {
        return head == null;
    }

    public List<E> init() {
    	current = null;
    	head = null;
    	tail = null;
    	numberOfElements = 0;
    	
        return this;
    }

    public int size() {
        return numberOfElements;
    }

    public List<E> insert(E d) {
        return null;
    }

    public E retrieve() {
        return isEmpty() == true ? null : current.data;
    }

    public List<E> remove() {
        return null;
    }

    public boolean find(E d) {
        return false;
    }

    public boolean goToFirst() {
        return false;
    }

    public boolean goToLast() {
        return false;
    }

    public boolean goToNext() {
        return false;
    }

    public boolean goToPrevious() {
        return false;
    }

    public List<E> copy() {
        return null;
    }
}
