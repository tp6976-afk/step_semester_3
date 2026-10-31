import java.util.Scanner;

class M2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        StringBuilder sb = new StringBuilder(str);
        String rev = sb.reverse().toString();

        if (str.equals(rev)) {
            System.out.println(rev + " - palindrome");
        } else {
            System.out.println(rev + " - not a palindrome");
        }

        sc.close();
    }
}