package edu.organizador.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import edu.core.dao.BandaDAO;
import edu.core.dao.CategoriaDAO;
import edu.core.dao.DataReader;
import edu.core.dao.DataReaderDAO;
import edu.core.dao.VendedorDAO;
import edu.core.entities.Banda;
import edu.core.entities.Categoria;
import edu.core.entities.Festival;
import edu.core.requests.UserValidationRequest;
import edu.core.utils.Validator;
import edu.organizador.gui.VentanaAlertDecorator;
//import edu.organizador.gui.VentanaCargarBandas;
import edu.organizador.gui.VentanaConNochesDecorator;
import edu.organizador.gui.VentanaInicioDecorator;
import edu.organizador.gui.VentanaLoginDecorator;
import external.utils.TablaOrdenBandas;

public class Controlador {
	private JFrame frame;
	private String estadio;
	private Festival festival = new Festival();
	List<String> datos = new ArrayList<String>();

	public Controlador(JFrame frame) {
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
    }
	
	public void iniciarJuego(){
		DataReaderDAO dataReader = new DataReader();
		VentanaInicioDecorator inicio = new VentanaInicioDecorator();
		inicio.cargarFormulario(festival);
	}
	
	public void organizarNoches(){
		VentanaConNochesDecorator ventana = new VentanaConNochesDecorator(festival.getNoches().size(), frame);
		festival.setNoches(ventana.seleccionarNoches());
		
		
	}

	public void guardarBanda(List<String> datos) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.findById(1);
		Banda banda = new Banda(datos.get(0), categoria);
		BandaDAO bandaDAO = new BandaDAO();
		bandaDAO.save(banda);	
	}
	
	public void guardarHorariosBanda( List<String> datos){
		Banda banda = new Banda();
		BandaDAO bandaDAO = new BandaDAO();
		int i = 0;
		
		while (datos.size()>=i){
//			banda.setHorario(datos.get(i+1));
			banda.setNombre(datos.get(i));
			// Aca iria el metodo creado en el bandaDao, donde inserta en la tabla
			//noche-banda, la banda y el horario
			i=i+3;
		}
		
	}

}
