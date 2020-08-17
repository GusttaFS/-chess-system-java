package boardgame;

public class Piece {
	
	protected Position position;
	private Board board;
	
	
	public Piece(Board board) {
		// Piece criada tera position inicial nulo.
		this.board = board;
	}
	
	
	protected Board getBoard() {
		return board;
	}
	
	
}
