
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
    
    List() {}

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
    		head = n;
    		tail = n;
    		current = n;   		
    	}  	
    	else if (d.compareTo(current.data) <= 0) {
    		while (current != head && current.prior.data.compareTo(d) > 0) {
    			goToPrevious();
    		}
    		if (current == head) {
    			head.prior = n;
    			n.next = head;
    			head = n;
    			current = head;
    		}
    		else {
        		n.next = current;
        		n.prior = current.prior;
        		current = current.prior = current.prior.next = n;
    		}
    	}
    	else if (d.compareTo(current.data) > 0) {
    		while (current != tail && current.next.data.compareTo(d) < 0) {
    			goToNext();
    		}
    		if (current == tail) {
    			tail.next = n;
    			n.prior = tail;
    			tail = n;
    			current = tail;
    		}
    		else {
        		n.prior = current;
        		n.next = current.next;
        		current = current.next = current.next.prior = n;
    		} 			
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
    			head = tail = current = null;
    		}
    		else if(current == head) {
    			current = head = head.next;
    		}
    		else if(current == tail) {
    			current = tail = tail.prior;
    		}
    		else {  		
    			current.next.prior = current.prior;
    			current.prior.next = current = current.next;
    		}
    		numberOfElements --;
    		return this;
    	}   	
    	return null;
    }

    public boolean find(E d) {
    	if (isEmpty()) {
    		return false;
    	}
    	if (current.data == d) {
    		return true;
    	}
    	if (d.compareTo(current.data) < 0) {
    		while (current != head && current.data != d) {
    			goToPrevious();
    		}
    	}
    	else if (d.compareTo(current.data) > 0) {
    		while (current != tail && current.data != d) {
    			goToNext();
    		}
    	}
    	return d == current.data;
    }

    public boolean goToFirst() {
    	if (isEmpty()) {
    		return false;
    	}
    	current = head;
    	return true;
    }

    public boolean goToLast() {
    	if (isEmpty()) {
    		return false;
    	}
    	current = tail;
    	return true;
    }

    public boolean goToNext() {
    	if (isEmpty() || current == tail) {
    		return false;
    	}
    	current = current.next;
    	return true;
    }

    public boolean goToPrevious() {
    	if (isEmpty() || current == head) {
    		return false;
    	}
    	current = current.prior;
    	return true;
    }

    public List<E> copy() {
    	List<E> copy = new List<E>();
    	goToFirst();
    	for (int i = 0; i < size(); i++) {
    		copy.insert(retrieve());
    		goToNext();
    	}
        return copy;
    }
}
