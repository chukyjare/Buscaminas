package Control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;

import model.Coordenada;
import utiles.ConversorGrafico;
import vista.Botonera;

public class MiMouseListener extends MouseAdapter{
	private DesveladorController desveladorController;



	public MiMouseListener(DesveladorController desveladorController) {
		super();
		this.desveladorController = desveladorController;
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		JButton boton = ((JButton) e.getSource());
		
		if(SwingUtilities.isLeftMouseButton(e)) {
			desveladorController.desvelarCasilla(boton.getName());
		}
		if (SwingUtilities.isRightMouseButton(e)) {
			// queremos marcar
		}
		Botonera botonera=((Botonera)boton.getParent());
		botonera.actualizaBotonera(desveladorController.getEntornoGrafico());
	}
}
