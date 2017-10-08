
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
    	Node n = new Node(d);
    	
    	if (isEmpty()) {
    		current = n;
    		head = n;
    		tail = head;
    	}
    	else if (size() == 1) {
    		if (d.compareTo(current.data) == -1) {
    			head.prior = n;
    			n.next = head;
    			head = n;
    			current = head;
    		}
    		else if (d.compareTo(current.data) == 1) {
    			tail.next = n;
    			n.prior = tail;
    			tail = n;
    			current = tail;
    		}
    	}
    	else if (d.compareTo(current.data) == -1) {
    		while (d.compareTo(current.data) != 1 || current != null) {
    			current = current.prior;
    		}
    		Node temp = current.next;
    		current.next = n;
    		n.prior = current;
    		n.next = temp;
    		temp.prior = n;
    		current = n;
    	}
    	else if (d.compareTo(current.data) == 1) {
    		while (d.compareTo(current.data) != -1 || current != null) {
    			current = current.next;
    		}
    		Node temp = current.prior;
    		current.prior = n;
    		n.next = current;
    		n.prior = temp;
    		temp.next = n;
    		current = n;
    	}
    	numberOfElements ++;
    	
        return this;
    }

    public E retrieve() {
        return isEmpty() == true ? null : current.data;
    }

    public List<E> remove() {
    	if (!isEmpty()) {		
    		if (size() == 1) {
    			head = null;
    			tail = null;
    			current = null;
    		}
    		else if(current == head) {
    			head = head.next;
    			head.prior = null;
    			current = head;
    		}
    		else if(current == tail) {
    			tail = tail.prior;
    			tail.next = null;
    			current = tail;
    		}
    		else {  		
    			Node p = current.prior;
    			Node n = current.next;    	
    			p.next = n;
    			n.prior = p;
    			current = n;
    		}
    		numberOfElements --;
    	}   	
        return this;
    }

    public boolean find(E d) {
        return false;
    }

    public boolean goToFirst() {
    	if (isEmpty()) {
    		return false;
    	}
    	else {
    		current = head;
    		return true;
    	}
    }

    public boolean goToLast() {
    	if (isEmpty()) {
    		return false;
    	}
    	else {
    		current = tail;
    		return true;
    	}
    }

    public boolean goToNext() {
    	if (isEmpty() || current == tail) {
    		return false;
    	}
    	else {
    		current = current.next;
    		return true;
    	}
    }

    public boolean goToPrevious() {
    	if (isEmpty() || current == head) {
    		return false;
    	}
    	else {
    		current = current.prior;
    		return true;
    	}
    }

    public List<E> copy() {
        return null;
    }
}
