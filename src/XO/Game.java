package XO;

public abstract class Game {

	public enum Player {
		X, O
	}

	private char[][] gameBoard = new char[5][5];
	private int count = 0;
	
	public Game() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameBoard[i][j] = ' ';
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < 5; i++) {
			System.out.println();
			for (int j = 0; j < 5; j++) {
				System.out.print(gameBoard[i][j]);
			}
		}
	}

	public Player getTurn() {
	    Player turn;
	    if (count % 2 == 0) {
	        turn = Player.X;
	    } else {
	        turn = Player.O;
	    }
	    count++;
	    return turn;
	}


	public Cells[] getFreeCells() {
		int count = 0;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (gameBoard[i][j] == ' ') {
					count++;
				}
			}
		}
		int counter = 0;
		Cells[] cells = new Cells[count];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (gameBoard[i][j] == ' ') {
					cells[counter] = new Cells(i, j);
					counter++;
				}
			}
		}

		return cells;

	}

}
