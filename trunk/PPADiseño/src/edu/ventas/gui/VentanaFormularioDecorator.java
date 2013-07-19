package edu.ventas.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.ventas.entities.Noche;

public class VentanaFormularioDecorator implements VentanaDecoratorInterface {

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	public List<String> cargarFormulario(List<Noche> noches) {
		List<String> items = new ArrayList<String>();
		List<String> datos = new ArrayList<String>();

		for (Noche noche : noches) {
			items.add(String.valueOf(noche.getNumeroDeNoches()));
		}
		@SuppressWarnings({ "unchecked", "rawtypes" })
		JComboBox combo = new JComboBox(items.toArray());
		JTextField field1 = new JTextField("");
		JTextField field2 = new JTextField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(new JLabel("Ingrese su nombre y apellido"));
		panel.add(field1);
		panel.add(new JLabel("Ingrese su edad"));
		panel.add(field2);
		panel.add(combo);
		int result = JOptionPane.showConfirmDialog(null, panel, "Test",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			if(field1.getText().equals("") || field2.getText().equals("")){
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormulario(noches);
			}
			datos.add(field1.getText());
			datos.add(field2.getText());
			datos.add(items.get(combo.getSelectedIndex()));
		} else {
			System.out.println("Cancelled");
		}
		return datos;

	}
}
