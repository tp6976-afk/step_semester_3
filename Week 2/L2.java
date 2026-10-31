
import java.util.Scanner;

public class L2 {

    static void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",", -1);

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println(
                "Name: " + fields[0].trim() +
                " | Roll No: " + fields[1].trim() +
                " | Dept: " + fields[2].trim()
            );
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student record: ");
        String csvLine = sc.nextLine();

        parseStudentRecord(csvLine);

        sc.close();
    }
}
