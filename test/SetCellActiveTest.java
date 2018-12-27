import ColorFlood.Board;
import ColorFlood.Cell;
import org.testng.annotations.Test;

import java.awt.*;

import static org.testng.Assert.*;

public class SetCellActiveTest
{
	@Test
	public void checkTopCell()
	{
		//given
		Board board = new Board(2,2);
		board.gameBoard[0][0] = new Cell(0, 0, Color.RED);
		board.gameBoard[1][0] = new Cell(1, 0, Color.BLUE);

		//when
		board.gameBoard[0][0].setActive(true);
		board.flood(Color.RED);

		//then
		assertTrue(board.gameBoard[1][0].getColor() == Color.RED);
	}
}