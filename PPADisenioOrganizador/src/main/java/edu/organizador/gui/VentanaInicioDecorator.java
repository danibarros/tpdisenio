package edu.organizador.gui;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

public class VentanaInicioDecorator {

	public List<String> cargarFormulario() {
		List<String> datos = new ArrayList<String>();
		
		JComboBox<String> festival = new JComboBox<String>();
		JTextField field3 = new JTextField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		
		panel.add(new JLabel("Ingrese nombre del festival"));
		panel.add(festival);
		festival.addItem("Quilmes Rock");
		JXDatePicker picker = new JXDatePicker();
        picker.setDate(Calendar.getInstance().getTime());
        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		panel.add(new JLabel("Ingrese duracion en dias"));
		panel.add(field3);
		panel.add(new JLabel("Ingrese fecha de inicio"));
		panel.add(picker);
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos del festival",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			if(festival.getToolkit().equals("")){
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormulario();
			}
			datos.add(festival.getName());
			datos.add(field3.getText());
			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
			datos.add(formater.format(picker.getDate()));
		} else {
			this.cargarFormulario();
		}
		return datos;
	}
}
