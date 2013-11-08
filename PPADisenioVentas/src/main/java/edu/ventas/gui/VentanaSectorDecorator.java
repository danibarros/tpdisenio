package edu.ventas.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.core.entities.Butaca;
import edu.core.entities.Estadio;
import edu.core.entities.Fila;
import edu.core.entities.Sector;

public class VentanaSectorDecorator implements VentanaDecoratorInterface,
		ActionListener {
	JPanel panel;

	List<Butaca> seleccionados = new ArrayList<Butaca>();
	List<Sector> sectores;
	List<Fila> filas;
	private int maximoSeleccionado;

	public void dibujarSector(JFrame frame, String sector, Estadio estadio,
			List<Butaca> butacasSeleccionadas,int maximoSeleccionado) {
		
		this.maximoSeleccionado = maximoSeleccionado;
		
		JButton cutbutton = new JButton(new ImageIcon(
				"src/main/resources/ButacaOcupada.png"));
		sectores = estadio.getSectores();
		seleccionados = butacasSeleccionadas;
		Sector sectorEncontrado = null;
		for (Sector sector2 : sectores) {
			if (sector2.getColor().equals(sector)) {
				sectorEncontrado = sector2;
				break;
			}
		}
		filas = sectorEncontrado.getFilas();
		if (panel == null)
			panel = new JPanel();
		frame.setVisible(false);
		panel.removeAll();
		panel.setSize(frame.getWidth(), filas.size() * cutbutton.getHeight());
		int y = cutbutton.getHeight();
		for (Fila fila : filas) {
			dibujarFila(fila, frame);
		}
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	private void dibujarFila(Fila fila, JFrame frame) {
		List<Butaca> butacas = fila.getButacas();
		JPanel panelFila = new JPanel();
		JButton cutbutton = null;
		for (Butaca butaca : butacas) {
			if (!seleccionados.isEmpty() && seleccionados.contains(butaca)) {
				cutbutton = new JButton(new ImageIcon(
						"src/main/resources/ButacaOcupada.png"));
				cutbutton.setName(String.valueOf(butaca.getNumero()));
				cutbutton.addActionListener(this);
				cutbutton.setBackground(Color.RED);
				ImageIcon press = new ImageIcon(
						"src/main/resources/ButacaOcupada.png");
				cutbutton.setPressedIcon(press);
				panelFila.add(cutbutton);
			} else {
				cutbutton = new JButton(new ImageIcon(
						"src/main/resources/ButacaOcupada.png"));
				cutbutton.setName(String.valueOf(butaca.getNumero()));
				cutbutton.addActionListener(this);
				cutbutton.setBackground(Color.BLUE);
				ImageIcon press = new ImageIcon(
						"src/main/resources/ButacaOcupada.png");
				cutbutton.setPressedIcon(press);
				panelFila.add(cutbutton);
			}
		}
		panelFila.setSize(panel.getWidth(), cutbutton.getHeight());
		panel.add(panelFila);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btn = (JButton) e.getSource();
		String nombre = btn.getName();

		if (btn.getBackground() == Color.BLUE) {
			if(seleccionados.size() < maximoSeleccionado){
			btn.setBackground(Color.RED);
			seleccionados.add(sacarButaca(nombre));
			}
		} else {
			seleccionados.remove(sacarButaca(nombre));
			btn.setBackground(Color.BLUE);

		}
	}

	public List<Butaca> getSeleccionados() {
		return seleccionados;
	}

	public void setSeleccionados(List<Butaca> seleccionados) {
		this.seleccionados = seleccionados;
	}

	private Butaca sacarButaca(String nombre) {
		Butaca butacaEncontrada = null;
		for (Fila fila : filas) {
			for (Butaca butaca : fila.getButacas()) {
				if (String.valueOf(butaca.getNumero()).equals(nombre))
					butacaEncontrada = butaca;
			}
		}
		return butacaEncontrada;
	}
}
