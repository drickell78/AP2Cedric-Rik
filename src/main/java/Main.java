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
        removeSpaces(in);

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
        while (in.hasNext() && !nextCharIs(in, '=')) {
            if (nextCharIsLetter(in) || nextCharIsDigit(in)) {
                identifier.addChar(nextChar(in));
            } else if (nextCharIs(in, '(')) {
                complexFactor(in);
            } else {
                throw new APException("Invalid identifier");
            }
        }

    	if (hashMap.containsKey(identifier)){
    	    hashMap.replace(identifier, expression(in, identifier));
        } else {
            hashMap.put(identifier, expression(in, identifier));
        }

    }
    
    public void printStatement(Scanner in){
        StringBuffer print = null;

    }
    
    public void comment(Scanner in) {
    	in.nextLine();
    }
    
    public Set expression(Scanner in, Identifier id) throws APException {
        Set result = new Set();

    	while(in.hasNext()){
            if (nextCharIsLetter(in)){
                Identifier identifier = new Identifier(nextChar(in));
                writeName(in, identifier);
                if (hashMap.containsKey(identifier) && !in.hasNext()){
                    return hashMap.get(identifier);
                } else if (hashMap.containsKey(identifier) && in.hasNext()) {
                    if (nextCharIs(in, '+')){
                        hashMap.get(identifier).union(expression(in, identifier));
                    }else if (nextCharIs(in,'-')){
                        hashMap.get(identifier).complement(expression(in, identifier));
                    } else if(nextCharIs(in, '|')){
                        hashMap.get(identifier).difference(expression(in, identifier));
                    } else {
                        throw new APException("Invalid input: you are trying to do an invalid operation on a set");
                    }

                } else if (!hashMap.containsKey(identifier)){
                    throw new APException("Set does not exist");
                }
            } else if (nextCharIs(in, '{') && !in.hasNext()){
                hashMap.put(id, createSet(in));
            } else if (nextCharIs(in, '{') && in.hasNext()){

            }
        }
        term(in);
        return result;
    }
    
    public Set term(Scanner in) throws APException{
        Set result = new Set();

        while(in.hasNext()){
            if(nextCharIsLetter(in)){
                Identifier identifier = new Identifier(nextChar(in));
                writeName(in, identifier);
                if (hashMap.containsKey(identifier)){
                    if (nextCharIs(in, '*')){
                        hashMap.get(identifier).intersection(factor(in));
                    }
                } else if (!hashMap.containsKey(identifier)){
                    throw new APException("Invalid input: set does not exist");
                }
            } else if (nextCharIs(in, '{')){
                createSet(in);
            } else if (nextCharIs(in, '*')){
                factor(in);
            }
        }

        return result;
    }
    
    public Set factor(Scanner in) throws APException{
       while(in.hasNext()){

       }

        return createSet(in);
    }
    
    public Set complexFactor(Scanner in) throws APException {
    	Identifier identifier = new Identifier(nextChar(in));
        return expression(in, identifier);
    }
    
    public Set createSet(Scanner in) throws APException {
    	Set result = new Set();

        while(in.hasNext() && !nextCharIs(in, '}')){
            if (nextCharIsDigit(in)) {
                int number = in.nextInt();
                result.add(number);
            } else {
                throw new APException("Invalid Input: You are trying to add an invalid character into a set");
            }
        }
        nextChar(in);
    	return result;
    }
    
    private void start() throws APException {
        program();
    }

    public static void main(String[] argv) throws APException {
        new Main().start();
    }
}
