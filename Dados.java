public class Dados {
    private int sequenceNumber;
    private String payload;

    public Dados(int sequenceNumber, String payload) {
        this.sequenceNumber = sequenceNumber;
        this.payload = payload;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    public String getPayload() {
        return this.payload;
    }
}