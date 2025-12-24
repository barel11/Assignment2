package XO;

public abstract class Game {

	public enum Player {
		X, O
	}

	private char[][] gameBoard = new char[5][5];
	private Player currentTurn = Player.X;
	private boolean gameOver = false;
	private int filledCells = 0;

	public Game() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				gameBoard[i][j] = ' ';
			}
		}
	}

	public synchronized void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 5; i++) {
			System.out.print("| ");
			for (int j = 0; j < 5; j++) {
				System.out.print(gameBoard[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("-------------");
	}

	public synchronized Player getTurn() {
		return currentTurn;
	}

	public synchronized boolean isGameOver() {
		return gameOver;
	}

	public synchronized boolean makeMove(int row, int col, Player player) {

		if (gameOver || gameBoard[row][col] != ' ' || player != currentTurn) {
			return false;
		}

		char s = (player == Player.X) ? 'X' : 'O';
		gameBoard[row][col] = s;
		
		filledCells++;
		
		System.out.println("Player " + player + " move: (" + row + "," + col + ")");
		printBoard();

		if (checkWin(s)) {
			System.out.println("WINNER: " + player);
			gameOver = true;
		} else if (getFreeCells().length == 0) {
			System.out.println("Board is full");
			gameOver = true;
		} else {
			currentTurn = (currentTurn == Player.X) ? Player.O : Player.X;
		}

		return true;
	}

	private boolean checkWin(char s) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				// בדיקת שורה
				if (j <= 1 && gameBoard[i][j] == s && gameBoard[i][j + 1] == s && gameBoard[i][j + 2] == s
						&& gameBoard[i][j + 3] == s)
					return true;

				// בדיקת עמודה 
				if (i <= 1 && gameBoard[i][j] == s && gameBoard[i + 1][j] == s && gameBoard[i + 2][j] == s
						&& gameBoard[i + 3][j] == s)
					return true;

				// בדיקת אלכסון ראשי
				if (i <= 1 && j <= 1 && gameBoard[i][j] == s && gameBoard[i + 1][j + 1] == s
						&& gameBoard[i + 2][j + 2] == s && gameBoard[i + 3][j + 3] == s)
					return true;

				// בדיקת אלכסון משני 
				if (i <= 1 && j >= 3 && gameBoard[i][j] == s && gameBoard[i + 1][j - 1] == s
						&& gameBoard[i + 2][j - 2] == s && gameBoard[i + 3][j - 3] == s)
					return true;
			}
		}
		return false;
	}

	public synchronized Cells[] getFreeCells() {
		int count = 25 - filledCells;
		Cells[] cells = new Cells[count];
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (gameBoard[i][j] == ' ') {
					cells[idx++] = new Cells(i, j);
				}
			}
		}
		return cells;
	}

}
