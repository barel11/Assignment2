package XO;
import java.util.Random;

public class SelfPlayer extends Player {

    public SelfPlayer(Game game, Game.Player type) {
        super(game, type);
    }

    @Override
    public void run() {
        Random rand = new Random();

        while (!game.isGameOver()) {
            try { Thread.sleep(500); } catch (Exception e) {}

            if (game.getTurn() == this.type) {
                Cells[] free = game.getFreeCells();

                if (free.length > 0) {
                    Cells c = free[rand.nextInt(free.length)];
                    game.makeMove(c.getRow(), c.getCol(), this.type);
                }
            }
        }
    }
}