package XO;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to XO 5x5!");
        System.out.println("1. Computer vs Computer");
        System.out.println("2. User vs Computer");
        
        int choice = scan.nextInt();
        
        Game game;
        Player p1, p2;

        if (choice == 1) {
            game = new SelfGame();
            p1 = new SelfPlayer(game, Game.Player.X);
            p2 = new SelfPlayer(game, Game.Player.O);
        } else {
            game = new UserGame();
            p1 = new UserPlayer(game, Game.Player.X);
            p2 = new SelfPlayer(game, Game.Player.O);
        }

        p1.start();
        p2.start();

        try {
            p1.join();
            p2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Game Over.");
    }
}