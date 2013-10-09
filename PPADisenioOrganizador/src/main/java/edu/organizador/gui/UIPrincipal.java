package edu.organizador.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.core.entities.Festival;
import edu.organizador.controlador.Controlador;

public class UIPrincipal extends WindowAdapter {
	public int numWindows = 0;
	JFrame frame;
	Controlador controlador;
	
	public UIPrincipal() {
		
		JFrame frame = new Ventana(this);
		controlador = new Controlador(frame);
		Container con = frame.getContentPane();
		con.setBackground(new Color(112,173,208));
		ImageIcon icon = new ImageIcon(getClass().getResource("/presentacion.gif"));
		JLabel cartel = new JLabel(icon, JLabel.CENTER);
	
		frame.add(cartel);
		frame.setSize(800,600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		
		logIn();
		Festival nuevoFestival = iniciarJuego();
		organizar(nuevoFestival);
	}
	
	public void logIn(){
		controlador.logIn();
	}

	public Festival iniciarJuego() {	 
		numWindows++;
		System.out.println("Number of windows: " + numWindows);
		return controlador.iniciarJuego();
	}
	
	public void organizar(Festival nuevoFestival) {	 
		numWindows++;
		System.out.println("Number of windows: " + numWindows);
		controlador.organizarNoches(nuevoFestival);
	}

}
