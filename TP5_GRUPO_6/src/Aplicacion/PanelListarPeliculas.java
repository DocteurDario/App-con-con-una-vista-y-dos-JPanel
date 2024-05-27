package Aplicacion;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import Dominio.Categorias;
import Dominio.Peliculas;

import javax.swing.JLabel;
import java.awt.Font;

public class PanelListarPeliculas extends JPanel{
	private static JList jListadoPeliculas;
	private static DefaultListModel <Peliculas> model;
	
    public PanelListarPeliculas() {
   
    	setLayout(null);
    	
    	jListadoPeliculas = new JList();
    	jListadoPeliculas.setBounds(105, 11, 277, 160);
    	add(jListadoPeliculas);
    	
    	JLabel lblPelculas = new JLabel("Pel\u00EDculas");
    	lblPelculas.setFont(new Font("Tahoma", Font.BOLD, 13));
    	lblPelculas.setBounds(47, 82, 72, 16);
    	add(lblPelculas);  
   
	}

	public static DefaultListModel getModel() {
		return model;
	}

	public static void setModel(DefaultListModel model) {
		PanelListarPeliculas.model = model;
	}
    
	
    public static void setListModel(DefaultListModel<Peliculas> model) {
        PanelListarPeliculas.model = model;
        jListadoPeliculas.setModel(model); 
    }
   
}

class VentanaListarPeliculas implements AgregarPeliculaListener {
    public VentanaListarPeliculas() {
        
        ventanaAgregarPeliculas.addAgregarPeliculaListener(this);
    }

    @Override
    public void peliculaAgregada(AgregarPeliculaEvent event) {
        
        Peliculas pelicula = event.getPelicula();
       
    }
}
