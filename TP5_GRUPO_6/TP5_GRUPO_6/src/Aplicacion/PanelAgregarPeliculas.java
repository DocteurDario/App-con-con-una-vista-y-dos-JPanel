package Aplicacion;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import Dominio.Categorias;
import Dominio.Peliculas;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class PanelAgregarPeliculas extends JPanel {
	
	private JTextField txtNombre;
	private JComboBox<Categorias> cbGenero;
	private DefaultListModel <Peliculas> listaPeliculas;
	

	
	public PanelAgregarPeliculas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{59, 133, 159, 59, 0};
		gridBagLayout.rowHeights = new int[]{16, 34, 34, 34, 34, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.gridwidth = 2;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.gridx = 2;
		gbc_label_1.gridy = 0;
		add(label_1, gbc_label_1);
		
		JLabel lbliD = new JLabel("ID");
		GridBagConstraints gbc_lbliD = new GridBagConstraints();
		gbc_lbliD.anchor = GridBagConstraints.WEST;
		gbc_lbliD.insets = new Insets(0, 0, 5, 5);
		gbc_lbliD.gridx = 1;
		gbc_lbliD.gridy = 1;
		add(lbliD, gbc_lbliD);
		
		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 5);
		gbc_txtNombre.fill = GridBagConstraints.BOTH;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblGnero = new JLabel("G\u00E9nero");
		GridBagConstraints gbc_lblGnero = new GridBagConstraints();
		gbc_lblGnero.anchor = GridBagConstraints.WEST;
		gbc_lblGnero.insets = new Insets(0, 0, 5, 5);
		gbc_lblGnero.gridx = 1;
		gbc_lblGnero.gridy = 3;
		add(lblGnero, gbc_lblGnero);
		
		cbGenero = new JComboBox<Categorias>();
		cbGenero.addItem(new Categorias("Seleccione un género"));
		cbGenero.addItem(new Categorias("Terror"));
		cbGenero.addItem(new Categorias("Acción"));
		cbGenero.addItem(new Categorias("Suspenso"));
		cbGenero.addItem(new Categorias("Romántica"));
		GridBagConstraints gbc_cbGenero = new GridBagConstraints();
		gbc_cbGenero.insets = new Insets(0, 0, 5, 5);
		gbc_cbGenero.fill = GridBagConstraints.BOTH;
		gbc_cbGenero.gridx = 2;
		gbc_cbGenero.gridy = 3;
		add(cbGenero, gbc_cbGenero);
		
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 4;
		add(btnAceptar, gbc_btnAceptar);
		
		List <Peliculas> peli= new ArrayList<>();
		
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                 Categorias categoria = (Categorias) cbGenero.getSelectedItem();

                 if (!categoria.getNombre().equals("Seleccione un género")) {
                     	
                	 System.out.println("entro");

                     Peliculas nuevaPelicula = new Peliculas(txtNombre.getText(),categoria);

                    
                     listaPeliculas.addElement(nuevaPelicula);
                     
                     System.out.println(listaPeliculas);
                     txtNombre.setText("");
                   
                 } else {
                     
                     JOptionPane.showMessageDialog(PanelAgregarPeliculas.this, "Por favor, seleccione un gÃ©nero.", "Error", JOptionPane.ERROR_MESSAGE);
                 }
            }
        });
	}
	
	public void setDefaultListModel(DefaultListModel<Peliculas> listModel2)
	{
		this.listaPeliculas = listModel2;
		
	}

}
