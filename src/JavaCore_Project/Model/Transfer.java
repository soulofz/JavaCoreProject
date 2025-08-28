package JavaCore_Project.Model;

public class Transfer {
    private final String ACCFROM;
    private final String ACCTO;
    private final int AMOUNT;
    private final String INPUTFILE;

    public Transfer(String accFrom, String accTo, int amount, String inputFile) {
        this.ACCFROM = accFrom;
        this.ACCTO = accTo;
        this.AMOUNT = amount;
        this.INPUTFILE = inputFile;
    }

    public String getAccFrom() {
        return ACCFROM;
    }

    public String getAccTo() {
        return ACCTO;
    }

    public int getAmount() {
        return AMOUNT;
    }

    public String getInputFile() {
        return INPUTFILE;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "accFrom='" + ACCFROM + '\'' +
                ", accTo='" + ACCTO + '\'' +
                ", amount=" + AMOUNT +
                ", inputFile='" + INPUTFILE + '\'' +
                '}';
    }
}
