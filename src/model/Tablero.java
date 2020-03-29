package model;

import utiles.Utiles;

public class Tablero {

	private Casilla[][] casillas;

	public Tablero(int lado, int numeroBombas) {
		super();
		crearTablero(lado);
		colocarMinas(lado, numeroBombas);
	}

	private void establecerMinasAlrededor(int lado, Coordenada posicionMinaCoordenada) {
		int i = posicionMinaCoordenada.getPosY();
		int j = posicionMinaCoordenada.getPosX();

		if (i < (lado - 1)) {
			enumerarContigua(i + 1, j);
			if (j < (lado - 1)) {
				enumerarContigua(i + 1, j + 1);
			}
			if (j != 0) {
				enumerarContigua(i + 1, j - 1);
			}
		}
		if (j < (lado - 1)) {
			enumerarContigua(i, j + 1);
		}
		if (j!=0) {
			enumerarContigua(i, j-1);
		}
		if (i != 0) {
			enumerarContigua(i - 1, j);
			if (j < (lado - 1)) {
				enumerarContigua(i - 1, j + 1);
			}
			if (j != 0) {
				enumerarContigua(i - 1, j - 1);
			}
		}
	}

	private void enumerarContigua(int i, int j) {
		Coordenada posicionContigua;
		int numBombas;
		posicionContigua = new Coordenada(i, j);
		numBombas = getCasilla(posicionContigua).getMinasAlrededor();
		getCasilla(posicionContigua).setMinasAlrededor(numBombas++);
	}

	private void colocarMinas(int lado, int numeroBombas) {
		Coordenada posicionMinaCoordenada;
		for (int i = 0; i < numeroBombas; i++) {
			do {
				posicionMinaCoordenada = new Coordenada(Utiles.dameNumero(lado - 1), Utiles.dameNumero(lado - 1));
			} while (isMina(posicionMinaCoordenada));
			setMina(posicionMinaCoordenada, true);
			establecerMinasAlrededor(lado, posicionMinaCoordenada);
		}
	}

	private void crearTablero(int lado) {
		this.casillas = new Casilla[lado][lado];
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				casillas[i][j] = new Casilla();
			}
		}
	}

	// TODO antes todo esto era private
	public Casilla getCasilla(Coordenada posicion) {
		return casillas[posicion.getPosX()][posicion.getPosY()];
	}

	public Casilla[][] getCasillas() {
		return casillas;
	}

	public void setCasillas(Casilla[][] casillas) {
		this.casillas = casillas;
	}

	private void setMina(Coordenada posicion, boolean bandera) {
		getCasilla(posicion).setMina(bandera);
	}

	private boolean isMina(Coordenada posicion) {
		return getCasilla(posicion).isMina();
	}

	public void desvelarCasilla(Coordenada coordenada) {
		getCasilla(coordenada).setVelada(false);
	}

}
