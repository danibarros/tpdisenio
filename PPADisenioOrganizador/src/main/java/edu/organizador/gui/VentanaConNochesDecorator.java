package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.core.entities.Butaca;
import edu.core.entities.Estadio;
import edu.core.entities.Noche;
import edu.core.entities.Sector;

public class VentanaConNochesDecorator implements VentanaDecoratorInterface,
		ActionListener {

	private List<Noche> noches = new ArrayList<Noche>();
	private int noche;
	private boolean pause = true;
	private JComboBox<String> comboNoches = new JComboBox<String>();
	JFrame frame;
	JPanel panel;

	public VentanaConNochesDecorator(int cantNoches) {
		int i;
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

	public void seleccionarNoches(JFrame frame) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		this.frame = frame;
		panel = new JPanel();
		JPanel pnlBottom = new JPanel();
		frame.getContentPane().removeAll();
		frame.add(panel, BorderLayout.NORTH);
		frame.add(pnlBottom, BorderLayout.SOUTH);

		comboNoches.setName("cmbNoches");
		comboNoches.addActionListener(this);

		panel.setSize(comboNoches.getWidth(), comboNoches.getHeight());
		pnlBottom.setSize(comboNoches.getWidth(), comboNoches.getHeight());
		frame.setSize(800, 600);

		panel.add(comboNoches);
		frame.setVisible(true);
		panel.setVisible(true);
		pnlBottom.setVisible(true);
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
				VentanaNocheDecorator ventana = new VentanaNocheDecorator();
				ventana.formularioNoche(noches.get(noche -1),frame);
			}
			break;
		case "Comprar entradas":
			JButton btn = (JButton) e.getSource();
			pause = false;
			break;
		default:
			break;
		}

	}

}
