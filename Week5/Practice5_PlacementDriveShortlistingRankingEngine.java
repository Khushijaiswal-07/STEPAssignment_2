import java.util.Arrays;

public class Practice5_PlacementDriveShortlistingRankingEngine
        implements Comparable<Practice5_PlacementDriveShortlistingRankingEngine> {

    private String name;
    private double cgpa;
    private int codingScore;

    public Practice5_PlacementDriveShortlistingRankingEngine(
            String name, double cgpa, int codingScore) {

        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {

        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {

        return cgpa >= 6.5 && codingScore >= 60;
    }

    double getCompositeScore() {

        return cgpa * 10 + codingScore;
    }

    @Override
    public int compareTo(
            Practice5_PlacementDriveShortlistingRankingEngine other) {

        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    static String shortlistAndRank(
            Practice5_PlacementDriveShortlistingRankingEngine[] candidates) {

        Practice5_PlacementDriveShortlistingRankingEngine[] shortlisted =
                new Practice5_PlacementDriveShortlistingRankingEngine[candidates.length];

        int count = 0;

        for (int i = 0; i < candidates.length; i++) {

            if (isEligible(candidates[i].cgpa) ||
                isEligible(candidates[i].cgpa, candidates[i].codingScore)) {

                shortlisted[count] = candidates[i];
                count++;
            }
        }

        Practice5_PlacementDriveShortlistingRankingEngine[] finalList =
                Arrays.copyOf(shortlisted, count);

        Arrays.sort(finalList);

        String result = "";

        for (int i = 0; i < finalList.length; i++) {

            result = result + (i + 1)
                    + ". "
                    + finalList[i].name
                    + " ("
                    + finalList[i].getCompositeScore()
                    + ")";

            if (i < finalList.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Practice5_PlacementDriveShortlistingRankingEngine[] candidates = {

            new Practice5_PlacementDriveShortlistingRankingEngine(
                    "Aisha", 8.2, 40),

            new Practice5_PlacementDriveShortlistingRankingEngine(
                    "Rohit", 6.8, 65),

            new Practice5_PlacementDriveShortlistingRankingEngine(
                    "Meena", 6.0, 90),

            new Practice5_PlacementDriveShortlistingRankingEngine(
                    "Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);

        System.out.println(result);
    }
}