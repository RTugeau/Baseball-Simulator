import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.lang.Thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Away Team: ");
        String away = scan.nextLine();
        ArrayList<Player> aTeam = new ArrayList<>();
        ArrayList<Pitcher> aPitch = new ArrayList<>();
        Team awy = new Team(away, aTeam, aPitch, 0, 0);
        System.out.println("Enter Home Team: ");
        String home = scan.nextLine();
        ArrayList<Player> hTeam = new ArrayList<>();
        ArrayList<Pitcher> hPitch = new ArrayList<>();
        Team hme = new Team(home, hTeam, hPitch, 0, 0);
        System.out.println("Select an option below.");
        System.out.println("1.) Fill Away Lineup");
        System.out.println("2.) Fill Home Lineup");
        System.out.println("3.) Import Away Lineup");
        System.out.println("4.) Import Home Lineup");
        System.out.println("5.) Play Game");
        System.out.println("6.) Show Stats");
        System.out.println("7.) Quit");
        int choice = scan.nextInt();
        while(choice != 7) {
            if(choice == 1) {
                // fill away lineup
                for(int i = 0; i < 9; i++) {
                    System.out.println("Enter Player Name: ");
                    String fn = scan.next();
                    String ln = scan.next();
                    Player p = new Player(fn, ln, i);
                    aTeam.add(p);
                    System.out.println(fn  + " " + ln  + " added to " + away);
                }

                for(int i = 0; i < 8; i++) {
                    System.out.println("Enter Pitcher Name: ");
                    String fn = scan.next();
                    String ln = scan.next();
                    Pitcher t = new Pitcher(fn, ln, i);
                    aPitch.add(t);
                    System.out.println(fn  + " " + ln  + " added to " + away);
                }

                System.out.println("Select an option below.");
                System.out.println("1.) Fill Away Lineup");
                System.out.println("2.) Fill Home Lineup");
                System.out.println("3.) Import Away Lineup");
                System.out.println("4.) Import Home Lineup");
                System.out.println("5.) Play Game");
                System.out.println("6.) Show Stats");
                System.out.println("7.) Quit");
                choice = scan.nextInt();
            } else if(choice == 2) {
                // fill home lineup
                for (int i = 0; i < 9; i++) {
                    System.out.println("Enter Player Name: ");
                    String fn = scan.next();
                    String ln = scan.next();
                    Player p = new Player(fn, ln, i);
                    hTeam.add(p);
                    System.out.println(fn + " " + ln + " added to " + home);
                }

                for(int i = 0; i < 8; i++) {
                    System.out.println("Enter Pitcher Name: ");
                    String fn = scan.next();
                    String ln = scan.next();
                    Pitcher t = new Pitcher(fn, ln, i);
                    hPitch.add(t);
                    System.out.println(fn  + " " + ln  + " added to " + home);
                }

                System.out.println("Select an option below.");
                System.out.println("1.) Fill Away Lineup");
                System.out.println("2.) Fill Home Lineup");
                System.out.println("3.) Import Away Lineup");
                System.out.println("4.) Import Home Lineup");
                System.out.println("5.) Play Game");
                System.out.println("6.) Show Stats");
                System.out.println("7.) Quit");
                choice = scan.nextInt();
            } else if(choice == 3) {
                //import away lineup
                System.out.println("Enter roster file name: ");
                try {
                    Scanner fscan = new Scanner(System.in);
                    String file = fscan.next() + ".txt";
                    FileInputStream filein = new FileInputStream(file);
                    Scanner s = new Scanner(filein);
                    int o = 0;
                    int po = 0;
                    while(s.hasNext()) {
                        String[] player = s.nextLine().split(" ");
                        String fn = player[0];
                        String ln = player[1];
                        if(o >= 9) {
                            Pitcher t = new Pitcher(fn, ln, po);
                            aPitch.add(t);
                            System.out.println(fn + " " + ln + " added to " + away);
                            po++;
                            o++;
                        } else {
                            Player p = new Player(fn, ln, o);
                            aTeam.add(p);
                            System.out.println(fn + " " + ln + " added to " + away);
                            o++;
                        }
                    }
                    System.out.println("Select an option below.");
                    System.out.println("1.) Fill Away Lineup");
                    System.out.println("2.) Fill Home Lineup");
                    System.out.println("3.) Import Away Lineup");
                    System.out.println("4.) Import Home Lineup");
                    System.out.println("5.) Play Game");
                    System.out.println("6.) Show Stats");
                    System.out.println("7.) Quit");
                    choice = scan.nextInt();
                } catch(FileNotFoundException e) {
                    System.out.println("The provided file name was not found. Please try again.");
                }
            } else if(choice == 4) {
                //import home lineup
                System.out.println("Enter roster file name: ");
                try {
                    Scanner fscan = new Scanner(System.in);
                    String file = fscan.next() + ".txt";
                    FileInputStream filein = new FileInputStream(file);
                    Scanner s = new Scanner(filein);
                    int o = 0;
                    int po = 0;
                    while(s.hasNext()) {
                        String[] player = s.nextLine().split(" ");
                        String fn = player[0];
                        String ln = player[1];
                        if(o >= 9) {
                            Pitcher t = new Pitcher(fn, ln, po);
                            hPitch.add(t);
                            System.out.println(fn + " " + ln + " added to " + home);
                            o++;
                            po++;
                        } else {
                            Player p = new Player(fn, ln, o);
                            hTeam.add(p);
                            System.out.println(fn + " " + ln + " added to " + home);
                            o++;
                        }
                    }
                    System.out.println("Select an option below.");
                    System.out.println("1.) Fill Away Lineup");
                    System.out.println("2.) Fill Home Lineup");
                    System.out.println("3.) Import Away Lineup");
                    System.out.println("4.) Import Home Lineup");
                    System.out.println("5.) Play Game");
                    System.out.println("6.) Show Stats");
                    System.out.println("7.) Quit");
                    choice = scan.nextInt();
                } catch(FileNotFoundException e) {
                    System.out.println("The provided file name was not found. Please try again.");
                }
            } else if(choice == 5) {
                // sim game
                hme.setRuns(0);
                hme.setHits(0);
                awy.setRuns(0);
                awy.setHits(0);
                System.out.println(away + " Lineup");
                for (int i = 0; i < aTeam.size(); i++) {
                    System.out.println(i + 1 + ": " + aTeam.get(i).getLastName());
                }
                System.out.println();
                System.out.println(away + " Starting Pitcher: " + aPitch.get(0).getFirstName() + " " + aPitch.get(0).getLastName());
                System.out.println();
                System.out.println(home + " Lineup");
                for (int j = 0; j < hTeam.size(); j++) {
                    System.out.println(j + 1 + ": " + hTeam.get(j).getLastName());
                }
                System.out.println();
                System.out.println(home + " Starting Pitcher: " + hPitch.get(0).getFirstName() + " " + hPitch.get(0).getLastName());
                System.out.println();
                System.out.println("Enter Game Length (3) innings, (6) innings, (9) innings: ");
                int gameLength = scan.nextInt();
                int inning = 1;
                int halfInning = 0;
                int numHalfInning;
                if (gameLength == 3) {
                    numHalfInning = 6;
                } else if (gameLength == 6) {
                    numHalfInning = 12;
                } else {
                    numHalfInning = 18;
                }
                System.out.println(awy.getName() + ": " + awy.getRuns() + " Runs, " + awy.getHits() + " Hits, 0 Errors");
                System.out.println(hme.getName() + ": " + hme.getRuns() + " Runs, " + hme.getHits() + " Hits, 0 Errors");
                int aPlays = 0;
                int hPlays = 0;
                Pitcher pitcher;
                Pitcher ap = awy.getPitcher(aPitch, 0);
                Pitcher hp = hme.getPitcher(hPitch, 0);
                int numHp = 1;
                int numAp = 1;
                while (halfInning < 100) {
                    int outs = 0;
                    int first = 0;
                    int second = 0;
                    int third = 0;
                    int rs = 0;
                    int[] br;
                    if (halfInning == numHalfInning - 1 && hme.getRuns() > awy.getRuns()) {
                        break;
                    }
                    if (halfInning % 2 == 0) {
                        System.out.println("Top " + inning);
                        if(inning >= 4) {
                            System.out.println("Pitching change? (1. Y, 0. N): ");
                            int u = scan.nextInt();
                            if(u == 1) {
                                System.out.println("Select a new pitcher below: ");
                                if (numHp == hPitch.size()) {
                                    System.out.println("No more available pitchers");
                                    continue;
                                } else {
                                    for (int i = 1; i < hPitch.size(); i++) {
                                        if (!hPitch.get(i).getPitched()) {
                                            System.out.println(i + ".) " + hPitch.get(i).getFirstName() + " " + hPitch.get(i).getLastName());
                                        }
                                    }
                                }
                                int z = scan.nextInt();
                                hp = hPitch.get(z);
                                hp.setPitched(true);
                                numHp++;
                            }
                        }
                        System.out.println("Pitching: " + hp.getFirstName() + " " + hp.getLastName());
                    } else {
                        System.out.println("Bottom " + inning);
                        if(inning >= 4) {
                            System.out.println("Pitching change? (1. Y, 0. N): ");
                            int u = scan.nextInt();
                            if(u == 1) {
                                System.out.println("Select a new pitcher below: ");
                                if (numAp == aPitch.size()) {
                                    System.out.println("No more available pitchers");
                                    continue;
                                } else {
                                    for (int i = 1; i < aPitch.size(); i++) {
                                        if (!aPitch.get(i).getPitched()) {
                                            System.out.println(i + ".) " + aPitch.get(i).getFirstName() + " " + aPitch.get(i).getLastName());
                                        }
                                    }
                                }
                                int z = scan.nextInt();
                                ap = aPitch.get(z);
                                ap.setPitched(true);
                                numAp++;
                            }
                        }
                        System.out.println("Pitching: " + ap.getFirstName() + " " + ap.getLastName());
                    }
                    while (outs < 3) {
                        Player batter;
                        if (halfInning % 2 == 0) {
                            batter = awy.getPlayer(aTeam, aPlays % 9);
                            pitcher = hp;
                            aPlays++;
                        } else {
                            batter = hme.getPlayer(hTeam, hPlays % 9);
                            pitcher = ap;
                            hPlays++;
                        }
                        Random rand = new Random();
                        int play = rand.nextInt(20) + 1;
                        if (play == 1 || play == 2 || play == 10 || play == 16 || play == 20) {
                            outs++;
                            int b = batter.getAb() +1;
                            batter.setAB(b);
                            int or = pitcher.getOr() +1;
                            pitcher.setOr(or);
                            int k = pitcher.getK() +1;
                            pitcher.setK(k);
                            System.out.println(batter.getLastName() + " struck out " + outs + " OUTS");
                            Thread.sleep(2000);
                        } else if (play == 4 || play == 11 || play == 13 || play == 15) {
                            outs++;
                            int b = batter.getAb() + 1;
                            batter.setAB(b);
                            int or = pitcher.getOr() +1;
                            pitcher.setOr(or);
                            System.out.println(batter.getLastName() + " grounded out " + outs + " OUTS");
                            Thread.sleep(2000);
                        } else if (play == 6 || play == 17) {
                            outs++;
                            int b = batter.getAb() + 1;
                            batter.setAB(b);
                            int or = pitcher.getOr() +1;
                            pitcher.setOr(or);
                            System.out.println(batter.getLastName() + " lined out " + outs + " OUTS");
                            Thread.sleep(2000);
                        } else if (play == 8 || play == 9 || play == 19) {
                            outs++;
                            int b = batter.getAb() + 1;
                            batter.setAB(b);
                            int or = pitcher.getOr() +1;
                            pitcher.setOr(or);
                            System.out.println(batter.getLastName() + " flied out " + outs + " OUTS");
                            Thread.sleep(2000);
                        } else if (play == 3 || play == 12) {
                            if (halfInning % 2 == 0) {
                                int a = awy.getHits() + 1;
                                awy.setHits(a);
                                int h = pitcher.getHits() +1;
                                pitcher.setHits(h);
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                a = awy.getRuns();
                                awy.setRuns(a += rs);
                                if (rs > 0) {
                                    System.out.println(batter.getLastName() + " singled, " + rs + " runs scored");
                                    batter.setRbi(batter.getRbi() + rs);
                                    int r = pitcher.getRuns() + rs;
                                    pitcher.setRuns(r);
                                } else {
                                    System.out.println(batter.getLastName() + " singled");
                                }
                                rs = 0;
                            } else {
                                int a = hme.getHits() + 1;
                                hme.setHits(a);
                                int h = pitcher.getHits() +1;
                                pitcher.setHits(h);
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                a = hme.getRuns();
                                hme.setRuns(a += rs);
                                if (rs > 0) {
                                    System.out.println(batter.getLastName() + " singled, " + rs + " runs scored");
                                    batter.setRbi(batter.getRbi() + rs);
                                    int r = pitcher.getRuns() + rs;
                                    pitcher.setRuns(r);
                                    if(halfInning >= numHalfInning && hme.getRuns() > awy.getRuns()) {
                                        break;
                                    }
                                } else {
                                    System.out.println(batter.getLastName() + " singled");
                                }
                                rs = 0;
                            }
                            int b = batter.getAb() + 1;
                            batter.setAB(b);
                            int hits = batter.getHits() + 1;
                            batter.setHits(hits);
                            Thread.sleep(2000);
                        } else if (play == 5) {
                            if (halfInning % 2 == 0) {
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                int a = awy.getRuns();
                                awy.setRuns(a += rs);
                                int b = batter.getBb() + 1;
                                batter.setBb(b);
                                int w = pitcher.getBb() +1;
                                pitcher.setBb(w);
                                if (rs > 0) {
                                    System.out.println(batter.getLastName() + " walked, " + rs + " runs scored");
                                    batter.setRbi(batter.getRbi() + rs);
                                    int r = pitcher.getRuns() + rs;
                                    pitcher.setRuns(r);
                                } else {
                                    System.out.println(batter.getLastName() + " walked");
                                }
                                rs = 0;
                            } else {
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                int a = hme.getRuns();
                                hme.setRuns(a += rs);
                                int b = batter.getBb() + 1;
                                batter.setBb(b);
                                int w = pitcher.getBb() +1;
                                pitcher.setBb(w);
                                if (rs > 0) {
                                    System.out.println(batter.getLastName() + " walked, " + rs + " runs scored");
                                    batter.setRbi(batter.getRbi() + rs);
                                    int r = pitcher.getRuns() + rs;
                                    pitcher.setRuns(r);
                                    if(halfInning >= numHalfInning && hme.getRuns() > awy.getRuns()) {
                                        break;
                                    }
                                } else {
                                    System.out.println(batter.getLastName() + " walked");
                                }
                                rs = 0;
                            }
                            Thread.sleep(2000);
                        } else if (play == 7) {
                            if (halfInning % 2 == 0) {
                                int a = awy.getHits() + 1;
                                awy.setHits(a);
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                a = awy.getRuns();
                                awy.setRuns(a += rs);
                                int h = pitcher.getHits() +1;
                                pitcher.setHits(h);
                                int r = pitcher.getRuns() + rs;
                                pitcher.setRuns(r);
                                System.out.println(batter.getLastName() + " homered, " + rs + " runs scored");
                                batter.setRbi(batter.getRbi() + rs);
                                rs = 0;
                            } else {
                                int a = hme.getHits() + 1;
                                hme.setHits(a);
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                a = hme.getRuns();
                                hme.setRuns(a += rs);
                                int h = pitcher.getHits() +1;
                                pitcher.setHits(h);
                                int r = pitcher.getRuns() + rs;
                                pitcher.setRuns(r);
                                System.out.println(batter.getLastName() + " homered, " + rs + " runs scored");
                                batter.setRbi(batter.getRbi() + rs);
                                rs = 0;
                                if(halfInning >= numHalfInning && hme.getRuns() > awy.getRuns()) {
                                    break;
                                }
                            }
                            int b = batter.getAb() + 1;
                            batter.setAB(b);
                            int hits = batter.getHits() + 1;
                            batter.setHits(hits);
                            int hr = batter.getHr() + 1;
                            batter.setHr(hr);
                            Thread.sleep(2000);
                        } else if (play == 14) {
                            if (halfInning % 2 == 0) {
                                int a = awy.getHits() + 1;
                                awy.setHits(a);
                                int h = pitcher.getHits() +1;
                                pitcher.setHits(h);
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                a = awy.getRuns();
                                awy.setRuns(a += rs);
                                if (rs > 0) {
                                    System.out.println(batter.getLastName() + " tripled, " + rs + " runs scored");
                                    batter.setRbi(batter.getRbi() + rs);
                                    int r = pitcher.getRuns() + rs;
                                    pitcher.setRuns(r);
                                } else {
                                    System.out.println(batter.getLastName() + " tripled");
                                }
                                rs = 0;
                            } else {
                                int a = hme.getHits() + 1;
                                hme.setHits(a);
                                int h = pitcher.getHits() +1;
                                pitcher.setHits(h);
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                a = hme.getRuns();
                                hme.setRuns(a += rs);
                                if (rs > 0) {
                                    System.out.println(batter.getLastName() + " tripled, " + rs + " runs scored");
                                    batter.setRbi(batter.getRbi() + rs);
                                    int r = pitcher.getRuns() + rs;
                                    pitcher.setRuns(r);
                                    if(halfInning >= numHalfInning && hme.getRuns() > awy.getRuns()) {
                                        break;
                                    }
                                } else {
                                    System.out.println(batter.getLastName() + " tripled");
                                }
                                rs = 0;
                            }
                            int b = batter.getAb() + 1;
                            batter.setAB(b);
                            int hits = batter.getHits() + 1;
                            batter.setHits(hits);
                            Thread.sleep(2000);
                        } else if (play == 18) {
                            if (halfInning % 2 == 0) {
                                int a = awy.getHits() + 1;
                                awy.setHits(a);
                                int h = pitcher.getHits() +1;
                                pitcher.setHits(h);
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                a = awy.getRuns();
                                awy.setRuns(a += rs);
                                if (rs > 0) {
                                    System.out.println(batter.getLastName() + " doubled, " + rs + " runs scored");
                                    batter.setRbi(batter.getRbi() + rs);
                                    int r = pitcher.getRuns() + rs;
                                    pitcher.setRuns(r);
                                } else {
                                    System.out.println(batter.getLastName() + " doubled");
                                }
                                rs = 0;
                            } else {
                                int a = hme.getHits() + 1;
                                hme.setHits(a);
                                int h = pitcher.getHits() +1;
                                pitcher.setHits(h);
                                br = baserunning(play, first, second, third);
                                rs += br[0];
                                first = br[1];
                                second = br[2];
                                third = br[3];
                                a = hme.getRuns();
                                hme.setRuns(a += rs);
                                if (rs > 0) {
                                    System.out.println(batter.getLastName() + " doubled, " + rs + " runs scored");
                                    batter.setRbi(batter.getRbi() + rs);
                                    int r = pitcher.getRuns() + rs;
                                    pitcher.setRuns(r);
                                    if(halfInning >= numHalfInning && hme.getRuns() > awy.getRuns()) {
                                        break;
                                    }
                                } else {
                                    System.out.println(batter.getLastName() + " doubled");
                                }
                                rs = 0;
                            }
                            int b = batter.getAb() + 1;
                            batter.setAB(b);
                            int hits = batter.getHits() + 1;
                            batter.setHits(hits);
                            Thread.sleep(2000);
                        }
                    }
                    if (halfInning % 2 == 0) {
                        System.out.println("Middle " + inning);
                    } else {
                        System.out.println("End " + inning);
                        inning++;
                    }
                    System.out.println(awy.getName() + ": " + awy.getRuns() + " Runs, " + awy.getHits() + " Hits, 0 Errors");
                    System.out.println(hme.getName() + ": " + hme.getRuns() + " Runs, " + hme.getHits() + " Hits, 0 Errors");
                    halfInning++;
                    Thread.sleep(5000);
                    if (halfInning >= numHalfInning && hme.getRuns() > awy.getRuns() || halfInning == numHalfInning && awy.getRuns() > hme.getRuns()) {
                        break;
                    } else if (halfInning % 2 == 0 && halfInning > numHalfInning && awy.getRuns() > hme.getRuns()) {
                        break;
                    }
                }
                System.out.println("Game Over!");
                if (awy.getRuns() > hme.getRuns()) {
                    System.out.println("The " + awy.getName() + " beat the " + hme.getName() + ", " + awy.getRuns() + " to " + hme.getRuns());
                } else {
                    System.out.println("The " + hme.getName() + " beat the " + awy.getName() + ", " + hme.getRuns() + " to " + awy.getRuns());
                }
                System.out.println("Select an option below.");
                System.out.println("1.) Fill Away Lineup");
                System.out.println("2.) Fill Home Lineup");
                System.out.println("3.) Import Away Lineup");
                System.out.println("4.) Import Home Lineup");
                System.out.println("5.) Play Game");
                System.out.println("6.) Show Stats");
                System.out.println("7.) Quit");
                choice = scan.nextInt();
            } else if(choice == 6) {
                System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%n", away, "AB", "H", "RBI", "HR", "BB", "AVG");
                for(int i = 0; i < aTeam.size(); i++) {
                    double avg = (double)awy.getPlayer(aTeam, i).getHits() / awy.getPlayer(aTeam, i).getAb();
                    System.out.printf("%-20s%-5d%-5d%-5d%-5d%-5d%-6.3f%n", awy.getPlayer(aTeam, i).getFirstName() + " " + awy.getPlayer(aTeam, i).getLastName(), awy.getPlayer(aTeam, i).getAb(),
                            awy.getPlayer(aTeam, i).getHits(), awy.getPlayer(aTeam, i).getRbi(), awy.getPlayer(aTeam, i).getHr(), awy.getPlayer(aTeam, i).getBb(), avg);
                    awy.getPlayer(aTeam, i).setAvg(avg);
                }
                System.out.println();
                System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%n", away, "IP", "R", "H", "K", "BB", "ERA");
                for(int i = 0; i < aPitch.size(); i++) {
                    double ip = awy.getPitcher(aPitch, i).getOr() / 3.0;
                    awy.getPitcher(aPitch, i).setIp(ip);
                    double era = 9.0 * awy.getPitcher(aPitch, i).getRuns() / awy.getPitcher(aPitch, i).getIp();
                    System.out.printf("%-20s%-5.1f%-5d%-5d%-5d%-5d%-6.3f%n", awy.getPitcher(aPitch, i).getFirstName() + " " + awy.getPitcher(aPitch, i).getLastName(), awy.getPitcher(aPitch, i).getIp(),
                            awy.getPitcher(aPitch, i).getRuns(), awy.getPitcher(aPitch, i).getHits(), awy.getPitcher(aPitch, i).getK(), awy.getPitcher(aPitch, i).getBb(), era);
                    awy.getPitcher(aPitch, i).setEra(era);
                }
                System.out.println();
                System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%n", home, "AB", "H", "RBI", "HR", "BB", "AVG");
                for(int i = 0; i < hTeam.size(); i++) {
                    double avg = (double)hme.getPlayer(hTeam, i).getHits() / hme.getPlayer(hTeam, i).getAb();
                    System.out.printf("%-20s%-5d%-5d%-5d%-5d%-5d%-6.3f%n", hme.getPlayer(hTeam, i).getFirstName() + " " + hme.getPlayer(hTeam, i).getLastName(), hme.getPlayer(hTeam, i).getAb(),
                            hme.getPlayer(hTeam, i).getHits(), hme.getPlayer(hTeam, i).getRbi(), hme.getPlayer(hTeam, i).getHr(), hme.getPlayer(hTeam, i).getBb(), avg);
                    hme.getPlayer(hTeam,i).setAvg(avg);
                }
                System.out.println();
                System.out.printf("%-20s%-5s%-5s%-5s%-5s%-5s%-5s%n", home, "IP", "R", "H", "K", "BB", "ERA");
                for(int i = 0; i < hPitch.size(); i++) {
                    double ip = hme.getPitcher(hPitch, i).getOr() / 3.0;
                    hme.getPitcher(hPitch, i).setIp(ip);
                    double era = 9.0 * hme.getPitcher(hPitch, i).getRuns() / hme.getPitcher(hPitch, i).getIp();
                    System.out.printf("%-20s%-5.1f%-5d%-5d%-5d%-5d%-6.3f%n", hme.getPitcher(hPitch, i).getFirstName() + " " + hme.getPitcher(hPitch, i).getLastName(), ip,
                            hme.getPitcher(hPitch, i).getRuns(), hme.getPitcher(hPitch, i).getHits(), hme.getPitcher(hPitch, i).getK(), hme.getPitcher(hPitch, i).getBb(), era);
                    hme.getPitcher(hPitch, i).setEra(era);
                }
                System.out.println("Select an option below.");
                System.out.println("1.) Fill Away Lineup");
                System.out.println("2.) Fill Home Lineup");
                System.out.println("3.) Import Away Lineup");
                System.out.println("4.) Import Home Lineup");
                System.out.println("5.) Play Game");
                System.out.println("6.) Show Stats");
                System.out.println("7.) Quit");
                choice = scan.nextInt();
            } else {
                System.out.println(choice + " is not a valid choice. Select again ");
                System.out.println("1.) Fill Away Lineup");
                System.out.println("2.) Fill Home Lineup");
                System.out.println("3.) Import Away Lineup");
                System.out.println("4.) Import Home Lineup");
                System.out.println("5.) Play Game");
                System.out.println("6.) Show Stats");
                System.out.println("7.) Quit");
                choice = scan.nextInt();
            }
        }
    }

    public static int[] baserunning(int play, int first, int second, int third) {
        int rs = 0;
        int[] br = new int[4];
        if(play == 3 || play == 12) {
            if(first != 0) {
                if(second != 0) {
                    if(third != 0) {
                        rs++;      // Bases Loaded
                    } else {
                        third = 1;   // Runners at 1st and 2nd
                    }
                } else {
                    if(third != 0) {
                        rs++;      // Runners on 1st and 3rd
                        third = 0;
                        second = 1;
                    } else{
                        second = 1;   // Runner on 1st
                    }
                }
            } else {
                if(second != 0) {
                    if(third != 0) {
                        rs++;      // Runners on 2nd and 3rd
                        first = 1;
                        second = 0;
                    } else {
                        first = 1;   // Runner on 2nd
                        second = 0;
                        third = 1;
                    }
                } else {
                    if(third != 0) {
                        rs++;      // Runner on 3rd
                        third = 0;
                        first = 1;
                    } else {
                        first = 1;   // No Runners on
                    }
                }
            }
        } else if(play == 18) {
            if(first != 0) {
                if(second != 0) {
                    if(third != 0) {
                        rs += 2;
                        first = 0;
                    } else {
                        rs++;
                        third = 1;
                        first = 0;
                    }
                } else {
                    if(third != 0) {
                        rs++;
                        second = 1;
                        first = 0;
                    } else {
                        first = 0;
                        second = 1;
                        third = 1;
                    }
                }
            } else {
                if(second != 0) {
                    if(third != 0) {
                        rs += 2;
                        third = 0;
                    } else {
                        rs++;
                    }
                } else {
                    if(third != 0) {
                        rs++;
                        third = 0;
                        second = 1;
                    } else {
                        second = 1;
                    }
                }
            }
        } else if(play == 14) {
            if(first != 0) {
                if(second != 0) {
                    if(third != 0) {
                        rs += 3;
                        second = 0;
                        first = 0;
                    } else {
                        rs += 2;
                        third = 1;
                        second = 0;
                        first = 0;
                    }
                } else {
                    if(third != 0) {
                        rs += 2;
                        first = 0;
                    } else {
                        rs += 1;
                        first = 0;
                        third = 1;
                    }
                }
            } else {
                if(second != 0) {
                    if(third != 0) {
                        rs += 2;
                        second = 0;
                    } else {
                        rs += 1;
                        third = 1;
                        second = 0;
                    }
                } else {
                    if(third != 0) {
                        rs += 1;
                    } else {
                        third = 1;
                    }
                }
            }
        } else if(play == 5) {
            if(first != 0) {
                if(second != 0) {
                    if(third != 0) {
                        rs++;
                    } else {
                        third = 1;
                    }
                } else {
                    second = 1;
                }
            } else {
                first = 1;
            }
        } else if(play == 7) {
            rs++;
            if(first != 0) {
                rs++;
                first = 0;
            }
            if(second != 0) {
                rs++;
                second = 0;
            }
            if(third != 0) {
                rs++;
                third = 0;
            }
        }
        br[0] = rs;
        br[1] = first;
        br[2] = second;
        br[3] = third;
        return br;
    }
}
