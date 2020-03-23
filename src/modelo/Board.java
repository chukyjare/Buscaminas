package modelo;

public class Board {
	private int dimension;
	private int numberBombs;
	private Square[][] board;
	private Difficulty difficulty;
	private Density density;

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

}
