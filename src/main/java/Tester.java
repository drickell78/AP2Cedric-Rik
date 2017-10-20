import java.util.Scanner;
import java.io.PrintStream;

public class Tester {

    void start(){

        String string = "a = { 800 800, 1,2,3}";
        PrintStream out = new PrintStream(System.out);
        Scanner in = new Scanner(string);
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
                out.printf("This input is wrong \n");
            } else {
                out.printf("This input is right \n");
            }
        }

    }


    public static void main(String[] argv){
        new Tester().start();
    }

}
