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
	private JComboBox<String> cbGenero;
	private JList<Peliculas> jListPeliculas;
	private DefaultListModel<Peliculas> listModel;
	private List<Peliculas> listaPeliculas;

	
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
		
		cbGenero = new JComboBox<String>();
		GridBagConstraints gbc_cbGenero = new GridBagConstraints();
		gbc_cbGenero.insets = new Insets(0, 0, 5, 5);
		gbc_cbGenero.fill = GridBagConstraints.BOTH;
		gbc_cbGenero.gridx = 2;
		gbc_cbGenero.gridy = 3;
		add(cbGenero, gbc_cbGenero);
		
		cbGenero.addItem("Seleccione un g�nero");
		cbGenero.addItem("Terror");
		cbGenero.addItem("Acci�n");
		cbGenero.addItem("Suspenso");
		cbGenero.addItem("Rom�ntica");
		
		listModel = new DefaultListModel<>();
        jListPeliculas = new JList<>(listModel);
        GridBagConstraints gbc_jListPeliculas = new GridBagConstraints();
        gbc_jListPeliculas.gridheight = 2;
        gbc_jListPeliculas.gridwidth = 2;
        gbc_jListPeliculas.insets = new Insets(0, 0, 5, 5);
        gbc_jListPeliculas.fill = GridBagConstraints.BOTH;
        gbc_jListPeliculas.gridy = 4;
        add(jListPeliculas, gbc_jListPeliculas);
		
		JButton btnAceptar = new JButton("Aceptar");
		GridBagConstraints gbc_btnAceptar = new GridBagConstraints();
		gbc_btnAceptar.fill = GridBagConstraints.BOTH;
		gbc_btnAceptar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAceptar.gridx = 1;
		gbc_btnAceptar.gridy = 4;
		add(btnAceptar, gbc_btnAceptar);
		
		List <Peliculas> peli= new ArrayList<Peliculas>();
		
		btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
            	
            	 String nombrePelicula = txtNombre.getText();
                 Categorias genero = new Categorias();
                 genero.setNombre((String)cbGenero.getSelectedItem());
                 

                 if (!genero.equals("Seleccione un genero")) {
                     
                	 Peliculas nuevaPelicula = new Peliculas(nombrePelicula, genero);
                     listaPeliculas.add(nuevaPelicula);

                     
                     listModel.addElement(nuevaPelicula);

                    
                     txtNombre.setText("");
                     cbGenero.setSelectedIndex(0);
                   
                 } else {
                     
                     JOptionPane.showMessageDialog(PanelAgregarPeliculas.this, "Por favor, seleccione un género.", "Error", JOptionPane.ERROR_MESSAGE);
                 }
            }
        });
	}

}
