package edu.organizador.gui;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.core.dao.CategoriaDAO;
import edu.core.entities.Banda;
import edu.core.entities.Categoria;
import edu.organizador.controlador.Controlador;

import java.awt.Color;
import java.awt.BorderLayout;

public class VentanaBandaDecorator implements VentanaDecoratorInterface {

	Banda banda;
	private JFrame frame;

@Override
public void dibujar() {

}
	
public List<String> cargarFormularioBandas(){
	
	List<String> datos = new ArrayList<String>();
	@SuppressWarnings({ "unchecked", "rawtypes" })
	JTextField txtNombreBanda = new JTextField("");
	JTextField field2 = new JTextField("");
	
	
//	CategoriaDAO categoriaDAO = new CategoriaDAO();
	
	JPanel panel = new JPanel(new GridLayout(0, 1));
	JLabel lblNombreBanda = new JLabel("Ingrese nombre de la banda");
	JLabel lblCategoria = new JLabel("Ingrese Categoria de la Banda");
	JComboBox cmbCategoria = new JComboBox<String>();
	
//	Set<Categoria> categorias = categoriaDAO.findAll();
//	for (Categoria categoria : categorias) {
//		cmbCategoria.addItem(categoria.getIdCategoria());
//	}
	
	
	panel.add(lblNombreBanda);
	panel.add(txtNombreBanda);	
	panel.add(lblCategoria);
	panel.add(cmbCategoria);
	
	int result = JOptionPane.showConfirmDialog(null, panel, "Selección",
			 JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	
	if (result == JOptionPane.OK_OPTION) { 
			if(txtNombreBanda.getText().equals("") || cmbCategoria.getSelectedItem().toString().equals("")) { 
				VentanaAlertDecorator alert = new VentanaAlertDecorator();
				alert.dibujar();
				this.cargarFormularioBandas();
				}
			else{
				datos.add(txtNombreBanda.getText());
				datos.add(cmbCategoria.getSelectedItem().toString());
				return datos; 
				}
	}else{
		
		VentanaConNochesDecorator ventana = new VentanaConNochesDecorator(Integer.valueOf(datos.get(1)), frame);
		ventana.seleccionarNoches();
	
	}
	return datos;
	
	}
}