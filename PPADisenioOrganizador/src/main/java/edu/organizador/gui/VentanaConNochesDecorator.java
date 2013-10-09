package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.core.entities.Noche;
import edu.organizador.controlador.Controlador;

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
		
		frame.getContentPane().removeAll();
		
		comboNoches.setName("cmbNoches");
		comboNoches.addActionListener(this);
		
		JPanel pnlPrincipal = new JPanel();
		pnlPrincipal.setSize(comboNoches.getWidth(), comboNoches.getHeight());
		pnlPrincipal.add(new JLabel("Elija la noche que desea organizar"));
		pnlPrincipal.add(comboNoches);
		pnlPrincipal.setVisible(true);	
		
		JPanel pnlBottom = new JPanel();
		
		Color c = new Color(112, 173, 208);
		pnlBottom.setBackground(c);
		frame.add(pnlBottom, BorderLayout.SOUTH);
		
		JButton btnComprar = new JButton();
		JButton btnOrganizar = new JButton();
		btnComprar.setName("btnBandas");
		btnComprar.setText("Agregar Nueva Banda");
		btnComprar.addActionListener(this);
		pnlBottom.add(btnComprar, BorderLayout.NORTH);
		
		btnOrganizar.setName("btnOrganizarNoche");
		btnOrganizar.setText("Realizar diagramacion");
		btnOrganizar.addActionListener(this);
		pnlBottom.add(btnOrganizar, BorderLayout.NORTH);

		frame.add(pnlPrincipal, BorderLayout.NORTH);
		frame.add(pnlBottom, BorderLayout.SOUTH);
		frame.setSize(800,600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);

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
			
		case "Realizar diagramacion":
			Controlador controlador1 = new Controlador(frame);
			VentanaOrganizador ventanaOrganizador = new VentanaOrganizador();
			ventanaOrganizador.cargarOrganizador();
			break;	
			
		case "Agregar Nueva Banda":
			Controlador controlador = new Controlador(frame);
			VentanaBandaDecorator ventana = new VentanaBandaDecorator();
			List<String> datos = ventana.cargarFormularioBandas();
			controlador.guardarBanda(datos);
			break;
			
		default:
			break;
		}

	}

}
