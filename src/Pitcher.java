public class Pitcher {
    private String firstName;
    private String lastName;
    private boolean pitched;
    private int order;
    private double ip;
    private int or;
    private int runs;
    private int hits;
    private int k;
    private int bb;
    private double era;

    public Pitcher(String fn, String ln, int o) {
        this.firstName = fn;
        this.lastName = ln;
        this.pitched = false;
        this.order = o;
        ip = 0.0;
        or = 0;
        runs = 0;
        hits = 0;
        k = 0;
        bb = 0;
        era = 0.00;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean getPitched() { return pitched; }

    public void setPitched(boolean pitched) {
        this.pitched = pitched;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public double getIp() {
        return ip;
    }

    public void setIp(double ip) {
        this.ip = ip;
    }

    public int getOr() { return or; }

    public void setOr(int or) { this.or = or; }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public int getBb() {
        return bb;
    }

    public void setBb(int bb) {
        this.bb = bb;
    }

    public double getEra() {
        return era;
    }

    public void setEra(double era) {

    }

    public int getOrder() {
        return order;
    }
}
