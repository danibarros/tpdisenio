package edu.organizador.main;

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

import edu.ventas.entities.Banda;
import edu.ventas.entities.Butaca;
import edu.ventas.entities.Estadio;
import edu.ventas.entities.Festival;
import edu.ventas.entities.Fila;
import edu.ventas.entities.Noche;
import edu.ventas.entities.PuntoDeVenta;
import edu.ventas.entities.Sector;
import edu.ventas.entities.Vendedor;
import edu.ventas.gui.UIPrincipal;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {

		createAndShowGUI();
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		UIPrincipal principal = new UIPrincipal();
	}
}
