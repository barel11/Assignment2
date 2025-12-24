package XO;

public abstract class Player extends Thread {
    protected Game game;
    protected Game.Player type; // X / O

    public Player(Game game, Game.Player type) {
        this.game = game;
        this.type = type;
    }
    @Override
    public abstract void run();
}