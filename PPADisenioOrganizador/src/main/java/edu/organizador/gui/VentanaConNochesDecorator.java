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

import edu.core.entities.Noche;

public class VentanaConNochesDecorator implements VentanaDecoratorInterface,
		ActionListener {

	private List<Noche> noches = new ArrayList<Noche>();
	private int noche;
	private boolean pause = true;
	private JComboBox<String> comboNoches = new JComboBox<String>();
	private VentanaNocheDecorator ventana = new VentanaNocheDecorator();
	private JFrame frame;
	private JPanel panel;

	public VentanaConNochesDecorator(int cantNoches, JFrame frame) {
		int i;
		this.frame = frame;
		for(i=0;i<cantNoches;i++){
			Noche noche = new Noche();
			noches.add(noche);
			noche.setNumero(i + 1);
			comboNoches.addItem(String.valueOf(noche.getNumero()));	
		}
	}

	@Override
	public void dibujar() {

	}

	public void seleccionarNoches() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		JPanel panel = new JPanel();
		frame.getContentPane().removeAll();
		frame.add(panel, BorderLayout.NORTH);

		comboNoches.setName("cmbNoches");
		comboNoches.addActionListener(this);

		panel.setSize(comboNoches.getWidth(), comboNoches.getHeight());
		frame.setSize(800, 600);
		
		panel.add(new JLabel("Elija la noche que desea organizar"));
		panel.add(comboNoches);
		frame.setVisible(true);
		panel.setVisible(true);
		ventana.formularioNoche(noches.get(Integer.valueOf(comboNoches.getSelectedItem().toString()) - 1 ),frame);
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
		case "comboBoxChanged":
			JComboBox cb = (JComboBox) e.getSource();
			if (cb.getName().equalsIgnoreCase("cmbNoches")) {
				String newSelection = (String) cb.getSelectedItem();
				noche = Integer.valueOf(newSelection);
				ventana.formularioNoche(noches.get(noche -1),frame);
			}
			break;
		default:
			break;
		}

	}

}
