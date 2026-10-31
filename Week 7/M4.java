
class M4 {
    private String combinationCode;
    private final int lockerNumber;

    public M4(int lockerNumber, String combinationCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = combinationCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (combinationCode.equals(currentCode)) {
            combinationCode = newCode;
            return true;
        }

        return false;
    }

    public int getLockerNumber() {
        return lockerNumber;
    }

    public static void main(String[] args) {
        M4 l = new M4(101, "1234");

        if (l.changeCode("1234", "5678")) {
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }

        if (l.changeCode("0000", "9999")) {
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected");
        }
    }
}
