package src.ColorFlood;

import java.awt.*;
import java.util.Random;

public class Board {

    private Cell[][] gameBoard;
    private final int GAME_COLS;
    private final int GAME_ROWS;
    private Color[] gameColors;

    private int activeCells;

    public Board(int GAME_COLS, int GAME_ROWS) {
        this.GAME_COLS = GAME_COLS;
        this.GAME_ROWS = GAME_ROWS;
        Colors gameColors = new Colors();
        this.gameColors = gameColors.getColors();
        createGameBoard();
    }

    private void createGameBoard() {
        Random random = new Random();
        int cellColor;
        gameBoard = new Cell[GAME_COLS][GAME_ROWS];
        for (int col = 0; col < GAME_COLS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                cellColor = random.nextInt(gameColors.length - 1);
                Cell cell = new Cell(col, row, gameColors[cellColor]);
            }
        }
    }

    private Cell startCell() {
        //get start cell from user click
        //mark active
        //iterate active cells
        return null;
    }

    private void findAdjoiningCells(Color color){
        for (int col = 0; col < GAME_COLS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                Cell cell = gameBoard [col][row];
                if (cell.isActive()){
                    //check for neighbors of search color and activate
                    //iterate active cells
                }
            }

        }
    }

    private void colorActiveCells(Color color){
        for (int col = 0; col < GAME_COLS; col++) {
            for (int row = 0; row < GAME_ROWS; row++) {
                Cell cell = gameBoard [col][row];
                if (cell.isActive()){
                    cell.setColor(color);
                }
            }
        }
    }

    private boolean gameOver() {
        return (GAME_COLS * GAME_ROWS) == activeCells || timesUp();
    }

    private boolean timesUp() {
        //if timer = 0
        return false;
    }
}
