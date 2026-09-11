import java.util.Arrays;

public class Problem5_FantasyLeagueAutoDraftRankingEngine
        implements Comparable<Problem5_FantasyLeagueAutoDraftRankingEngine> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Problem5_FantasyLeagueAutoDraftRankingEngine(
            String name,
            int matchesPlayed,
            double battingAverage,
            boolean injured) {

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
    public int compareTo(
            Problem5_FantasyLeagueAutoDraftRankingEngine other) {

        return Double.compare(other.battingAverage, this.battingAverage);
    }

    static String draftAndRank(
            Problem5_FantasyLeagueAutoDraftRankingEngine[] players) {

        Problem5_FantasyLeagueAutoDraftRankingEngine[] draftable =
                new Problem5_FantasyLeagueAutoDraftRankingEngine[players.length];

        int count = 0;

        for (int i = 0; i < players.length; i++) {

            if (isDraftable(players[i].matchesPlayed) ||
                isDraftable(players[i].matchesPlayed, players[i].injured)) {

                draftable[count] = players[i];
                count++;
            }
        }

        Problem5_FantasyLeagueAutoDraftRankingEngine[] finalPlayers =
                Arrays.copyOf(draftable, count);

        Arrays.sort(finalPlayers);

        String result = "";

        for (int i = 0; i < finalPlayers.length; i++) {

            result = result + (i + 1) + ". " + finalPlayers[i].name;

            if (i < finalPlayers.length - 1) {
                result = result + " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Problem5_FantasyLeagueAutoDraftRankingEngine[] players = {

            new Problem5_FantasyLeagueAutoDraftRankingEngine(
                    "Virat", 15, 48.0, false),

            new Problem5_FantasyLeagueAutoDraftRankingEngine(
                    "Rahul", 7, 55.0, false),

            new Problem5_FantasyLeagueAutoDraftRankingEngine(
                    "Sameer", 3, 60.0, false),

            new Problem5_FantasyLeagueAutoDraftRankingEngine(
                    "Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);

        System.out.println(result);
    }
}