package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Casilla;
import model.Coordenada;
import model.Tablero;
import utiles.Utiles;

class TableroTest {
	private int lado;
	private int porcentaje;
	private int minas;
	private Tablero tablero;

	@BeforeEach
	void setUp() {
		lado = 4;
		porcentaje = 10;
		minas = Utiles.calculaMinas(lado, porcentaje);
		tablero = new Tablero(lado, minas);
	}

	@Test
	void testTableroColocarMinas() {
		int contadorMinas = 0;
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				if (tablero.getCasilla(new Coordenada(i, j)).isMina()) {
					contadorMinas++;
				}
			}
		}
		assertEquals(minas, contadorMinas);
	}
	
	@Test
	void testDesvelarCasilla() {
		Casilla uno = new Casilla();
		uno.setMinasAlrededor( 1);
		Casilla cero = new Casilla();
		cero.setMinasAlrededor(0);;
		Casilla[][] base = {{cero,cero,cero,cero,cero},
							{uno,uno,cero,  uno,   uno},
							{cero,uno,cero, uno,  cero},
							{uno,uno,cero,  uno,   uno},
							{cero,cero,cero,cero,cero},
							
		};
		Casilla unoD = new Casilla();
		unoD.setMinasAlrededor( 1);
		unoD.setVelada(false);;
		Casilla ceroD = new Casilla();
		ceroD.setMinasAlrededor(0);
		ceroD.setVelada(false);;
		Casilla[][] resultado = {{ceroD,ceroD,ceroD,ceroD,ceroD},
								{unoD,unoD,ceroD,  unoD,   unoD},
								{cero,unoD,ceroD, unoD,  cero},
								{unoD,unoD,ceroD,  unoD,   unoD},
								{ceroD,ceroD,ceroD,ceroD,ceroD},
								
};
		Tablero base1 = new Tablero(base);
		Tablero resulta = new Tablero(resultado);
		
		base1.desvelarCasilla(new Coordenada(2, 2), lado);
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				assertTrue(base1.getCasillas()[i][j].isVelada()==resulta.getCasillas()[i][j].isVelada());
			}
		}
	}

	@Test
	void testTableroIncrementaMinas() {
		for (int i = 0; i < lado; i++) {
			for (int j = 0; j < lado; j++) {
				Coordenada posicion = new Coordenada(i, j);
				Casilla actual = tablero.getCasilla(posicion);
				int minasAlrededor = actual.getMinasAlrededor();
				// necesito algo que cuente las minas aldedor
				assertEquals(minasAlrededor, contarMinasAlrededor(tablero, posicion));
			}
		}
	}

	// Deberia probar este codigo
	private int contarMinasAlrededor(Tablero tablero, Coordenada posicion) {
		int bombasAlrededor = 0;
		int x = posicion.getPosX();
		int y = posicion.getPosY();
		for (int i = x - 1; i < x + 1; i++) {
			for (int j = y - 1; j < y + 1; j++) {
				Coordenada alrededor = new Coordenada(i, j);
				// No tengo en cuenta la posicion que estoy comprobando
				if (!alrededor.equals(posicion)) {
					if (isDentroLimites(alrededor, lado) && tablero.getCasilla(alrededor).isMina()) {
						bombasAlrededor++;
					}
				}
			}
		}
		return bombasAlrededor;
	}

	private boolean isDentroLimites(Coordenada alrededor, int lado) {
		return alrededor.getPosX() >= 0 && alrededor.getPosX() < lado && alrededor.getPosY() >= 0
				&& alrededor.getPosY() < lado;
	}
}
