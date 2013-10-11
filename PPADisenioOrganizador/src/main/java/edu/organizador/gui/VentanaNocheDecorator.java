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
import edu.organizador.controlador.Controlador;
import external.utils.CheckComboBox;
import external.utils.ObjCheckBox;

import java.awt.Color;

public class VentanaNocheDecorator implements VentanaDecoratorInterface,
		ActionListener {
	JPanel panel;
	JFrame frame;
	Noche noche;
	Set<Banda> totalBandas;
	List<Banda> listaBandas;
	List<Estadio> listaEstadios;
	CheckComboBox chkcmbBandas;

	public void formularioNoche(Noche noche, JFrame frame) {

		this.noche = noche;
		BandaDAO bandaDao = new BandaDAO();
		EstadioDAO estadioDao = new EstadioDAO();
		Estadio estadioEncontrado = new Estadio();

		if (panel == null)
			panel = new JPanel(new GridBagLayout());
		panel.removeAll();
		totalBandas = bandaDao.findAll();
		listaBandas = new ArrayList<Banda>(totalBandas);

		Set<Object> options = new HashSet<>();
		Color c = new Color(112, 173, 208);
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

		JComboBox<String> cmbEstadios = new JComboBox<String>();
		cmbEstadios.setName("cmbEstadio");
		cmbEstadios.addActionListener(this);

		if (noche.getEstadio() != null) {
			cmbEstadios.setSelectedItem(noche.getEstadio().getNombre());
		}
		JLabel lblEstadio = new JLabel("Elija el estadio");
		JLabel lblBandas = new JLabel("Elija las bandas que desea");
		JLabel lblHoraInicio = new JLabel("Ingrese hora de inicio");

		Set<Estadio> totalEstadios = estadioDao.findAll();
		listaEstadios = new ArrayList<Estadio>(totalEstadios);

		for (Estadio estadio : totalEstadios) {
			cmbEstadios.addItem(estadio.getNombre());
		}
		if (noche.getEstadio() != null) {
			cmbEstadios.setSelectedItem(noche.getEstadio().getNombre());
		}

		List<Banda> bandasEncontradas = new ArrayList<Banda>();
		if (chkcmbBandas.getSelectedItems() != null) {
			for (Object object : chkcmbBandas.getSelectedItems()) {
				bandasEncontradas
						.add(buscarBanda(totalBandas, (String) object));
			}
		}
		noche.setBandas(bandasEncontradas);

		if (cmbEstadios.getSelectedItem() != null) {
			noche.setEstadio(listaEstadios.get(cmbEstadios.getSelectedIndex()));
		}

		JPanel grid = new JPanel(new GridLayout(0, 1));

		grid.setBackground(c);

		chkcmbBandas.setName("cmbBandas");
		chkcmbBandas.addActionListener(this);
		grid.add(lblEstadio);
		grid.add(cmbEstadios);
		grid.add(lblBandas);
		grid.add(chkcmbBandas);
		grid.add(lblHoraInicio);

		SpinnerDateModel model = new SpinnerDateModel();
		model.setCalendarField(Calendar.MINUTE);

		JSpinner spinner = new JSpinner();
		spinner.setModel(model);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "h:mm a"));

		grid.add(spinner);
		panel.add(grid);

		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);
	}

	private Estadio getEstadioPorNombre(Set<Estadio> estadios, String nombre) {
		Estadio estadioEncontrado = new Estadio();
		for (Estadio estadio : estadios) {
			if (estadio.getNombre() == nombre) {
				return estadioEncontrado;
			}
		}
		return estadioEncontrado;
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
				if (chkcmbBandas.getSelectedItems() != null)
					noche.setBandas(sacarDeCheckbox(chkcmbBandas));
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
