package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import edu.core.dao.BandaDAO;
import edu.core.entities.Banda;


public class VentanaCargarBandas implements VentanaDecoratorInterface {
	JFrame frame;
	List<String> datos = new ArrayList<String>();
	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
	
	public List<String> cargarBandas() {
		
		SpinnerDateModel model = new SpinnerDateModel();
		model.setCalendarField(Calendar.MINUTE);
		SimpleDateFormat format = new SimpleDateFormat("h:mm a");
		JSpinner spinnerHoraInicio = new JSpinner();
		spinnerHoraInicio.setModel(model);
		spinnerHoraInicio.setEditor(new JSpinner.DateEditor(spinnerHoraInicio, "h:mm a"));
		
		JSpinner spinnerDuracion = new JSpinner();
		spinnerDuracion.setModel(model);
		spinnerDuracion.setEditor(new JSpinner.DateEditor(spinnerDuracion, "h:mm a"));
		
		JTextField field3 = new JTextField("");
		JTextField field4 = new JTextField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));

		BandaDAO bandaDao = new BandaDAO();
		
		JComboBox<String> cmbBandas = new JComboBox<String>();
		Set<Banda> bandas = bandaDao.findAll();
		
		for (Banda banda : bandas) {
				cmbBandas.addItem(banda.getNombre());
		}
		
		panel.add(new JLabel("Seleccione la banda"));
		panel.add(cmbBandas);
		panel.add(new JLabel("Ingrese el horario de inicio"));
    	panel.add(spinnerHoraInicio);
    	panel.add(new JLabel("Ingrese la duracion en el escenario de la banda"));
    	panel.add(spinnerDuracion);
		
		
		int result = JOptionPane.showConfirmDialog(null, panel, "Datos de Diagramación",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		if (result == JOptionPane.OK_OPTION) {
			if(field3.getText().equals("")|| field4.getText().equals("") ) { 
				datos = null;
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarBandas();
			}else{
			datos.add((String) cmbBandas.getSelectedItem());
			datos.add((String) format.format((Date) spinnerHoraInicio.getValue()));
			datos.add((String) format.format((Date) spinnerDuracion.getValue()));
			
			VentanaDespedidaDecorator despedida = new VentanaDespedidaDecorator();
			despedida.dibujar();
			this.cargarBandas();
			
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"Se ha realizado la diagramacion del festival, muchas gracias!!");	
		}
		return datos;
	}
}

