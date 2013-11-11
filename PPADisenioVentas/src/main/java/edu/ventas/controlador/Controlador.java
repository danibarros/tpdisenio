package edu.ventas.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

import edu.core.dao.BandaDAO;
import edu.core.dao.DataReader;
import edu.core.dao.DataReaderDAO;
import edu.core.dao.EstadioDAO;
import edu.core.dao.FestivalDAO;
import edu.core.dao.NocheDAO;
import edu.core.dao.PuntoDeVentaDAO;
import edu.core.dao.VendedorDAO;
import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Entrada;
import edu.core.entities.Estadio;
import edu.core.entities.Festival;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.PuntoDeVenta;
import edu.core.entities.Sector;
import edu.core.entities.Vendedor;
import edu.core.requests.UserValidationRequest;
import edu.core.utils.Validator;
import edu.ventas.gui.VentanaAlertDecorator;
import edu.ventas.gui.VentanaConButacasDecorator;
import edu.ventas.gui.VentanaDespedidaDecorator;
import edu.ventas.gui.VentanaFormularioDecorator;
import edu.ventas.gui.VentanaInformarEntradasDecorator;
import edu.ventas.gui.VentanaInicioDecorator;
import edu.ventas.gui.VentanaLoginDecorator;



public class Controlador {

	private String apeYNom;
	private int edad;
	private int numeroNoche;
	private String festival;
	private PuntoDeVenta puntoDeVentaDeVendedor;
	private JFrame frame;
	private Map<String,List<Butaca>> sectores = null;
	private Noche nocheElegida;
	double precio;
	private Vendedor vendedor;
	private Entrada entrada;
	private Estadio estadio;
	private Integer cantJubilados;
	private Integer cantMayores;
	private Integer cantMenores;
	private boolean compraAseptada = false;
	private Set<Banda> bandas;
	private List<Noche> noches;
	private List<Festival> festivales;
	private FestivalDAO festivalDAO = new FestivalDAO();
	
	
	public Controlador(JFrame frame){
		this.frame = frame;
	}
	
    public void logIn(){
    	VendedorDAO vendedorDao = new VendedorDAO();
    	UserValidationRequest request;
    	VentanaAlertDecorator alert = new VentanaAlertDecorator();
    	Validator validator = new Validator();
    	VentanaLoginDecorator login = new VentanaLoginDecorator();
    	request = login.login();
    	request.setVendedorDao(vendedorDao);
    	if(!validator.validateUser(request)){
			alert.errorid();
			logIn();
    	}    
    	
    	if(this.vendedor == null){
    		this.vendedor = vendedorDao.getVendedorByUser(request.getUser());	
    	}
    	
    }
	
	public void iniciarJuego()
	{
		VentanaInicioDecorator inicio = new VentanaInicioDecorator();
		inicio.cargarFormulario(this.vendedor);
	}
	public void pedirDatosIniciales(){
		List<String> datos = new ArrayList<String>();
		
//		BandaDAO bandaDAO = new BandaDAO();
//		NocheDAO nocheDAO = new NocheDAO();
//		
//		bandas = (Set<Banda>) bandaDAO.findAll();
//		noches = nocheDAO.getAllNoches();
		festivales = festivalDAO.getAllFestivales();

		VentanaFormularioDecorator form = new VentanaFormularioDecorator();
		
    	datos = form.cargarFormulario(festivales);
    	if (null != datos) {
    		apeYNom = datos.get(0);
    		cantJubilados = Integer.parseInt(datos.get(1).trim());
    		cantMenores = Integer.parseInt(datos.get(2).trim());
    		cantMayores = Integer.parseInt(datos.get(3).trim());
    		numeroNoche = Integer.parseInt(datos.get(4).trim());
    		festival = String.valueOf(datos.get(5));
    		
    		
		}
    	else
    		this.logIn();
    	
	}
	
	public void elegirButaca(){
		Festival festElegido=festivalDAO.getFestivalByName(festival);
		
		DataReader dataReader = new DataReader ();
		BandaDAO bandaDAO = new BandaDAO();
		NocheDAO nocheDAO = new NocheDAO();
		EstadioDAO estadioDao =  new EstadioDAO();
		//bandas = (Set<Banda>) bandaDAO.getAllBandas();
		noches =nocheDAO.getAllNoches();
		
		estadio = estadioDao.getEstadioById(festElegido.getEstadio().getIdEstadio());
        nocheElegida = noches.get(this.numeroNoche -1);
		nocheElegida.setEstadio(estadio);
        
		int cantidadButacas = cantJubilados + cantMayores + cantMenores;
		
		VentanaConButacasDecorator butaca = new VentanaConButacasDecorator(estadio,nocheElegida,frame,cantidadButacas);
    	sectores = butaca.seleccionarButacas();
    	
	}
	
	public void vender(){
		
    	VentanaInformarEntradasDecorator informator = new VentanaInformarEntradasDecorator(frame);
    	
    	compraAseptada = informator.informarEntradas(sectores, precio, nocheElegida,cantJubilados,cantMenores,cantMayores,festival);
	}

	public boolean isCompraAseptada() {
		return compraAseptada;
	}

	public void setCompraAseptada(boolean compraAseptada) {
		this.compraAseptada = compraAseptada;
	}
	
}

