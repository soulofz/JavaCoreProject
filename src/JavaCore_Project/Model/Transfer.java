package JavaCore_Project.Model;

public class Transfer {
    private final String accFrom;
    private final String accTo;
    private final int amount;
    private final String inputFile;

    public Transfer(String accFrom, String accTo, int amount, String inputFile) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.amount = amount;
        this.inputFile = inputFile;
    }

    public String getAccFrom() {
        return accFrom;
    }

    public String getAccTo() {
        return accTo;
    }

    public int getAmount() {
        return amount;
    }

    public String getInputFile() {
        return inputFile;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "accFrom='" + accFrom + '\'' +
                ", accTo='" + accTo + '\'' +
                ", amount=" + amount +
                ", inputFile='" + inputFile + '\'' +
                '}';
    }
}
