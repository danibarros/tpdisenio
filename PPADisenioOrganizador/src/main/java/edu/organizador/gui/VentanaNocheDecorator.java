package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
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

import java.awt.Color;

public class VentanaNocheDecorator implements VentanaDecoratorInterface,
		ActionListener {
	JPanel panel;
	JFrame frame;
	List<Butaca> seleccionados = new ArrayList<Butaca>();
	List<Sector> sectores;
	List<Fila> filas;

	public void formularioNoche(Noche noche, JFrame frame) {

		BandaDAO bandaDao = new BandaDAO();
		EstadioDAO estadioDao = new EstadioDAO();
		Estadio estadioEncontrado = new Estadio();

		noche.getHoraInicio();

		if (panel == null)
			panel = new JPanel(new GridBagLayout());
		frame.setVisible(false);
		panel.removeAll();
		Set<Banda> bandas = bandaDao.findAll();
		Set<Object> options = new HashSet<>();
		for (Banda banda : bandas) {
			options.add(banda.getNombre());
		}
		Color c = new Color(112, 173, 208);
		panel.setBackground(c);
		CheckComboBox chkcmbBandas = new CheckComboBox(options);

		JComboBox<String> cmbEstadios = new JComboBox<String>();
		JLabel lblEstadio = new JLabel("Elija el estadio");
		JLabel lblBandas = new JLabel("Elija las bandas que desea");
		JLabel lblHoraInicio = new JLabel("Ingrese hora de inicio");

		Set<Estadio> estadios = estadioDao.findAll();

		for (Estadio estadio : estadios) {
			cmbEstadios.addItem(estadio.getNombre());
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

		JPanel pnlBottom = new JPanel();
		pnlBottom.setBackground(c);
		frame.add(pnlBottom, BorderLayout.SOUTH);
		JButton btnComprar = new JButton();
		JButton btnOrganizar = new JButton();
		JButton btnFinalizar = new JButton();
		btnComprar.setName("btnBandas");
		btnComprar.setText("Agregar Nueva Banda");
		btnComprar.addActionListener(this);
		btnOrganizar.setName("btnOrganizarNoche");
		btnOrganizar.setText("Realizar diagramacion");
		btnOrganizar.addActionListener(this);
		btnFinalizar.setName("btnFinalizar");
		btnFinalizar.setText("Finalizar Diagramacion");
		btnFinalizar.addActionListener(this);
		pnlBottom.add(btnOrganizar, BorderLayout.WEST);
		pnlBottom.add(btnComprar, BorderLayout.NORTH);
		pnlBottom.add(btnFinalizar, BorderLayout.NORTH);
		
		

		JSpinner spinner = new JSpinner();
		spinner.setModel(model);
		spinner.setEditor(new JSpinner.DateEditor(spinner, "h:mm a"));
		grid.add(spinner);
		panel.add(grid);
		frame.add(panel, BorderLayout.CENTER);
		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String event = e.getActionCommand();
		switch (event) {
		case "Agregar Nueva Banda":
			Controlador controlador = new Controlador(frame);
			VentanaBandaDecorator ventana = new VentanaBandaDecorator();
			List<String> datos = ventana.cargarFormularioBandas();
			controlador.guardarBanda(datos);
			break;
		case "Realizar diagramacion":
			Controlador controlador1 = new Controlador(frame);
			VentanaOrganizador ventanaOrganizador = new VentanaOrganizador();
			List<String> datosBandaHorarios = ventanaOrganizador.cargarOrganizador();
			controlador1.guardarHorariosBanda(datosBandaHorarios);
			
			break;
		case "Finalizar Diagramacion":
			JOptionPane.showMessageDialog(null,
					"Gracias por realizar la diagramacion del festival!!");
			System.exit(0);
		default:
			break;
		}

	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub

	}

}
