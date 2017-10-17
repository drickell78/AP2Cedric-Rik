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
    
    public void parseInput(String input) {
    	
    }
    
    public void interpreter() {
    	
    }

    private void start() {
        while (in.hasNextLine()) {
        	parseInput(in.nextLine());
        }
    }

    public static void main(String[] argv) {
        new Main().start();
    }
}
