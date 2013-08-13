package edu.ventas.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Spring;
import javax.swing.SpringLayout;

import edu.ventas.entities.Butaca;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Sector;

public class VentanaSectorDecorator implements VentanaDecoratorInterface {
	JPanel panel;

	public void dibujarSector(JFrame frame, String sector, Estadio estadio) {
		JButton cutbutton = new JButton(new ImageIcon(
				"resources/ButacaNoDisponible.png"));
		List<Sector> sectores = estadio.getSectores();
		Sector sectorEncontrado = null;
		for (Sector sector2 : sectores) {
			if (sector2.getNombre().equals(sector)) {
				sectorEncontrado = sector2;
				break;
			}
		}
		List<Fila> filas = sectorEncontrado.getFilas();
		if (panel == null)
			panel = new JPanel();
		frame.setVisible(false);
		panel.removeAll();
		panel.setSize(frame.getWidth(), filas.size() * cutbutton.getHeight());
		int y = cutbutton.getHeight();
		for (Fila fila : filas) {
			dibujarFila(fila, frame);
		}
		makeCompactGrid(panel, 1, panel.getComponentCount(), 6, 6, 6, 6);
		frame.add(panel);
		frame.setVisible(true);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	public void elegirButacas() {

	}

	private void dibujarFila(Fila fila, JFrame frame) {
		List<Butaca> butacas = fila.getButacas();
		JPanel panelFila = new JPanel();
		for (Butaca butaca : butacas) {
			JButton cutbutton = new JButton(new ImageIcon(
					"resources/ButacaNoDisponible.png"));
			panelFila.add(cutbutton);
			cutbutton.setBackground(Color.BLUE);
			ImageIcon press = new ImageIcon("resources/ButacaNoDisponible.png");
			cutbutton.setPressedIcon(press);
		}
		panel.add(panelFila);
	}

	private void makeCompactGrid(Container parent, int rows, int cols,
			int initialX, int initialY, int xPad, int yPad) {
		SpringLayout layout;
		try {
			layout = (SpringLayout) parent.getLayout();
		} catch (ClassCastException exc) {
			System.err
					.println("The first argument to makeCompactGrid must use SpringLayout.");
			return;
		}

		// Align all cells in each column and make them the same width.
		Spring x = Spring.constant(initialX);
		for (int c = 0; c < cols; c++) {
			Spring width = Spring.constant(0);
			for (int r = 0; r < rows; r++) {
				width = Spring.max(width,
						getConstraintsForCell(r, c, parent, cols).getWidth());
			}
			for (int r = 0; r < rows; r++) {
				SpringLayout.Constraints constraints = getConstraintsForCell(r,
						c, parent, cols);
				constraints.setX(x);
				constraints.setWidth(width);
			}
			x = Spring.sum(x, Spring.sum(width, Spring.constant(xPad)));
		}

		// Align all cells in each row and make them the same height.
		Spring y = Spring.constant(initialY);
		for (int r = 0; r < rows; r++) {
			Spring height = Spring.constant(0);
			for (int c = 0; c < cols; c++) {
				height = Spring.max(height,
						getConstraintsForCell(r, c, parent, cols).getHeight());
			}
			for (int c = 0; c < cols; c++) {
				SpringLayout.Constraints constraints = getConstraintsForCell(r,
						c, parent, cols);
				constraints.setY(y);
				constraints.setHeight(height);
			}
			y = Spring.sum(y, Spring.sum(height, Spring.constant(yPad)));
		}

		// Set the parent's size.
		SpringLayout.Constraints pCons = layout.getConstraints(parent);
		pCons.setConstraint(SpringLayout.SOUTH, y);
		pCons.setConstraint(SpringLayout.EAST, x);
	}

	private static SpringLayout.Constraints getConstraintsForCell(int row,
			int col, Container parent, int cols) {
		SpringLayout layout = (SpringLayout) parent.getLayout();
		Component c = parent.getComponent(row * cols + col);
		return layout.getConstraints(c);
	}
}
