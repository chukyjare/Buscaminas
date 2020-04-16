package Control;

import model.Coordenada;
import model.Tablero;
import vista.Botonera;

public class MarcadorController {

	Tablero tablero;

	// Sirve para marcar/desmarcar casillas
	// Por lo tanto desaparece DesmarcadorController
	public boolean marcarCasilla(String marca) {
		Coordenada coord = Botonera.obtenCoordenada(marca);
		return tablero.marcarCasilla(coord);
	}

	public MarcadorController(Tablero tablero) {
		super();
		this.tablero = tablero;
	}
	
}
