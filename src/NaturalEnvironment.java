import java.awt.*;

public class NaturalEnvironment {
    private int from;
    private int to;
    NaturalEnvironment(int from,int to) {
        this.from = from;
        this.to = to;
    }
    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public String toString() {
        return "NaturalEnvironment" +
                "from:" + from + "to:" + to;
    }
}

