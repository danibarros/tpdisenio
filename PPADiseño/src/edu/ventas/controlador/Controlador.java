package edu.ventas.controlador;

import java.util.List;
import java.util.Set;

import edu.ventas.dao.DataReader;
import edu.ventas.dao.DataReaderDAO;
import edu.ventas.entities.Banda;
import edu.ventas.entities.Noche;
import edu.ventas.gui.VentanaDecoratorInterface;
import edu.ventas.gui.VentanaFormularioDecorator;



public class Controlador {

	private String apeYNom;
	private int edad;
	private int numeroNoche;
	
	public void pedirDatosIniciales(){
		DataReaderDAO dataReader = new DataReader();
		Set<Banda> bandas = dataReader.getBandas();
		List<Noche> noches = dataReader.getNoches(bandas);
		VentanaFormularioDecorator form = new VentanaFormularioDecorator();
    	form.cargarFormulario(noches);
	}
	
	
}
