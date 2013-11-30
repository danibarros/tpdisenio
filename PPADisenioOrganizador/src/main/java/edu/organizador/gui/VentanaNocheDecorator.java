package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import edu.core.dao.BandaDAO;
import edu.core.dao.DataReader;
import edu.core.dao.DataReaderDAO;
import edu.core.dao.EstadioDAO;
import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Estadio;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.Sector;
import edu.core.requests.NocheRequest;
import edu.organizador.controlador.Controlador;
import external.utils.CheckComboBox;
import external.utils.ObjCheckBox;

import java.awt.Color;

public class VentanaNocheDecorator implements VentanaDecoratorInterface,
		ActionListener {
	private JSpinner spinner = new JSpinner();
	private JPanel panel;
	private JFrame frame;
	private Noche noche;
	private Set<Banda> totalBandas;
	private List<Banda> listaBandas;
	private CheckComboBox chkcmbBandas;

	public void formularioNoche(Noche noche, JFrame frame) {

		this.noche = noche;
		BandaDAO bandaDao = new BandaDAO();
		totalBandas = bandaDao.findAll();
		listaBandas = new ArrayList<Banda>(totalBandas);
		Set<Object> options = new HashSet<>();
		Color c = new Color(112, 173, 208);
		JLabel lblBandas = new JLabel("Elija las bandas que desea");
		JLabel lblHoraInicio = new JLabel("Ingrese hora de inicio");
		JPanel grid = new JPanel(new GridLayout(0, 1));

		if (panel == null)
			panel = new JPanel(new GridBagLayout());
		panel.removeAll();
		panel.setBackground(c);
		for (Banda banda : totalBandas) {
			options.add(banda.getNombre());
		}

		chkcmbBandas = new CheckComboBox(options);

		if (noche.getBandas() != null) {
			Set<Object> objects = new HashSet<>();
			for (Banda banda : noche.getBandas()) {
				objects.add(banda.getNombre());
			}
			chkcmbBandas.addSelectedItems(objects);
		}

//		if (noche.getEstadio() != null) {
//			cmbEstadios.setSelectedItem(noche.getEstadio().getNombre());
//		}
//
//		listaEstadios = new ArrayList<Estadio>(totalEstadios);
//
//		for (Estadio estadio : totalEstadios) {
//			cmbEstadios.addItem(estadio.getNombre());
//		}
//		if (noche.getEstadio() != null) {
//			cmbEstadios.setSelectedItem(noche.getEstadio().getNombre());
//		}

		List<Banda> bandasEncontradas = new ArrayList<Banda>();
		if (chkcmbBandas.getSelectedItems() != null) {
			for (Object object : chkcmbBandas.getSelectedItems()) {
				bandasEncontradas
						.add(buscarBanda(totalBandas, (String) object));
			}
		}
		noche.setBandas(bandasEncontradas);
		
//		if (cmbEstadios.getSelectedItem() != null) {
//			noche.setEstadio(listaEstadios.get(cmbEstadios.getSelectedIndex()));
//		}

		grid.setSize(500, 500);
		grid.setBackground(c);

		chkcmbBandas.setName("cmbBandas");
		chkcmbBandas.addActionListener(this);
		grid.add(lblBandas);
		grid.add(chkcmbBandas);
		grid.add(lblHoraInicio);

		SpinnerDateModel model = new SpinnerDateModel();
		model.setCalendarField(Calendar.MINUTE);

		spinner.setModel(model);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "h:mm a"));
		
		grid.add(spinner);
		panel.add(grid);
		panel.setSize(500,500);

		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	private Banda buscarBanda(Set<Banda> bandas, String nombre) {
		Banda bandaEncontrada = new Banda();
		for (Banda banda : bandas) {
			if (banda.getNombre().equals(nombre)) {
				bandaEncontrada = banda;
				return bandaEncontrada;
			}
		}
		return bandaEncontrada;
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String event = e.getActionCommand();
		switch (event) {
		case "comboBoxChanged":
			JComboBox cb = (JComboBox) e.getSource();
			if (cb.getName().equalsIgnoreCase("cmbBandas")) {
				if (chkcmbBandas.getSelectedItems() != null){
					noche.setBandas(sacarDeCheckbox(chkcmbBandas));
				}
			}		
			break;
			case "Finalizar Diagramacion":
				JOptionPane.showMessageDialog(null,
						"Gracias por realizar la diagramacion del festival!!");
				System.exit(0);
			default:
			break;
		}

	}

	private List<Banda> sacarDeCheckbox(CheckComboBox check) {

		List<Banda> lista = new ArrayList<Banda>();
		Object[] objects = check.getSelectedItems();
		for (Object object : objects) {
			lista.add(buscarBanda(totalBandas, (String) object));
		}
		Object seleccionado = check.getSelectedItem();
		ObjCheckBox checkbox = (ObjCheckBox) seleccionado;
		lista.add(buscarBanda(totalBandas, checkbox.getText()));
		return lista;
	}

}
