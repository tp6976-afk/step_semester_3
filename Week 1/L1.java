
import java.util.Scanner;
import java.util.Random;

public class L1 {

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Rock, Paper, or Scissors: ");
            String player = sc.nextLine().trim();

            if (player.equalsIgnoreCase("rock")) {
                player = "Rock";
            } else if (player.equalsIgnoreCase("paper")) {
                player = "Paper";
            } else if (player.equalsIgnoreCase("scissors")) {
                player = "Scissors";
            } else {
                System.out.println("Invalid move. Try again.");
                i--;
                continue;
            }

            String computer = moves[random.nextInt(3)];
            String result = playRound(player, computer);

            playerMoves[i] = player;
            computerMoves[i] = computer;
            results[i] = result;

            System.out.println("Round " + (i + 1) + ": " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("\nFinal Scoreboard");
        System.out.printf("%-10s %-15s %-18s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < 5; i++) {
            System.out.printf("%-10d %-15s %-18s %-15s%n",
                    i + 1, playerMoves[i],
                    computerMoves[i], results[i]);
        }

        double percentage = (wins / 5.0) * 100;

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", percentage);

        sc.close();
    }
}
