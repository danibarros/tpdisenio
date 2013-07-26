package edu.ventas.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import edu.ventas.dao.DataReader;
import edu.ventas.dao.DataReaderDAO;
import edu.ventas.entities.Banda;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.gui.VentanaConButacasDecorator;
import edu.ventas.gui.VentanaFormularioDecorator;
import edu.ventas.gui.VentanaInicioDecorator;
import edu.ventas.gui.VentanaSectorDecorator;



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
		
    	datos = form.cargarFormulario(noches);
    	apeYNom = datos.get(0);
    	edad = Integer.parseInt(datos.get(1));
    	numeroNoche = Integer.parseInt(datos.get(2));
	}
	
	public void elegirButaca(){
		VentanaSectorDecorator sectorDecorator = new VentanaSectorDecorator();
		DataReaderDAO dataReader = new DataReader();
		Set<Banda> lasBandas = dataReader.getBandas();
		List<Noche> lasNoches = dataReader.getNoches(lasBandas);
		
		Estadio estadio = dataReader.getEstadio(dataReader.getSectores(dataReader.getFilas(dataReader.getButacas())),dataReader.getPuntosDeVenta());
        Noche nocheElegida = lasNoches.get(this.numeroNoche);
		
    	VentanaConButacasDecorator butaca = new VentanaConButacasDecorator(estadio,nocheElegida);
    	butaca.dibujar();


	}

}
