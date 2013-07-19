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

		//
		// Sector sectorElegido = null;
		// System.out.println("Ingrese sector");
		// while (colorSectorElegido == '0' || invalido == true) {
		//
		// String aux = lee.readLine();
		// colorSectorElegido = aux.charAt(0);
		// for (Sector sectorRecorrido : estadio.getSectores()) {
		// if (sectorRecorrido.getUbicacion() == colorSectorElegido) {
		// sectorElegido = sectorRecorrido;
		// invalido = false;
		// break;
		// } else {
		// invalido = true;
		// System.out
		// .println("Ingrese un sector existente en el sistema...");
		// break;
		// }
		// }
		//
		// }
		//
		// System.out.println("Ingrese numero de fila");
		// invalido = true;
		// Fila filaElegida = null;
		// while (numeroFila == 0 || invalido == true) {
		//
		// numeroFila = Integer.parseInt(lee.readLine());
		// if (sectorElegido.getFilas().size() >= numeroFila) {
		// filaElegida = sectorElegido.getFilas().get(numeroFila - 1);
		// invalido = false;
		// } else {
		// invalido = true;
		// System.out
		// .println("Ingrese una fila existente en el sistema...");
		// }
		// }
		//
		// System.out.println("Ingrese numero butaca");
		// invalido = true;
		// while (numeroButaca == 0 || invalido == true) {
		//
		// numeroButaca = Integer.parseInt(lee.readLine());
		// if (filaElegida.getButacas().size() >= numeroButaca) {
		// butacaElegida = filaElegida.getButacas().get(numeroButaca - 1);
		// invalido = false;
		// } else {
		// invalido = true;
		// System.out
		// .println("Ingrese una butaca existente en el sistema...");
		// }
		// }
		//
		// if (unVendedor.vender(apeYNom, edad, butacaElegida, filaElegida,
		// sectorElegido, festival, nocheElegida, listaCategorias)) {
		// System.out.println("Se realizo la venta");
		//
		// } else {
		// System.out.println("No se vendio nada");
		// }
		//
		//
	}

	private static void createAndShowGUI() {
		// Create and set up the window.
		UIPrincipal principal = new UIPrincipal();
	}
}
