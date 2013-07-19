package edu.ventas.gui;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ventana extends JFrame implements VentanaInterface{
	protected UIPrincipal framework = null;

	public Ventana(UIPrincipal controller) {
		super("New Frame");
		framework = controller;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addWindowListener(framework);

		JMenu menu = new JMenu("Window");
		menu.setMnemonic(KeyEvent.VK_W);
		JMenuItem item = null;
		// close
		item = new JMenuItem("Close");
		item.setMnemonic(KeyEvent.VK_C);
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Close window");
				Ventana.this.setVisible(false);
				Ventana.this.dispose();
			}
		});
		menu.add(item);

		// new
		item = new JMenuItem("New");
		item.setMnemonic(KeyEvent.VK_N);
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("New window");
				framework.makeNewWindow();
			}
		});
		menu.add(item);

		// quit
		item = new JMenuItem("Quit");
		item.setMnemonic(KeyEvent.VK_Q);
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Quit request");
				framework.quit(Ventana.this);
			}
		});
		menu.add(item);

		JMenuBar menuBar = new JMenuBar();
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		this.setExtendedState(Frame.MAXIMIZED_BOTH);  
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
}
