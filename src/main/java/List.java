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
    	current = null;
    	head = null;
    	tail = null;
    	numberOfElements = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public ListInterface<E> init() {
        return null;
    }

    public int size() {
        return 0;
    }

    public ListInterface<E> insert(E d) {
        return null;
    }

    public E retrieve() {
        return null;
    }

    public ListInterface<E> remove() {
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

    public ListInterface<E> copy() {
        return null;
    }
}
