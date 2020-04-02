package Control;

import model.Coordenada;
import model.Tablero;

public class MarcadorController {

	Tablero tablero;

	// Sirve para marcar/desmarcar casillas
	// Por lo tanto desaparece DesmarcadorController
	public boolean marcarCasilla(Coordenada coord) {
		return tablero.marcarCasilla(coord);
	}

	public MarcadorController(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
}
