package edu.organizador.gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import edu.core.dao.BandaDAO;
import edu.core.dao.EstadioDAO;
import edu.core.entities.Estadio;
import edu.core.entities.Festival;
import edu.core.entities.Noche;
import edu.core.utils.Validator;

public class VentanaInicioDecorator {

	public void cargarFormulario(Festival festival) {
		List<Estadio> listaEstadios;
		EstadioDAO estadioDao = new EstadioDAO();
		Set<Estadio> totalEstadios = estadioDao.findAll();
		JComboBox<String> cmbEstadios = new JComboBox<String>();
		cmbEstadios.setName("cmbEstadio");
		
		for (Estadio estadio : totalEstadios) {
			cmbEstadios.addItem(estadio.getNombre());
		}
		
		JTextField txtNombreFestival = new JTextField("");
		JTextField txtDuracionDias = new JTextField("");
		JLabel lblNombreFestival = new JLabel("Ingrese nombre del festival");
		JLabel lblNombreEstadio = new JLabel("Elija estadio");
		JLabel lblDuracionDias = new JLabel("Ingrese duracion en dias");
		JLabel lblFechaInicio = new JLabel("Ingrese fecha de inicio");
		JPanel panel = new JPanel(new GridLayout(0, 1));

		panel.add(lblNombreFestival);
		panel.add(txtNombreFestival);
		panel.add(lblNombreEstadio);
		panel.add(cmbEstadios);
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
			Validator validador = new Validator();
			if (txtNombreFestival.getText().equals("")) {
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormulario(festival);
			}
			
			if (!validador.isNumeric(txtDuracionDias.getText())) {
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.datoNoNumerio(txtDuracionDias.getText());
				this.cargarFormulario(festival);
			}
			
			if (validador.isNumeric(txtNombreFestival.getText())) {
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.datoNumerio(txtNombreFestival.getText());
				this.cargarFormulario(festival);
			}

			Date date = dteFechaInicio.getDate();
			festival.setNombre(txtNombreFestival.getText());
			
			int cantDias = Integer.parseInt(txtDuracionDias.getText().trim());

			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			festival.setFechaInicio(new java.sql.Date(cal.getTime().getTime()));
			listaEstadios = new ArrayList<Estadio>(totalEstadios);
			
			if (cmbEstadios.getSelectedItem() != null) {
				festival.setEstadio(listaEstadios.get(cmbEstadios.getSelectedIndex()));
			}

			for (int i = 0; i < cantDias; i++) {
				Noche noche = new Noche();
				noche.setFecha(new java.sql.Date(cal.getTime().getTime()));
				festival.getNoches().add(noche);
				cal.add(Calendar.DATE, 1);
			}
			
		} else {
			int resultado = JOptionPane.showConfirmDialog(null, null, "Quiere salir", 
			JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			if (resultado == JOptionPane.OK_OPTION) {
				System.exit(0);
				}else{
					this.cargarFormulario(festival);
				}
		}
	}
	
}
