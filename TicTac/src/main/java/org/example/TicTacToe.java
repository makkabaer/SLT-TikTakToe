package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    protected Board board;

    public TicTacToe() {
        //TicTacToe
    }

    public void start() {
        //die App starten
    }

    /*public? protected? oder package protected? */ void switchCurrentPlayer() {
        //X auf O, oder O auf X zu switchen
    }

    /*wieder dasselbe Problem*/ boolean hasWinner() {
        // if (dreiInSelbenZeile/Spalte/Diagonal)
        return true;
        //else return false;
    }
}
