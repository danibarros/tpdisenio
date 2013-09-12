package edu.organizador.controlador;

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
import edu.ventas.entities.Sector;
import edu.ventas.entities.Vendedor;
import edu.ventas.gui.VentanaConButacasDecorator;
import edu.ventas.gui.VentanaDespedidaDecorator;
import edu.ventas.gui.VentanaFormularioDecorator;
import edu.ventas.gui.VentanaInformarEntradasDecorator;
import edu.ventas.gui.VentanaInicioDecorator;



public class Controlador {
	
	private String nombreBanda;
	private int categoriaBanda;
	private String horarioInicio;
	private String estadio;
	private Banda banda;
	private Noche noche;
	
public void organiza(){
	VentanaOrganizador organizador = new VentanaOrganizador();
	organizador.cargarOrganizador();
}

}

