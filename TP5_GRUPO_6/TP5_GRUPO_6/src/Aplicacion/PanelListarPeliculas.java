package Aplicacion;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Dominio.Peliculas;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PanelListarPeliculas extends JPanel {
	
	private JScrollPane scrollPane;
    private JList<Peliculas> jListadoPeliculas;
    private DefaultListModel<Peliculas> peliModel;
    


	
    public PanelListarPeliculas() {
   
    	 setLayout(null);
         jListadoPeliculas = new JList<Peliculas>();
         jListadoPeliculas.setBounds(105, 11, 277, 160);
         add(jListadoPeliculas);

         JLabel lblPelculas = new JLabel("Películas");
         lblPelculas.setFont(new Font("Tahoma", Font.BOLD, 13));
         lblPelculas.setBounds(47, 82, 72, 16);
         add(lblPelculas);

        
     }

 
     
	public DefaultListModel<Peliculas> getModel() {
		if (peliModel == null) {
            peliModel = new DefaultListModel<>();
        }
		return peliModel;
	}

	public void setModel(DefaultListModel<Peliculas> model) {
		
		if (jListadoPeliculas != null) {
			
			this.peliModel = model;
			ordenarModelo();
		jListadoPeliculas.setModel(this.peliModel);
		}else {
            System.err.println("jListadoPeliculas es null");
        }
	}
	
	// ordenar alfabéticamente 
    private void ordenarModelo() {
        List<Peliculas> listaPeliculas = Collections.list(peliModel.elements()); // Convierte en una lista
        Collections.sort(listaPeliculas, new Comparator<Peliculas>() { // Ordena la lista
            public int compare(Peliculas pelicula1, Peliculas pelicula2) {
                return pelicula1.getNombre().compareToIgnoreCase(pelicula2.getNombre());
            }
        });

        peliModel.clear(); // Limpia 
        for (Peliculas pelicula : listaPeliculas) {
            peliModel.addElement(pelicula); // Agrega las películas 
        }
    }

}

