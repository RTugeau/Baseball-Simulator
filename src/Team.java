import java.util.ArrayList;

public class Team {
    private String name;
    private ArrayList<Player> roster;
    private ArrayList<Pitcher> pitchers;
    private int runs;
    private int hits;

    public Team(String n, ArrayList<Player> r, ArrayList<Pitcher> p, int runs, int hits) {
        this.name = n;
        this.roster = r;
        this.pitchers = p;
        this.runs = runs;
        this.hits = hits;
    }

    public String getName() {
        return name;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int h) {
        this.hits = h;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int r) {
        this.runs = r;
    }

    public Player getPlayer(ArrayList<Player> r, int p) {
        for(int i = 0; i < r.size(); i++) {
            if(r.get(i).getOrder() == (p)) {
                return r.get(i);
            }
        }
        return null;
    }

    public Pitcher getPitcher(ArrayList<Pitcher> c, int p) {
        for(int i = 0; i < c.size(); i++) {
            if(c.get(i).getOrder() == (p)) {
                return c.get(i);
            }
        }
        return null;
    }
}
