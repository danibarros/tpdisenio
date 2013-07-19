package edu.ventas.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.ventas.dao.DataReader;
import edu.ventas.dao.DataReaderDAO;
import edu.ventas.entities.Banda;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.gui.VentanaConButacasDecorator;
import edu.ventas.gui.VentanaFormularioDecorator;



public class Controlador {

	private String apeYNom;
	private int edad;
	private int numeroNoche;
	private List<PuntoDeVenta> puntosDeVenta;
	
	public void iniciarJuego(){
		DataReaderDAO dataReader = new DataReader();
		puntosDeVenta = dataReader.getPuntosDeVenta();
		VentanaInicioDecorator inicio = new VentanaInicioDecorator();
		inicio.cargarFormulario(puntosDeVenta);
	}
	public void pedirDatosIniciales(){
		List<String> datos = new ArrayList<String>();
		DataReaderDAO dataReader = new DataReader();
		Set<Banda> bandas = dataReader.getBandas();
		List<Noche> noches = dataReader.getNoches(bandas);
		VentanaFormularioDecorator form = new VentanaFormularioDecorator();
		VentanaConButacasDecorator butaca = new VentanaConButacasDecorator();
    	datos = form.cargarFormulario(noches);
    	butaca.dibujar();
    	apeYNom = datos.get(0);
    	edad = Integer.getInteger(datos.get(1));
    	numeroNoche = Integer.getInteger(datos.get(2));
	}
	
	public void elegirButaca(){
		List<String> datos = new ArrayList<String>();
		DataReaderDAO dataReader = new DataReader();
		Set<Banda> bandas = dataReader.getBandas();
		List<Noche> noches = dataReader.getNoches(bandas);

		VentanaFormularioDecorator form = new VentanaFormularioDecorator();
    	datos = form.cargarFormulario(noches);
    	apeYNom = datos.get(0);
    	edad = Integer.getInteger(datos.get(1));
    	numeroNoche = Integer.getInteger(datos.get(2));
	}

}
