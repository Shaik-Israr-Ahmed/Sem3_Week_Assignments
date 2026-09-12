import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveShortlistingRankingEngine {

```
static class Candidate implements Comparable<Candidate> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {

        return cgpa >= 8.0;
    }

    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    private double getCompositeScore() {

        return (cgpa * 10) + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {

        return Double.compare(
            other.getCompositeScore(),
            this.getCompositeScore()
        );
    }

    public String getName() {

        return name;
    }

    public double getScore() {

        return getCompositeScore();
    }
}

static String shortlistAndRank(Candidate[] candidates) {

    Candidate[] shortlisted = new Candidate[candidates.length];

    int count = 0;

    for (int i = 0; i < candidates.length; i++) {

        if (Candidate.isEligible(candidates[i].cgpa)) {

            shortlisted[count] = candidates[i];

            count++;

        } else if (Candidate.isEligible(
                candidates[i].cgpa,
                candidates[i].codingScore)) {

            shortlisted[count] = candidates[i];

            count++;
        }
    }

    Candidate[] finalShortlisted = Arrays.copyOf(shortlisted, count);

    Arrays.sort(finalShortlisted);

    String result = "";

    for (int i = 0; i < finalShortlisted.length; i++) {

        result = result
                + (i + 1)
                + ". "
                + finalShortlisted[i].getName()
                + " ("
                + finalShortlisted[i].getScore()
                + ")";

        if (i < finalShortlisted.length - 1) {
            result = result + " | ";
        }
    }

    return result;
}

public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of candidates: ");
    int n = sc.nextInt();

    sc.nextLine();

    Candidate[] candidates = new Candidate[n];

    for (int i = 0; i < n; i++) {

        System.out.println("Enter details for candidate " + (i + 1) + ":");

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("CGPA: ");
        double cgpa = sc.nextDouble();

        System.out.print("Coding score: ");
        int codingScore = sc.nextInt();

        sc.nextLine();

        candidates[i] = new Candidate(name, cgpa, codingScore);
    }

    String result = shortlistAndRank(candidates);

    System.out.println(result);

    sc.close();
}
```

}
