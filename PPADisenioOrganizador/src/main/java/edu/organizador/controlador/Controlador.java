package edu.organizador.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import edu.core.dao.DataReader;
import edu.core.dao.DataReaderDAO;
import edu.core.entities.Banda;
import edu.core.entities.Noche;
import edu.organizador.gui.VentanaConNochesDecorator;
import edu.organizador.gui.VentanaInicioDecorator;

public class Controlador {
	private JFrame frame;
	private String estadio;
	List<String> datos = new ArrayList<String>();

	public Controlador(JFrame frame) {
		this.frame = frame;
	}
	
	public void iniciarJuego(){
		DataReaderDAO dataReader = new DataReader();
		VentanaInicioDecorator inicio = new VentanaInicioDecorator();
		datos = inicio.cargarFormulario();
	}
	
	public void organizarNoches(){
		DataReaderDAO dataReader = new DataReader();
		Set<Banda> lasBandas = dataReader.getBandas();
		List<Noche> lasNoches = dataReader.getNoches(lasBandas);
		
		VentanaConNochesDecorator ventana = new VentanaConNochesDecorator(Integer.valueOf(datos.get(1)));
		ventana.seleccionarNoches(frame);
	}

}
