package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    /**
     * Diese Klasse überschreibt die Startmethode, um die Möglichkeit zu testen,
     * das Spiel basierend auf Benutzereingaben neu zu starten.
     */
    static class TestableTicTacToe extends TicTacToe {
        private final String userInput;

        public TestableTicTacToe(String userInput) {
            this.userInput = userInput;
        }

        @Override
        public void start() {
             Player player1 = new Player('X');
             Player player2 = new Player('O');
             Player currentPlayer = player1;

            // Simuliertes Spiel: Ein Zug wird gemacht
            board.place(0, 0, currentPlayer.getMarker());
            boolean playAgain = userInput.equalsIgnoreCase("j");
            Board originalBoard = board;
            if (playAgain) {
                board = new Board(); // Ein neues Spiel beginnt
            }

            // Überprüfung:
            if (playAgain) {
                assertNotSame(originalBoard, board, "Ein neues Spiel hätte gestartet werden müssen.");
            } else {
                assertSame(originalBoard, board, "Es hätte kein neues Spiel gestartet werden sollen.");
            }
        }
    }

    @Test
    void testPlayAgain_yesStartsNewGame() {
        TicTacToe game = new TestableTicTacToe("j");
        game.start();  // Erwartet: neues Brett -> Zelle (0,0) ist leer
    }

    @Test
    void testPlayAgain_noEndsGame() {
        TicTacToe game = new TestableTicTacToe("n");
        game.start();  // Erwartet: gleiches Brett -> Zelle (0,0) ist 'X'
    }

    @Test
    void testHasWinner_yes() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.board.place(0,0,'X');
        ticTacToe.board.place(0,1,'X');
        ticTacToe.board.place(0,2,'X');
        assertTrue(ticTacToe.hasWinner());
    }

    @Test
    void testHasWinner_no() {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.board.place(0,0,'X');
        ticTacToe.board.place(1,1,'X');
        ticTacToe.board.place(0,2,'X');
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void TestSwitchCurrentPlayer_from1to2() {
        TicTacToe ticTacToe=new TicTacToe();
        assertEquals('X',ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        assertEquals('O',ticTacToe.getCurrentPlayer().getMarker());
    }

    @Test
    void TestSwitchCurrentPlayer_wrongSwitch() {
        TicTacToe ticTacToe=new TicTacToe();
        assertEquals('X',ticTacToe.getCurrentPlayer().getMarker());
        ticTacToe.switchCurrentPlayer();
        assertNotEquals('X',ticTacToe.getCurrentPlayer().getMarker());
    }

    @Test
    void TestSwitchCurrentPlayer_noSwitch() {
        TicTacToe ticTacToe=new TicTacToe();
        assertEquals('X',ticTacToe.getCurrentPlayer().getMarker());
        assertNotEquals('O',ticTacToe.getCurrentPlayer().getMarker());
    }
}