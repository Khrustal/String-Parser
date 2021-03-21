import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task {
    public static void main(String[] args) throws IOException {
        System.out.println("Input string:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        if (isValid(input))
            System.out.println(getString(input));
        else
            System.out.println("Incorrect input");
    }

    static boolean isValid(String string) {
        boolean digit = false;
        boolean waitingForSymbol = false;
        int openBrackets = 0;
        int closeBrackets = 0;
        int numbers = 0;
        for (char c : string.toCharArray()) {
            if (Character.isDigit(c)) {
                if (!digit)
                    numbers++;
                digit = true;

            }
            else if (c == '[') {
                if (!digit)
                    return false;
                digit = false;
                waitingForSymbol = true;
                openBrackets++;
            }
            else if (c == ']') {
                if (digit || waitingForSymbol)
                    return false;
                digit = false;
                closeBrackets++;
            }
            else if (Character.isLetter(c)) {
                if (digit)
                    return false;
                if (waitingForSymbol)
                    waitingForSymbol = false;
                digit = false;
            }
            else
                return false;
        }
        return (openBrackets == closeBrackets) && (numbers == openBrackets);
    }

    static String getString(String string) {
        StringBuilder result = new StringBuilder();

        while (!string.equals("")) {
            if (Character.isLetter(string.toCharArray()[0])) {
                result.append(string.toCharArray()[0]);
                string = string.substring(1);
            }

            else if (Character.isDigit(string.toCharArray()[0])) {
                StringBuilder digit = new StringBuilder();
                while (Character.isDigit(string.toCharArray()[0])) {
                    digit.append(string.toCharArray()[0]);
                    string = string.substring(1);
                }
                string = string.substring(1); // remove "[" symbol
                int brackets = 1;
                StringBuilder sub = new StringBuilder();
                while (brackets != 0) { //get line between "[" and "]"
                    if (string.toCharArray()[0] == '[')
                        brackets++;
                    else if (string.toCharArray()[0] == ']')
                        brackets--;
                    sub.append(string.toCharArray()[0]);
                    string = string.substring(1);
                }
                sub = new StringBuilder(sub.substring(0, sub.length() - 1)); // remove last "]"
                result.append(getString(sub.toString()).
                        repeat(Integer.parseInt(digit.toString()))); // repeat line digit times
            }
        }

        return result.toString();
    }
}
