package edu.ventas.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

import edu.ventas.dao.DataReader;
import edu.ventas.dao.DataReaderDAO;
import edu.ventas.entities.Banda;
import edu.ventas.entities.Butaca;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.entities.Vendedor;
import edu.ventas.gui.VentanaConButacasDecorator;
import edu.ventas.gui.VentanaFormularioDecorator;
import edu.ventas.gui.VentanaInformarEntradasDecorator;
import edu.ventas.gui.VentanaInicioDecorator;



public class Controlador {

	private String apeYNom;
	private int edad;
	private int numeroNoche;
	private List<PuntoDeVenta> puntosDeVenta;
	private JFrame frame;
	private Map<String,List<Butaca>> sectores = null;
	private Noche nocheElegida;
	double precio;
	private Vendedor vendedor;
	
	
	public Controlador(JFrame frame){
		this.frame = frame;
	}
	
	public void iniciarJuego(){
		DataReaderDAO dataReader = new DataReader();
		puntosDeVenta = dataReader.getPuntosDeVenta();
		VentanaInicioDecorator inicio = new VentanaInicioDecorator();
		inicio.cargarFormulario(puntosDeVenta);
		vendedor = new Vendedor();
		
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
		DataReaderDAO dataReader = new DataReader();
		Set<Banda> lasBandas = dataReader.getBandas();
		List<Noche> lasNoches = dataReader.getNoches(lasBandas);
		
		Estadio estadio = dataReader.getEstadio(dataReader.getSectores(dataReader.getFilas(dataReader.getButacas())),dataReader.getPuntosDeVenta());
        nocheElegida = lasNoches.get(this.numeroNoche -1);
		nocheElegida.setEstadio(estadio);
        
    	VentanaConButacasDecorator butaca = new VentanaConButacasDecorator(estadio,nocheElegida,frame);
    	sectores = butaca.seleccionarButacas();
    	
    	precio = calcularPrecio(sectores);
    
	}
	
	public void vender(){
    	VentanaInformarEntradasDecorator informator = new VentanaInformarEntradasDecorator(frame);
    	
    	informator.informarEntradas(sectores, precio, nocheElegida,vendedor,edad);
	}
	
	private double calcularPrecio(Map<String,List<Butaca>> sectores, int edad){
		int i=0;
		int j=0;
		List<Butaca> list=null;
		Butaca butaca=null;
		
		while(sectores.size()<=i){
			list = sectores.get((Estadio.getSectores()).get(i).getNombre());
			while(list.get(j)!=null){
				butaca=list.get(j);
				precio= butaca.getFila().getPrecioFila();
				precio = precio + butaca.getFila().getSector().getPrecioSector();
				j=j+1;
			}
		i=i+1;
		}
		
		if (edad < 18 & precio > 100) {
			return precio * 0.8;
		} else if (edad < 18 & precio > 50
				& precio < 100) {
			return precio - 10;
		} else if (edad > 65) {
			return precio * 0.85;
		} else {
			return precio;
		}
	}
}
}
