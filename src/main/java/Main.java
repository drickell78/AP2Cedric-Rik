import java.math.BigInteger;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {

    Scanner in;
    public HashMap<Identifier, Set<BigInteger>> hashMap;

    Main() {

        in = new Scanner(System.in);
        hashMap = new HashMap<Identifier, Set<BigInteger>>();

    }
    
    char nextChar (Scanner in) {
    	return in.next().charAt(0);
    }
    
    boolean nextCharIs(Scanner in, char c) {
    	return in.hasNext(Pattern.quote(c+""));
    }
    
    boolean nextCharIsDigit (Scanner in) {
    	return in.hasNext("[0-9]");
    }
    
    boolean nextCharIsLetter (Scanner in) {
    	return in.hasNext("[a-zA-Z]");
    }
    
    public void program() throws APException {
    	while (in.hasNextLine()) {
        	statement(in.nextLine());
        }
    }
    
    public void statement(String input) throws APException {
    	if (nextCharIsLetter(in)) {
    		assignment(input);
    	}
    	else if (nextCharIs(in,'?')) {
    		printStatement(input);
    	}
    	else if (nextCharIs(in,'/')) {
    		comment(input);
    	}
    	else {
    		throw new APException("Incorrect input");
    	}
    }
    
    public void assignment(String input) throws APException {
    	String id = "";
    	String expression = "";
    	while (in.hasNext()) {
    		if (nextCharIsLetter(in) || nextCharIsDigit(in)) {
    			id += nextChar(in);
    		}
    		else if (nextCharIs(in, '=')) {
    			return;
    		}
    		else {
    			throw new APException("Invalid identifier");
    		}
    	}
    	nextChar(in);
    	while (in.hasNext()) {
    		expression += nextChar(in);
    	}
    	expression(expression);
    }
    
    public void expression(String input) {
    	
    }
    
    public void printStatement(String input) {
    	
    }

    public void comment(String input) {
    	
    }
    
    private void start() throws APException {
        program();
    }

    public static void main(String[] argv) throws APException {
        new Main().start();
    }
}
