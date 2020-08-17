package boardgame;

public class Board {
	
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	
	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardException("Erro ao criar tabuleiro: deve haver pelo menos 1 linha e 1 coluna.");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	
	
	public int getRows() {
		return rows;
	}


	public int getColumns() {
		return columns;
	}


	public Piece piece(int row, int column) {
		if (!this.positionExists(row, column)) {
			throw new BoardException("Posi��o inv�lida.");
		} return pieces[row][column];
	}
	
	
	public Piece piece(Position position) {
		if (!this.positionExists(position)) {
			throw new BoardException("Posi��o inv�lida.");
		} return pieces[position.getRow()][position.getColumn()];
	}
	
	
	public void placePiece(Piece piece, Position position) {
		if (this.thereIsAPiece(position)) {
			throw new BoardException("J� existe uma pe�a na posi��o " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	
	public boolean positionExists(Position position) {
		return this.positionExists(position.getRow(), position.getColumn());
	}
	
	
	private boolean positionExists(int row, int column) {
		return ((row >=0 && row < rows) && (column >=0 && column < columns));
	}
	
	
	public boolean thereIsAPiece(Position position) {
		if (!this.positionExists(position)) {
			throw new BoardException("Posi��o inv�lida.");
		} return (this.piece(position) != null);
	}
	
}
