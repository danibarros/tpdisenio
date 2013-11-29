package edu.organizador.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.core.entities.Banda;
import edu.core.entities.Festival;
import edu.core.entities.Noche;
import edu.core.requests.NocheRequest;
import edu.organizador.controlador.Controlador;
import external.utils.TablaOrdenBandas;

public class VentanaConNochesDecorator implements VentanaDecoratorInterface,
		ActionListener {

	private List<NocheRequest> noches = new ArrayList<NocheRequest>();
	private List<Noche> listaNoches = new ArrayList<Noche>();
	private int noche = 1;
	private boolean pause = true;
	private JComboBox<String> comboNoches = new JComboBox<String>();
	private VentanaNocheDecorator ventana = new VentanaNocheDecorator();
	private VentanaAlertDecorator alert = new VentanaAlertDecorator();
	private JFrame frame;
	private JPanel panel;
	
	

	public VentanaConNochesDecorator(int cantNoches, JFrame frame) {
		int i;
		this.frame = frame;
		
		for(i=0;i<cantNoches;i++){
			Noche noche = new Noche();
			NocheRequest nocheRequest = new NocheRequest();
			noche.setNumero(i + 1);
			comboNoches.addItem(String.valueOf(noche.getNumero()));	
			nocheRequest.setNoche(noche);
			noches.add(nocheRequest);
		}
	}

	@Override
	public void dibujar() {

	}

	public List<Noche> seleccionarNoches() {
		JPanel pnlPrincipal = new JPanel();
		JPanel pnlBottom = new JPanel();
		Color c = new Color(112, 173, 208);
		JButton btnComprar = new JButton();
		JButton btnOrganizar = new JButton();
		JButton btnTerminar = new JButton();
	
		frame.getContentPane().removeAll();
		
		comboNoches.setName("cmbNoches");
		comboNoches.addActionListener(this);			
		
		pnlPrincipal.setSize(comboNoches.getWidth(), comboNoches.getHeight());
		pnlPrincipal.add(new JLabel("Elija la noche que desea organizar"));
		pnlPrincipal.add(comboNoches);	
		
		pnlBottom.setBackground(c);
		frame.add(pnlBottom, BorderLayout.SOUTH);
		
		btnComprar.setName("btnBandas");
		btnComprar.setText("Agregar Nueva Banda");
		btnComprar.addActionListener(this);
		pnlBottom.add(btnComprar, BorderLayout.NORTH);
		
		btnOrganizar.setName("btnOrganizarNoche");
		btnOrganizar.setText("Realizar diagramacion");
		btnOrganizar.addActionListener(this);
		pnlBottom.add(btnOrganizar, BorderLayout.NORTH);
		
		btnTerminar.setName("btnTerminar");
		btnTerminar.setText("Terminar Festival");
		btnTerminar.addActionListener(this);
		pnlBottom.add(btnTerminar, BorderLayout.NORTH);

		pnlPrincipal.setVisible(true);
		
		frame.add(pnlPrincipal, BorderLayout.NORTH);
		frame.setSize(800,600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);

		ventana.formularioNoche(noches.get(comboNoches.getSelectedIndex()).getNoche(),frame);

		while (pause) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		frame.getContentPane().removeAll();
		ordenarBandas();
		
		return listaNoches;
		
	}

	private void ordenarBandas() {
		Map<Banda,Integer> bandas;
		SortedMap<Integer,Banda> bandasOrdenadas = new TreeMap<Integer,Banda>();
		int numeroBanda;
		for (NocheRequest request : noches) {
			bandas = request.getBandas();
			bandasOrdenadas.clear();
			for(Banda banda : request.getNoche().getBandas()){
				numeroBanda = bandas.get(banda);
				bandasOrdenadas.put(numeroBanda, banda);
			}
			List<Banda> listaBandas = new ArrayList<Banda>(bandasOrdenadas.values());
			request.getNoche().setBandas(listaBandas);
			listaNoches.add(request.getNoche());
		}
		bandas=null;	
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		String event = e.getActionCommand();
		Controlador controlador = new Controlador(frame);
		switch (event) {
		case "comboBoxChanged":
			JComboBox cb = (JComboBox) e.getSource();
			if (cb.getName().equalsIgnoreCase("cmbNoches")) {
				String newSelection = (String) cb.getSelectedItem();
				noche = Integer.valueOf(newSelection);
				ventana.formularioNoche(noches.get(noche -1).getNoche(),frame);
			}
			break;
			
		case "Realizar diagramacion":
			TablaOrdenBandas tabla = new TablaOrdenBandas();
			tabla.dibujar(noches.get(noche -1));
			break;	
			
		case "Agregar Nueva Banda":
			VentanaBandaDecorator ventana = new VentanaBandaDecorator();
			List<String> datos = ventana.cargarFormularioBandas();
			controlador.guardarBanda(datos);
			break;
			
		case "Terminar Festival":
			pause = false;
			break;
			
		default:
			break;
		}

	}

}
