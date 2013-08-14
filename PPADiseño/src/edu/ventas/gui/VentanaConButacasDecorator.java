package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Container;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import edu.ventas.entities.Butaca;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.Sector;

public class VentanaConButacasDecorator implements VentanaDecoratorInterface,
		ActionListener {

	private Estadio estadio;
	private Noche noche;
	private String sector;
	VentanaSectorDecorator ventanaSector = new VentanaSectorDecorator();
	JFrame frame;
	JPanel panel;
	Map<String,List<Butaca>> sectores = new HashMap<String,List<Butaca>>();

	public VentanaConButacasDecorator(Estadio estadio, Noche nocheElegida,
			JFrame frame) {
		this.estadio = estadio;
		this.noche = nocheElegida;
		this.frame = frame;
	}

	@Override
	public void dibujar() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		panel = new JPanel();
		JPanel pnlBottom = new JPanel();
		frame.getContentPane().removeAll();
		frame.add(panel, BorderLayout.NORTH);
		frame.add(pnlBottom, BorderLayout.SOUTH);

		JComboBox<String> comboSectores = new JComboBox<String>();
		comboSectores.setName("cmbSectores");
		comboSectores.addActionListener(this);

		JButton btnComprar = new JButton();
		btnComprar.setName("btnComprar");
		btnComprar.setText("Comprar entradas");
		btnComprar.addActionListener(this);

		for (Sector unSector : this.estadio.getSectores()) {
			comboSectores.addItem(unSector.getNombre());
		}
		panel.setSize(comboSectores.getWidth(), comboSectores.getHeight());
		pnlBottom.setSize(comboSectores.getWidth(), comboSectores.getHeight());
		frame.setSize(screenSize.width, screenSize.height);

		panel.add(comboSectores);
		pnlBottom.add(btnComprar);
		frame.setVisible(true);
		panel.setVisible(true);
		pnlBottom.setVisible(true);

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

		String event = e.getActionCommand();
		switch (event) {
		case "comboBoxChanged":
			JComboBox cb = (JComboBox) e.getSource();
			if (cb.getName().equalsIgnoreCase("cmbSectores")) {
				String newSelection = (String) cb.getSelectedItem();
				sector = newSelection;
				ventanaSector.dibujarSector(frame, sector, estadio,ventanaSector.seleccionados);
				agregarSeleccionados(ventanaSector.seleccionados, sector);
			}
			break;
		case "Comprar entradas":
			JButton btn = (JButton) e.getSource();
			if (btn.getName().equalsIgnoreCase("btnComprar")) {
				JPanel pnlComprar = new JPanel();
				JLabel lblCantidad = new JLabel("Cantidad :");
				JLabel lblTotal = new JLabel("Total :");
				pnlComprar.add(lblCantidad);
				pnlComprar.add(lblTotal);
				int result = JOptionPane.showConfirmDialog(null, pnlComprar,
						"Datos del comprador", JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.PLAIN_MESSAGE);
			}
			break;
		default:
			break;
		}

	}
	
	private void agregarSeleccionados(List<Butaca> butacas, String sector){
		List<Butaca> butacasSeleccionadas = sectores.remove(sector);
		butacasSeleccionadas = butacas;
		sectores.put(sector,butacasSeleccionadas);
	}
}
