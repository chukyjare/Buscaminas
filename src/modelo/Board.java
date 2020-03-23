package modelo;

public class Board {
	private int dimension;
	private int numberBombs;
	private Square[][] board;
	private Difficulty difficulty;
	private Density density;
	private Coordinate coordinate;


	public Board(int dimension, int numberBombs, Square[][] board) {
		super();
		this.dimension = difficulty.getLevel();
		this.numberBombs = (int) ((density.getLevel() / (dimension * dimension))) * 100;
		this.board = new Square[dimension][dimension];
	}

	public int getDimension() {
		return dimension;
	}

	public int getNumberBombs() {
		return numberBombs;
	}

	public Square[][] getBoard() {
		return board;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public Density getDensity() {
		return density;
	}
	public Coordinate getCoordinate() {
		return coordinate;
	}
	
	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

}
