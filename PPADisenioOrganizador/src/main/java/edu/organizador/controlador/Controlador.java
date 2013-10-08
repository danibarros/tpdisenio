package edu.organizador.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;

import edu.core.dao.BandaDAO;
import edu.core.dao.CategoriaDAO;
import edu.core.dao.DataReader;
import edu.core.dao.DataReaderDAO;
import edu.core.dao.DataReaderHibernate;
import edu.core.entities.Banda;
import edu.core.entities.Categoria;
import edu.core.entities.Noche;
import edu.organizador.gui.VentanaConNochesDecorator;
import edu.organizador.gui.VentanaInicioDecorator;
import edu.organizador.gui.VentanaLoginDecorator;

public class Controlador {
	private JFrame frame;
	private String estadio;
	List<String> datos = new ArrayList<String>();

	public Controlador(JFrame frame) {
		this.frame = frame;
	}
	
    public void logIn(){
    	List<String> datos;
    	VentanaLoginDecorator login = new VentanaLoginDecorator();
    	datos = login.login();
    }
	
	public void iniciarJuego(){
		DataReaderDAO dataReader = new DataReader();
		VentanaInicioDecorator inicio = new VentanaInicioDecorator();
		datos = inicio.cargarFormulario();
	}
	
	public void organizarNoches(){
		BandaDAO bandaDAO = new BandaDAO();
		Set<Banda> bandas = bandaDAO.findAll();
		
		VentanaConNochesDecorator ventana = new VentanaConNochesDecorator(Integer.valueOf(datos.get(1)), frame);
		ventana.seleccionarNoches();
	}

	public void guardarBanda(List<String> datos) {
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		Categoria categoria = categoriaDAO.findById(1);
		Banda banda = new Banda(datos.get(0), categoria);
		BandaDAO bandaDAO = new BandaDAO();
		bandaDAO.save(banda);	
	}

}
