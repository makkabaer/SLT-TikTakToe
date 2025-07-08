package org.example;

import org.example.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    // isCellEmpty Tests
    @Test
    void testIsCellEmpty_shouldReturnTrue_whenCellIsEmpty() {
        Board board = new Board();
        assertTrue(board.isCellEmpty(0, 0));
    }

    @Test
    void testIsCellEmpty_shouldReturnFalse_whenCellIsOccupied() {
        Board board = new Board();
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
    }

    // place Tests
    @Test
    void testPlace_shouldPlaceMarker_whenCellIsEmpty() {
        Board board = new Board();
        board.place(0, 1, 'O');
        assertEquals('O', board.getCells()[0][1]);
    }

    @Test
    void testPlace_shouldNotOverwriteMarker_whenCellIsOccupied() {
        Board board = new Board();
        board.place(2, 2, 'X');
        board.place(2, 2, 'O');  // sollte nicht überschreiben
        assertEquals('X', board.getCells()[2][2]);
    }

    // isFull Tests
    @Test
    void testIsFull_shouldReturnTrue_whenAllCellsAreFilled() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void testIsFull_shouldReturnFalse_whenAtLeastOneCellIsEmpty() {
        Board board = new Board();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    board.place(i, j, 'O');
                }
            }
        }
        assertFalse(board.isFull());
    }

    // clear Tests
    @Test
    void testClear_shouldEmptyAllCells_afterBoardIsUsed() {
        Board board = new Board();
        board.place(0, 0, 'X');
        board.place(2, 2, 'O');
        board.clear();
        assertTrue(board.isCellEmpty(0, 0));
        assertTrue(board.isCellEmpty(2, 2));
    }

    @Test
    void testClear_shouldNotLeaveNonEmptyCells_afterClearCalled() {
        Board board = new Board();
        board.place(1, 1, 'X');
        board.clear();
        assertNotEquals('X', board.getCells()[1][1]);
    }

    // getCells (indirekt getestet über andere Methoden)
    @Test
    void testGetCells_shouldReturnCorrectArrayReference() {
        Board board = new Board();
        board.place(0, 0, 'X');
        char[][] cells = board.getCells();
        assertEquals('X', cells[0][0]);
    }

    @Test
    void testGetCells_shouldNotReturnNull() {
        Board board = new Board();
        assertNotNull(board.getCells());
    }
}