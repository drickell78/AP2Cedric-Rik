import java.math.BigInteger;
import java.util.HashMap;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Main {

    Scanner in;
    public HashMap<Identifier, Set<BigInteger>> hashMap;

    Main() {

        in = new Scanner(System.in);
        in.useDelimiter("");
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
        	errorHandler(in);
        }
    }

    public void errorHandler(Scanner in) throws APException{
        String line = in.nextLine();
        Scanner errorScanner = new Scanner(line);
        String last;
        String next = errorScanner.next();
        while(errorScanner.hasNext()){
            last = next;
            next = errorScanner.next();
            char lastChar = last.charAt(last.length()-1); // The last character of the previous identifier/number
            char firstChar = next.charAt(0);              // The first character of the next identifier/number
            if ((Character.isDigit(lastChar) || Character.isLetter(lastChar)) && (Character.isDigit(firstChar) || Character.isLetter(firstChar))){
                throw new APException("Invalid input");
            }
        }

    }

    private void skipSpaces(Scanner in) throws APException{
        while (in.hasNext() && nextCharIs(in, ' ')){
            nextChar(in);
        }
    }

    void writeName(Scanner in, Identifier id){
        while(nextCharIsLetter(in) || nextCharIsDigit(in)){
            id.addChar(nextChar(in));
        }
    }

    void removeSpaces(Scanner in) throws APException{
        String line = in.nextLine();
        line = line.replace(" ", "");
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter("");
        statement(lineScanner);
    }

    
    public void statement(Scanner in) throws APException {

        if (nextCharIsLetter(in)) {
    		assignment(in);
    	}
    	else if (nextCharIs(in,'?')) {
    		printStatement(in);
    	}
    	else if (nextCharIs(in,'/')) {
    		comment(in);
    	}
    	else {
    		throw new APException("Incorrect input");
    	}
    }
    
    public void assignment(Scanner in) throws APException {

        Identifier identifier = new Identifier(nextChar(in));
        while (in.hasNext()) {
            if (nextCharIsLetter(in) || nextCharIsDigit(in)) {
                identifier.addChar(nextChar(in));
            } else if (nextCharIs(in, '=')) {
                return;
            } else if (nextCharIs(in, ' ')) {
                skipSpaces(in);
            } else {
                throw new APException("Invalid identifier");
            }
        }

    	if (hashMap.containsKey(identifier)){
    	    hashMap.replace(identifier, expression(in));
        } else {
            hashMap.put(identifier, expression(in));
        }

    }
    
    public void printStatement(Scanner in){
        StringBuffer print = null;

    }
    
    public void comment(Scanner in) {
    	in.nextLine();
    }
    
    public Set expression(Scanner in) throws APException {

    	while(in.hasNext()){
            if (nextCharIsLetter(in)){
                skipSpaces(in);
            } else if (nextCharIsLetter(in)){
                Identifier identifier = new Identifier(nextChar(in));
                writeName(in, identifier);
                if (hashMap.containsKey(identifier) && !in.hasNext()){
                    return hashMap.get(identifier);
                } else if (hashMap.containsKey(identifier) && in.hasNext()) {

                } else if (!hashMap.containsKey(identifier)){
                    throw new APException("Set does not exist");
                }
            }
        }

        return term(in);
    }
    
    public Set term(Scanner in) throws APException{
    	return factor(in);
    }
    
    public Set factor(Scanner in) throws APException{
       return createSet(in);
    }
    
    public Set complexFactor(Scanner in) throws APException {
    	return expression(in);
    }
    
    public Set createSet(Scanner in) throws APException {
    	Set result = new Set();

        while(in.hasNext() && !nextCharIs(in, '}')){
            if(nextCharIs(in, ' ')){
                skipSpaces(in);
            } else if (nextCharIsDigit(in)) {
                int number = in.nextInt();
                result.add(number);
            } else {
                throw new APException("Invalid Set Input");
            }
        }
        in.next();
    	return result;
    }
    
    private void start() throws APException {
        program();
    }

    public static void main(String[] argv) throws APException {
        new Main().start();
    }
}
