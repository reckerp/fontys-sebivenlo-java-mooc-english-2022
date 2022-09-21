/**
 *
 * @author Paul Recker - 518962 - {@code p.recker@student.fontys.nl}
 */
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File:");
        String file = scanner.nextLine();
        System.out.println("Team:");
        String tName = scanner.nextLine();
        int count = 0;
         int wins = 0;
        int losses = 0;
        ArrayList<Team> teams = getTeams(file);
        
        for (Team team : teams) {

            if (team.getHomeTeam().contains(tName)) {
                count++;

                if (team.getHomeScore() >= team.getAwayScore()) {
                    wins += 1;
                    team.setWins();
                } else {
                    losses += 1;
                    team.setLosses();
                }

                team.playGame();
            } else if (team.getAwayTeam().contains(tName)) {
                count++;

                if (team.getAwayScore() >= team.getHomeScore()) {
                    wins += 1;
                    team.setWins();
                } else {
                    losses += 1;
                    team.setLosses();
                }

                team.playGame();
            }

        }

        System.out.println("Games: " + count);
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
    }
    
    public static ArrayList<Team> getTeams(String file){
        ArrayList<Team> al = new ArrayList<>();
        try (Scanner scannerF = new Scanner(Paths.get(file))) {

        // we read the file until all lines have been read
            while (scannerF.hasNextLine()) {
                // we read one line
                String row = scannerF.nextLine();
                // we print the line that we read
                String[] arr = row.split(",");
                al.add(new Team(arr[0], arr[1], Integer.valueOf(arr[2]), Integer.valueOf(arr[3])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return al;
    }
    

}
