import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine {

```
static class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    static boolean isDraftable(int matchesPlayed) {

        return matchesPlayed >= 10;
    }

    static boolean isDraftable(int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {

        return Double.compare(other.battingAverage, this.battingAverage);
    }

    public String getName() {

        return name;
    }
}

static String draftAndRank(Player[] players) {

    Player[] draftable = new Player[players.length];

    int count = 0;

    for (int i = 0; i < players.length; i++) {

        if (Player.isDraftable(players[i].matchesPlayed)) {

            draftable[count] = players[i];

            count++;

        } else if (Player.isDraftable(players[i].matchesPlayed, players[i].injured)) {

            draftable[count] = players[i];

            count++;
        }
    }

    Player[] finalDraftable = Arrays.copyOf(draftable, count);

    Arrays.sort(finalDraftable);

    String result = "";

    for (int i = 0; i < finalDraftable.length; i++) {

        result = result + (i + 1) + ". " + finalDraftable[i].getName();

        if (i < finalDraftable.length - 1) {
            result = result + " | ";
        }
    }

    return result;
}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of players: ");
    int n = sc.nextInt();

    sc.nextLine();

    Player[] players = new Player[n];

    for (int i = 0; i < n; i++) {

        System.out.println("Enter details for player " + (i + 1) + ":");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Matches played: ");
        int matchesPlayed = sc.nextInt();

        System.out.print("Batting average: ");
        double battingAverage = sc.nextDouble();

        System.out.print("Injured (true/false): ");
        boolean injured = sc.nextBoolean();

        sc.nextLine();

        players[i] = new Player(
            name,
            matchesPlayed,
            battingAverage,
            injured
        );
    }

    String result = draftAndRank(players);

    System.out.println(result);

    sc.close();
}
```

}
