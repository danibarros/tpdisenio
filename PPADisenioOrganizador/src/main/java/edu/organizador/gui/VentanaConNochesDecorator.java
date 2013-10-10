package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.core.entities.Festival;
import edu.core.entities.Noche;

public class VentanaConNochesDecorator implements VentanaDecoratorInterface,
		ActionListener {

	private List<Noche> noches = new ArrayList<Noche>();
	private boolean pause = true;
	private JComboBox<String> comboNoches ;
	private VentanaNocheDecorator ventana;
	private JFrame frame;

//	public VentanaConNochesDecorator(int cantNoches, JFrame frame) {
//		int i;
//		this.frame = frame;
//		for(i=0;i<cantNoches;i++){
//			Noche noche = new Noche();
//			noches.add(noche);
//			noche.setNumero(i + 1);
//			comboNoches.addItem(String.valueOf(noche.getNumero()));	
//		}
//	}
	
	public VentanaConNochesDecorator(Festival nuevoFestival, JFrame frame) {
		this.frame = frame;
		this.comboNoches = new JComboBox<String>();
		this.ventana = new VentanaNocheDecorator();
		this.noches = nuevoFestival.getNoches();
		for (Noche noche : noches) {
			comboNoches.addItem(noche.getFecha().toString());
		}
		this.comboNoches.setActionCommand("Noche Seleccionada");
	}

	@Override
	public void dibujar() {

	}

	public void seleccionarNoches() {
		
		frame.getContentPane().removeAll();
		
		comboNoches.setName("cmbNoches");
		comboNoches.addActionListener(this);
		
		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setSize(comboNoches.getWidth(), comboNoches.getHeight());
		pnlPrincipal.add(new JLabel("Elija la noche que desea organizar"));
		pnlPrincipal.add(comboNoches);
		pnlPrincipal.setVisible(true);		 

		frame.add(pnlPrincipal, BorderLayout.NORTH);
		frame.setSize(800,600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);

		ventana.formularioNoche(noches.get(comboNoches.getSelectedIndex()),frame);
		
		while (pause) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		frame.getContentPane().removeAll();
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String event = e.getActionCommand();
		switch (event) {
		case "Noche Seleccionada":
				ventana.formularioNoche(noches.get(comboNoches.getSelectedIndex()),frame);
			break;
		default:
			break;
		}

	}

}
