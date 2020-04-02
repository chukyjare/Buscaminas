package model;

import utiles.Utiles;

public class Tablero {

	private Casilla[][] casillas;
	private int lado;

	public Tablero(int lado, int numeroBombas) {
		super();
		crearTablero(lado);
		colocarMinas(lado, numeroBombas);
		this.lado=lado;
	}

	public int getLado() {
		return lado;
	}

	private void establecerMinasAlrededor(int lado, Coordenada posicionMinaCoordenada) {
		int i = posicionMinaCoordenada.getPosY();
		int j = posicionMinaCoordenada.getPosX();

		int limite = lado - 1;
		if (i < limite) {
			enumerarContigua(i + 1, j);
			if (j < limite) {
				enumerarContigua(i + 1, j + 1);
			}
			if (j != 0) {
				enumerarContigua(i + 1, j - 1);
			}
		}
		if (j < limite) {
			enumerarContigua(i, j + 1);
		}
		if (j!=0) {
			enumerarContigua(i, j-1);
		}
		if (i != 0) {
			enumerarContigua(i - 1, j);
			if (j < limite) {
				enumerarContigua(i - 1, j + 1);
			}
			if (j != 0) {
				enumerarContigua(i - 1, j - 1);
			}
		}
	}

	private void enumerarContigua(int i, int j) {
		Coordenada posicionContigua;
		posicionContigua = new Coordenada(i, j);
		int numBombas = getCasilla(posicionContigua).getMinasAlrededor();
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
	
	public boolean marcarCasilla(Coordenada coord) {
		return getCasilla(coord).marcar();
	}

	public void desvelarCasilla(Coordenada coordenada, int lado) {
		int alrededor=8;
		 Casilla casilla= getCasilla(coordenada);
		if (casilla.getMinasAlrededor()==0 && ((!casilla.isMina()) && casilla.isVelada()) && (!casilla.isMarcada())) {
			casilla.desVelar();
			for (int i = 0; i < alrededor; i++) {
				Coordenada coordContigua= coordenada.creaNuevaAlrededor(i);
				if (verificarEsquinas(coordContigua, lado)) {
					desvelarCasilla(coordContigua, lado);
				}
			}
		}else {
			if (!casilla.isMarcada()) {
				casilla.desVelar();
			}
		}
	}

	private boolean verificarEsquinas(Coordenada coordContigua, int lado) {
		boolean retorno=true;
		int j=coordContigua.getPosX();
		int i=coordContigua.getPosY();
		int limite = lado-1;
		if ((j==0 && i==0) || (j==0 && i==limite) || (j==limite && i==limite) || (j==(limite) && i==0)) {
			retorno=false;
		}
		return retorno;
	}

}
