package modelo;

public class Square extends Coordinate {

	private boolean checked = getRandomBoolean();
	private boolean bomb = setChangeBoolean(checked);

	/**
	 * 
	 * @param x       Eje X
	 * @param y       Eje Y De la Casilla que vamos a crear, por lo tanto
	 *                necesitamos que la casilla herede de Coordenada
	 * @param checked Nos indica si la casilla es Marcada, con marcada en este caso
	 *                nos referimos a que nos marca el número de bombas que le rodea
	 * @param bomb   Nos indica si la casilla es bomba, Las casillas pueden ser o
	 *                marcadas, o bombas, pero no ambas a la vez
	 */
	public Square(int x, int y, boolean checked, boolean bomb) {
		super(x, y);
		this.checked = checked;
		this.bomb = bomb;
	}

	public boolean isChecked() {
		return checked;
	}

	public boolean isBomb() {
		return bomb;
	}
	/**
	 * 
	 * @param random Entramos por parámetro un booleano al que le vamos a cambiar el valor
	 * @return
	 */
	public boolean setChangeBoolean(boolean random) {
		if (random) {
			random = false;
		} else {
			random = true;
		}
		return random;
	}
	/**
	 * 
	 * @return Retorna un booleano aleatorio
	 */
	public boolean getRandomBoolean() {
		boolean random = false;
		int duplicate = 2;
		if ((int) (Math.random() * duplicate) == 0) {
			random = true;
		}
		return random;
	}
}
