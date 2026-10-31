
import java.util.Scanner;

public class L4 {

    static char findFirstNonRepeatingChar(String text) {
        int[] frequency = new int[65536];

        for (int i = 0; i < text.length(); i++) {
            frequency[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a word or sentence: ");
        String text = sc.nextLine();

        char result = findFirstNonRepeatingChar(text);

        if (result == '\0') {
            System.out.println(
                "No Non-Repeating Character Found"
            );
        } else {
            System.out.println(
                "First Non-Repeating Character: '" +
                result + "'"
            );
        }

        sc.close();
    }
}
