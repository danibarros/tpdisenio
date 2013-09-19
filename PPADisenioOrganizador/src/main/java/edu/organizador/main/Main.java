package edu.organizador.main;

import java.io.IOException;
import java.text.ParseException;

import edu.core.dao.CategoriaDAO;
import edu.core.entities.Categoria;
import edu.organizador.gui.UIPrincipal;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {
		Categoria categoria = new Categoria();
		categoria.setPrecio(100);
		CategoriaDAO categoriaDAO = new CategoriaDAO();
		categoriaDAO.save(categoria);
		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		UIPrincipal principal = new UIPrincipal();
	}
}
