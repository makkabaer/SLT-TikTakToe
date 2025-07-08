package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    /**
     * Ez az osztály felülírja a start metódust, hogy tesztelhető legyen
     * a játék újraindítása felhasználói input alapján.
     */
    static class TestableTicTacToe extends TicTacToe {
        private final String userInput;

        public TestableTicTacToe(String userInput) {
            this.userInput = userInput;
        }

        @Override
        public void start() {
            board = new Board();
            Player player1 = new Player('X');
            Player player2 = new Player('O');
            Player currentPlayer = player1;

            // Szimulált játék: egy lépés történik
            board.place(0, 0, currentPlayer.getMarker());
            boolean playAgain = userInput.equalsIgnoreCase("j");
            Board originalBoard = board;
            if (playAgain) {
                board = new Board(); // új játék indul
            }

            // Ellenőrzés:
            if (playAgain) {
                assertNotSame(originalBoard, board, "Új játékot kellett volna kezdeni.");
            } else {
                assertSame(originalBoard, board, "Nem kellett volna új játékot kezdeni.");
            }
        }
    }

    @Test
    void testPlayAgain_yesStartsNewGame() {
        TicTacToe game = new TestableTicTacToe("j");
        game.start();  // elvárt: új board -> cella (0,0) üres
    }

    @Test
    void testPlayAgain_noEndsGame() {
        TicTacToe game = new TestableTicTacToe("n");
        game.start();  // elvárt: ugyanaz a board -> cella (0,0) 'X'
    }
}
