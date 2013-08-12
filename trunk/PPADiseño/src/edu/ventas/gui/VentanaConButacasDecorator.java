package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.ventas.entities.Estadio;
import edu.ventas.entities.Festival;
import edu.ventas.entities.Noche;
import edu.ventas.entities.Sector;

public class VentanaConButacasDecorator implements VentanaDecoratorInterface, ActionListener{
	
	private Estadio estadio;
	private Noche noche;
	private String sector;
	VentanaSectorDecorator ventanaSector = new VentanaSectorDecorator();
	JFrame frame;
	JPanel panel;
	public VentanaConButacasDecorator(Estadio estadio, Noche nocheElegida, JFrame frame) {
		this.estadio=estadio;
		this.noche=nocheElegida;
		this.frame=frame;
	}

	@Override
	public void dibujar() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		 panel = new JPanel();
		 frame.getContentPane().removeAll();
		 frame.add(panel, BorderLayout.NORTH);
		 
		 JComboBox<String> comboSectores = new JComboBox<String>();
		 comboSectores.addActionListener(this);
		 
		 for (Sector unSector : this.estadio.getSectores()) {
			comboSectores.addItem(unSector.getNombre());
			
		}
		 panel.setSize(screenSize.width-50, screenSize.height-50);
		 frame.setSize(screenSize.width, screenSize.height); 
		 
		 panel.add(comboSectores,BorderLayout.NORTH);
		 frame.setVisible(true);
		 panel.setVisible(true);

	}

	public Estadio getEstadio() {
		return estadio;
	}

	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}

	public Noche getNoche() {
		return noche;
	}

	public void setNoche(Noche noche) {
		this.noche = noche;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
		String newSelection = (String)cb.getSelectedItem();
		sector = newSelection;
		ventanaSector.dibujarSector(frame,sector,estadio);
	}
}
