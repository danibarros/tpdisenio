package edu.ventas.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.ventas.entities.Banda;
import edu.ventas.entities.Butaca;
import edu.ventas.entities.Entrada;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Festival;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.entities.Sector;
import edu.ventas.entities.Vendedor;

public class Main {

	private List<Butaca> butacas;

	public static void main(String[] args) throws ParseException {
	    SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
	    
	    Map<String,Integer> listaCategorias = new HashMap<String,Integer>();
	    
	    listaCategorias.put("categoria1", 0);
	    listaCategorias.put("categoria2", 50);
	    listaCategorias.put("categoria3", 100);
	    listaCategorias.put("categoria4", 200);

		Butaca butaca = new Butaca(true, 1);
		Butaca butaca2 = new Butaca(true, 2);
		Butaca butaca3 = new Butaca(true, 3);
		Butaca butaca4 = new Butaca(true, 4);
		List<Butaca> butacas = new ArrayList<Butaca>();
		List<Butaca> butacas2 = new ArrayList<Butaca>();
		butacas.add(butaca);
		butacas.add(butaca2);
		butacas2.add(butaca3);
		butacas2.add(butaca4);

		Fila fila = new Fila(1, butacas);
		Fila fila2 = new Fila(2, butacas2);
		List<Fila> filas = new ArrayList<Fila>();
		filas.add(fila);
		List<Fila> filas2 = new ArrayList<Fila>();
		filas2.add(fila2);
		
		Sector sector = new Sector("Sector1", filas,50,'A');
		Sector sector2 = new Sector("Sector2", filas2,25,'B');
		List<Sector> sectores = new ArrayList<Sector>();
		sectores.add(sector);
		sectores.add(sector2);
		
		PuntoDeVenta puntoDeVenta = new PuntoDeVenta();
		List<PuntoDeVenta> puntosDeVenta = new ArrayList<PuntoDeVenta>();
		puntosDeVenta.add(puntoDeVenta);
		
		Banda banda1 = new Banda("las patillas",1);
		Banda banda2 = new Banda("ntvg",2);
		Banda banda3 = new Banda("metallica",1);
		Set<Banda> bandas = new HashSet<Banda>();
		bandas.add(banda1);
		bandas.add(banda2);
		bandas.add(banda3);
		
		Estadio estadio = new Estadio(sectores, puntosDeVenta);
		
	    Date date; 
	    String input;
	    input = "1818-11-11"; 
        date = format.parse(input); 
		Noche noche1 = new Noche(1,bandas,date);
		
		List<Noche> noches = new ArrayList<Noche>();
		noches.add(noche1);
		
		Festival festival = new Festival("River Plate", estadio, noches);
		
		//Entrada entrada = new Entrada(1,butaca ,fila2,sector,123123,festival,noche1,listaCategorias);
		//System.out.println(entrada);
		
		
		Vendedor unVendedor=new Vendedor();
		
		//crear un par de variables para q las ingrese por pantalla y unVendedor pueda vender() lo pedido.
		
		//le mandamos la orden de vender() lo pedido.
		

		unVendedor.vender("Dani",22,butaca,fila,sector,festival,noche1,listaCategorias);
		

		
		

		
	}
}
