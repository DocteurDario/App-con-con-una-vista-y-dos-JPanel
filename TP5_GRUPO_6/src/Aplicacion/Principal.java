package Aplicacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dominio.Categorias;
import Dominio.Peliculas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
    DefaultListModel<Peliculas> model = new DefaultListModel<>();



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Principal() {
		setTitle("Administrador Películas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenuPeliculas = new JMenu("Películas");
		menuBar.add(mnMenuPeliculas);
		
		
		JMenuItem menuItemAddPelicula = new JMenuItem("Agregar");
		menuItemAddPelicula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				contentPane.removeAll();
				PanelAgregarPeliculas panelPelicula = new PanelAgregarPeliculas();
				contentPane.add(panelPelicula);
				contentPane.repaint();
				contentPane.revalidate();
			}
		});
		mnMenuPeliculas.add(menuItemAddPelicula);
		
		JMenuItem menuItemListPeliculas = new JMenuItem("Listar");
		
		// Menu Lista de Peliculas....
		menuItemListPeliculas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.removeAll();
				PanelListarPeliculas panelListarPeliculas = new PanelListarPeliculas(/*model*/);
				panelListarPeliculas.setListModel(model);
				contentPane.add(panelListarPeliculas);				
				contentPane.repaint();
				contentPane.revalidate();
				
				
			}
		});
		mnMenuPeliculas.add(menuItemListPeliculas);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	

}
