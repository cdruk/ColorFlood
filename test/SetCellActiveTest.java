import ColorFlood.Board;
import ColorFlood.Cell;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetCellActiveTest
{
	@Test
	public void checkRightCellChangeColor()
	{
		//given
		Board board = new Board(2,1);
		board.gameBoard[0][0] = new Cell(0, 0, Color.RED);
		board.gameBoard[1][0] = new Cell(1, 0, Color.BLUE);

		//when
		board.selectedColor = Color.BLUE;
		board.gameBoard[0][0].setActive(true);
		board.flood();

		//then
		assertTrue(board.gameBoard[0][0].getColor() == Color.BLUE);
	}

	@Test
	public void checkRightCellNotChangeColor()
	{
		//given
		Board board = new Board(2,1);
		board.gameBoard[0][0] = new Cell(0, 0, Color.RED);
		board.gameBoard[1][0] = new Cell(1, 0, Color.BLUE);

		//when
		board.selectedColor = Color.RED;
		board.gameBoard[0][0].setActive(true);
		board.flood();

		//then
		assertFalse(board.gameBoard[1][0].getColor() == Color.RED);
	}

	@Test
	public void checkTwoNeighborsChangeColor()
	{
		//given
		Board board = new Board(2,2);
		board.gameBoard[0][0] = new Cell(0, 0, Color.RED);
		board.gameBoard[1][0] = new Cell(1, 0, Color.YELLOW);
		board.gameBoard[0][1] = new Cell(0, 1, Color.BLUE);
		board.gameBoard[1][1] = new Cell(1, 1, Color.BLUE);

		//when
		board.selectedColor = Color.BLUE;
		board.gameBoard[0][0].setActive(true);
		board.flood();

		//then
		assertTrue(board.gameBoard[1][1].getColor() == Color.BLUE);
	}

	@Test
	public void checkDiagonalNotChangeColor()
	{
		//given
		Board board = new Board(2,2);
		board.gameBoard[0][0] = new Cell(0, 0, Color.RED);
		board.gameBoard[1][0] = new Cell(1, 0, Color.BLUE);
		board.gameBoard[0][1] = new Cell(0, 1, Color.BLUE);
		board.gameBoard[1][1] = new Cell(1, 1, Color.YELLOW);

		//when
		board.selectedColor = Color.YELLOW;
		board.gameBoard[0][0].setActive(true);
		board.flood();

		//then
		assertTrue(board.gameBoard[0][0].getColor() == Color.YELLOW);
	}

	@Test
	public void checkMultipleActiveCells()
	{
		//given
		Board board = new Board(3,3);
		board.gameBoard[0][0] = new Cell(0, 0, Color.RED);
		board.gameBoard[1][0] = new Cell(1, 0, Color.RED);
		board.gameBoard[2][0] = new Cell(2, 0, Color.RED);
		board.gameBoard[0][1] = new Cell(0, 1, Color.YELLOW);
		board.gameBoard[1][1] = new Cell(1, 1, Color.YELLOW);
		board.gameBoard[2][1] = new Cell(2, 1, Color.YELLOW);
		board.gameBoard[0][2] = new Cell(0, 2, Color.YELLOW);
		board.gameBoard[1][2] = new Cell(1, 2, Color.BLUE);
		board.gameBoard[2][2] = new Cell(2, 2, Color.BLUE);

		//when
		board.selectedColor = Color.YELLOW;
		board.gameBoard[0][0].setActive(true);
		board.gameBoard[1][0].setActive(true);
		board.gameBoard[2][0].setActive(true);
		board.flood();

		//then
		assertTrue(board.gameBoard[0][0].getColor() == Color.YELLOW);
		assertTrue(board.gameBoard[1][0].getColor() == Color.YELLOW);
		assertTrue(board.gameBoard[2][0].getColor() == Color.YELLOW);
	}
}