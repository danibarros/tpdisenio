package edu.organizador.gui;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import edu.core.entities.Festival;
import edu.core.entities.Noche;

public class VentanaInicioDecorator {

	public Festival cargarFormulario() {

		Festival festival = new Festival();
		List<String> datos = new ArrayList<String>();

		JTextField txtNombreFestival = new JTextField("");
		JTextField txtDuracionDias = new JTextField("");
		JLabel lblNombreFestival = new JLabel("Ingrese nombre del festival");
		JLabel lblDuracionDias = new JLabel("Ingrese duracion en dias");
		JLabel lblFechaInicio = new JLabel("Ingrese fecha de inicio");
		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(lblNombreFestival);
		panel.add(txtNombreFestival);
		JXDatePicker dteFechaInicio = new JXDatePicker();
		dteFechaInicio.setDate(Calendar.getInstance().getTime());
		dteFechaInicio.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
		panel.add(lblDuracionDias);
		panel.add(txtDuracionDias);
		panel.add(lblFechaInicio);
		panel.add(dteFechaInicio);

		int result = JOptionPane.showConfirmDialog(null, panel,
				"Datos del festival", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);

		if (result == JOptionPane.OK_OPTION) {
			if (txtNombreFestival.getText().equals("")) {
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormulario();
			}

			java.sql.Date date =  new java.sql.Date(dteFechaInicio.getDate().getTime());
			festival.setNombre(txtNombreFestival.getText());
			festival.setFechaInicio(date);
			
			int cantDias = Integer.parseInt(txtDuracionDias.getText().trim());

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);

			for (int i = 0; i < cantDias; i++) {
				Noche noche = new Noche();
				Date diaCalculado = cal.getTime();
				noche.setFestival(festival);
				noche.setFecha( new java.sql.Date(diaCalculado.getTime()));
				festival.getNoches().add(noche);
				cal.add(Calendar.DATE, 1);
			}
			
		} else {
			this.cargarFormulario();
		}
		return festival;
	}
}
