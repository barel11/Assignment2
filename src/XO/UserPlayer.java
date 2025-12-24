package XO;
import java.util.Scanner;

public class UserPlayer extends Player {
    private Scanner scanner;

    public UserPlayer(Game game, Game.Player type) {
        super(game, type);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run() {
        while (!game.isGameOver()) {
            try { Thread.sleep(100); } catch (Exception e) {}

            if (game.getTurn() == this.type && !game.isGameOver()) {
                System.out.println("YOUR TURN (" + type + ")! Enter row (0-4) and col (0-4):");
                boolean moveMade = false;

                while (!moveMade && !game.isGameOver()) {
                    try {
                        int row = scanner.nextInt();
                        int col = scanner.nextInt();
                        
                        moveMade = game.makeMove(row, col, this.type);
                        
                        if (!moveMade) System.out.println("Invalid move. Try again:");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Use numbers.");
                        scanner.nextLine(); 
                    }
                }
            }
        }
    }
}