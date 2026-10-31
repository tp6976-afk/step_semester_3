```java
import java.util.Scanner;
import java.time.LocalDate;

abstract class LibraryItem {
    String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract int getLoanPeriod();

    LocalDate getDueDate() {
        return LocalDate.of(2023, 10, 26)
                .plusDays(getLoanPeriod());
    }
}

class Book extends LibraryItem {
    Book(String title) {
        super(title);
    }

    @Override
    int getLoanPeriod() {
        return 14;
    }
}

class DVD extends LibraryItem {
    DVD(String title) {
        super(title);
    }

    @Override
    int getLoanPeriod() {
        return 7;
    }
}

class Magazine extends LibraryItem {
    Magazine(String title) {
        super(title);
    }

    @Override
    int getLoanPeriod() {
        return 3;
    }
}

public class M2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            int firstSpace = line.indexOf(' ');

            String type = line.substring(0, firstSpace);
            String title = line.substring(firstSpace + 1).trim();

            if (title.startsWith("\"") && title.endsWith("\"")) {
                title = title.substring(1, title.length() - 1);
            }

            LibraryItem item;

            switch (type.toUpperCase()) {
                case "BOOK":
                    item = new Book(title);
                    break;
                case "DVD":
                    item = new DVD(title);
                    break;
                case "MAGAZINE":
                    item = new Magazine(title);
                    break;
                default:
                    continue;
            }

            System.out.println(
                item.title + ": " + item.getDueDate()
            );
        }

        sc.close();
    }
}
```