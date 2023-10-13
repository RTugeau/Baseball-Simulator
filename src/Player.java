public class Player {
    private String firstName;
    private String lastName;
    private int order;
    private int ab;
    private int hits;
    private double avg;
    private int hr;
    private int rbi;
    private int bb;

    public Player(String fn, String ln, int o) {
        this.firstName = fn;
        this.lastName = ln;
        this.order = o;
        ab = 0;
        hits = 0;
        avg = 0.000;
        hr = 0;
        rbi = 0;
        bb = 0;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAb() {
        return ab;
    }

    public void setAB(int ab) {
        this.ab = ab;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int h) {
        this.hits = h;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getBb() {
        return bb;
    }

    public void setBb(int bb) {
        this.bb = bb;
    }

    public int getHr() {
        return hr;
    }

    public void setHr(int hr) {
        this.hr = hr;
    }

    public int getRbi() {
        return rbi;
    }

    public void setRbi(int rbi) {
        this.rbi = rbi;
    }

    public int getOrder() {
        return order;
    }
}
