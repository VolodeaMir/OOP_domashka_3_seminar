public class Answer {
    private Integer bull;
    private Integer cow;
    private int numTry;

    public Answer(Integer bull, Integer cow, int numTry) {
        this.bull = bull;
        this.cow = cow;
        this.numTry = numTry;
    }

    public Integer getBull() {
        return bull;
    }

    public Integer getCow() {
        return cow;
    }

    public int getNumTry() {
        return numTry;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "bull=" + bull +
                ", cow=" + cow +
                ", numTry=" + numTry +
                '}';
    }
}