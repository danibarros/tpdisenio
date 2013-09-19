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

import edu.organizador.controlador.Controlador;

public class UIPrincipal extends WindowAdapter {
	public int numWindows = 0;
	private Point lastLocation = null;
	private int maxX = 500;
	private int maxY = 500;
	JFrame frame;
	Controlador controlador;
	
	public UIPrincipal() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		maxX = 800;
		maxY = 600;
		JFrame frame = new Ventana(this);
		controlador = new Controlador(frame);
		Color c = new Color(112,173,208);
		Container con = frame.getContentPane();
		con.setBackground(c);
		ImageIcon icon = new ImageIcon(getClass().getResource("/presentacion.gif"));
		JLabel cartel = new JLabel(icon, JLabel.CENTER);
		frame.add(cartel);
		frame.setVisible(true);
		iniciarJuego();
		organizar();
	}

	public void iniciarJuego() {	 
		numWindows++;
		System.out.println("Number of windows: " + numWindows);
		controlador.iniciarJuego();
	}
	
	public void organizar() {	 
		numWindows++;
		System.out.println("Number of windows: " + numWindows);
		controlador.organizarNoches();
	}

}
