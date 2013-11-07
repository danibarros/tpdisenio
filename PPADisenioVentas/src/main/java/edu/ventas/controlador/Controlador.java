package edu.ventas.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;

import edu.core.dao.BandaDAO;
import edu.core.dao.DataReader;
import edu.core.dao.DataReaderDAO;
import edu.core.dao.FestivalDAO;
import edu.core.dao.NocheDAO;
import edu.core.dao.PuntoDeVentaDAO;
import edu.core.dao.VendedorDAO;
import edu.core.entities.Banda;
import edu.core.entities.Butaca;
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
	private PuntoDeVenta puntoDeVentaDeVendedor;
	private JFrame frame;
	private Map<String,List<Butaca>> sectores = null;
	private Noche nocheElegida;
	double precio;
	private Vendedor vendedor;
	private Estadio estadio;
	private Integer cantJubilados;
	private Integer cantMayores;
	private Integer cantMenores;
	private boolean compraAseptada = false;
	private Set<Banda> bandas;
	private List<Noche> noches;
	
	
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
		BandaDAO bandaDAO = new BandaDAO();
		NocheDAO nocheDAO = new NocheDAO();
		bandas = (Set<Banda>) bandaDAO.findAll();
		noches = nocheDAO.getAllNoches();

		VentanaFormularioDecorator form = new VentanaFormularioDecorator();
		
    	datos = form.cargarFormulario(noches);
    	if (null != datos) {
    		apeYNom = datos.get(0);
        	edad = Integer.parseInt(datos.get(1));
        	cantJubilados = Integer.parseInt(datos.get(2));
        	cantMenores = Integer.parseInt(datos.get(3));
        	cantMayores = Integer.parseInt(datos.get(4));
        	numeroNoche = Integer.parseInt(datos.get(5));
		}
    	else
    		this.logIn();
    	
	}
	
	public void elegirButaca(){
		DataReader dataReader = new DataReader ();
		BandaDAO bandaDAO = new BandaDAO();
		NocheDAO nocheDAO = new NocheDAO();
		//bandas = (Set<Banda>) bandaDAO.getAllBandas();
		noches =nocheDAO.getAllNoches();
		
		estadio = dataReader.getEstadio(dataReader.getSectores(dataReader.getFilas(dataReader.getButacas1(), dataReader.getButacas2())),dataReader.getPuntosDeVenta());
        nocheElegida = noches.get(this.numeroNoche -1);
		nocheElegida.setEstadio(estadio);
        
		VentanaConButacasDecorator butaca = new VentanaConButacasDecorator(estadio,nocheElegida,frame);
    	sectores = butaca.seleccionarButacas();
    	
	}
	
	public void vender(){
    	VentanaInformarEntradasDecorator informator = new VentanaInformarEntradasDecorator(frame);
    	
    	compraAseptada = informator.informarEntradas(sectores, precio, nocheElegida,vendedor,edad,cantJubilados,cantMenores,cantMayores);
	}

	public boolean isCompraAseptada() {
		return compraAseptada;
	}

	public void setCompraAseptada(boolean compraAseptada) {
		this.compraAseptada = compraAseptada;
	}
	
}

