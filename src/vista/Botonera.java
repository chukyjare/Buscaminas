package vista;

import java.awt.Component;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import Control.MiMouseListener;
import model.Coordenada;
import model.Tablero;
import Control.DesveladorController;
import Control.MarcadorController;

public class Botonera extends JPanel {
	MiMouseListener miListener;
	private MarcadorController marcarCasilla;
	private DesveladorController desveladorController;
//	private TableroWinController tableroWinLose;

	public Botonera(int lado, MiMouseListener miListener, Tablero tablero) {
		this.marcarCasilla = new MarcadorController(tablero);
		this.desveladorController = new DesveladorController(tablero);
//		this.tableroWinLose = new TableroWinController(tablero);
		this.miListener = miListener;
		// TODO el nombre para cuando hay mas de 10 de lado.
		// debe ser de dos digitos por coordenada aunque el valor<10
		// es decir la coordenada 6:11 debe ser 06:11, por ejemplo.
		setLayout(new GridLayout(lado, lado, 0, 0));
		for (int filas = 0; filas < lado; filas++) {
			for (int columnas = 0; columnas < lado; columnas++) {
				JButton boton = new JButton();
				String nombre = Integer.toString(filas) + Integer.toString(columnas);
				boton.setName(nombre);
				add(boton);
				boton.addMouseListener(miListener);
			}
		}
	}

	public void actualizaBotonera(ElementoGrafico[][] elementos) {
		Component[] components = getComponents();
		for (int i = 0; i < components.length; i++) {
			JButton boton = (JButton)components[i];
			Coordenada coordenada=obtenCoordenada(boton.getName());
			ElementoGrafico elementoGrafico = elementos[coordenada.getPosX()][coordenada.getPosY()];
			if(!elementoGrafico.isOcultado()) {
				boton.setText(String.valueOf(elementoGrafico.getValor()));
			}else if(elementoGrafico.isSenalada()){
				boton.setText("X");
			}else {
				boton.setText("");
			}
		}
	}
	public static Coordenada obtenCoordenada(String name) {
		int pos = name.length() / 2;
		return new Coordenada(Integer.valueOf(name.substring(0, pos)),
				Integer.valueOf(name.substring(pos, name.length())));
	}

}
