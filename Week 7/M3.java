
class M3 {
    private final String firstName;
    private final String lastName;

    public M3(String fullName) {
        String[] names = fullName.split(" ");

        firstName = names[0];
        lastName = names[1];
    }

    public String getNickname() {
        return firstName + " " + lastName.charAt(0) + ".";
    }

    public static void main(String[] args) {
        M3 tag = new M3("Maria Gomez");

        System.out.println("Nickname: " + tag.getNickname());
    }
}
