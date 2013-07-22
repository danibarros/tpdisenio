package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.ventas.entities.Estadio;
import edu.ventas.entities.Festival;
import edu.ventas.entities.Noche;
import edu.ventas.entities.Sector;

public class VentanaConButacasDecorator implements VentanaDecoratorInterface{
	
	private Estadio estadio;
	private Noche noche;

	public VentanaConButacasDecorator(Estadio estadio, Noche nocheElegida) {
		this.estadio=estadio;
		this.noche=nocheElegida;
	}

	@Override
	public void dibujar() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		JFrame frame = new JFrame("Distribución de Butacas");
		
		 JPanel panel = new JPanel();
		 frame.add(panel, BorderLayout.CENTER);
		 
		 JComboBox<String> comboSectores = new JComboBox<String>();
		 
		 for (Sector unSector : this.estadio.getSectores()) {
			comboSectores.addItem(unSector.getNombre());
		}
		 panel.setSize(screenSize.width-50, screenSize.height-50);
		 frame.setSize(screenSize.width, screenSize.height);
		 
		 
		 panel.add(comboSectores,BorderLayout.NORTH);
		 frame.setVisible(true);
		 panel.setVisible(true);
		 
		 

		
		
	}
	
	public void elegirButacas() {
		
		
		
		 JFrame frame = new JFrame(
				 "Adding a Rollover and Pressed Icon to a JButton Component");
				 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				 JPanel panel = new JPanel();
				 frame.add(panel, BorderLayout.CENTER);
				 JButton cutbutton = new JButton(new
				 ImageIcon("resources/ButacaLibre.png"));
				 panel.add(cutbutton);
				 ImageIcon rollover = new ImageIcon("resources/ButacaOcupada.png");
				 cutbutton.setRolloverIcon(rollover);
				 ImageIcon press = new ImageIcon("resources/ButacaOcupada.png");
				 cutbutton.setPressedIcon(press);
				 frame.setSize(400, 400);
				 frame.setVisible(true);
	}
}
