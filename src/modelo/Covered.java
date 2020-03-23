package modelo;

public class Covered extends Square {

	private boolean mark = false;
	private boolean covered = true;

	/**
	 * 
	 * @param x
	 * @param y
	 * @param checked
	 * @param bomb
	 * @param mark   Nos indica si una casilla VELADA tiene una marca o no, la
	 *                marca es lo que usa el usuario cuando "sospecha" que puede
	 *                haber una bomba en la casilla
	 * @param covered  Las Casillas por defecto se crean veladas y es el usuario el
	 *                que durante el juego las desvela, por esto velada se inicia en
	 *                true, la casilla pasará a ser desvelada cuando sea NO velada,
	 *                es decir, cuando velada sea false
	 */

	public Covered(int x, int y, boolean checked, boolean bomb, boolean mark, boolean covered) {
		super(x, y, checked, bomb);
		if (covered) {
			this.mark = mark;
			this.covered = covered;

		}
	}

	public boolean isMark() {
		return mark;
	}

	public void setMark(boolean mark) {
		this.mark = mark;
	}

	public boolean isCovered() {
		return covered;
	}
	/*
	 *Este método hace que una casilla velada pase a ser desvelada, porque esta deja de ser velada, es decir, es descubierta. 
	 */
	public void discoverSquare() {
		this.covered = false;
	}

}
