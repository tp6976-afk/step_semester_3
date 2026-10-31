
class M5 {
    private final String[] students;
    private int count;

    public M5(int capacity) {
        students = new String[capacity];
        count = 0;
    }

    public void markPresent(String name) {
        if (isPresent(name)) {
            System.out.println(name + " is already marked present");
            return;
        }

        if (count < students.length) {
            students[count] = name;
            count++;
            System.out.println(name + " marked present");
        } else {
            System.out.println("Attendance sheet is full");
        }
    }

    public int getPresentCount() {
        return count;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < count; i++) {
            if (students[i].equals(name)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        M5 sheet = new M5(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present Count: " +
                           sheet.getPresentCount());

        System.out.println("Is Ben present? " +
                           sheet.isPresent("Ben"));

        System.out.println("Is Chen present? " +
                           sheet.isPresent("Chen"));
    }
}
