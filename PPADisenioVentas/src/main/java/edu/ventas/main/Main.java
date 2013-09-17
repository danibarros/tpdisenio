package edu.ventas.main;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.persistence.HibernateUtil;

import edu.core.dao.PaisDAO;
import edu.core.entities.Banda;
import edu.core.entities.Butaca;
import edu.core.entities.Estadio;
import edu.core.entities.Festival;
import edu.core.entities.Fila;
import edu.core.entities.Noche;
import edu.core.entities.Pais;
import edu.core.entities.PuntoDeVenta;
import edu.core.entities.Sector;
import edu.core.entities.Vendedor;
import edu.ventas.gui.UIPrincipal;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {

		Pais pais = new Pais();
		pais.setNombre("Argentina");
		PaisDAO pasi = new PaisDAO();
		pasi.save(pais);
		pasi.getPaisByIdPais(1);
		
//		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		UIPrincipal principal = new UIPrincipal();
	}
}
