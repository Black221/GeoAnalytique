package geoanalytique.view;

import javax.swing.*;

import geoanalytique.exception.VisiteurException;
import geoanalytique.model.GeoObject;
import geoanalytique.util.Presentateur;

import java.awt.*;
import java.util.ArrayList;

public class GeoInfoView extends JPanel {
    
    private ArrayList<GeoObject> objets;
    private Presentateur presentateur = new Presentateur();
    JPanel container;
    /**
     * Constructeur de la classe GeoInfoView
     */
    public GeoInfoView() {
        super();
        this.init();
    }

    /**
     * Initialisation de la vue
     */
    public void init() {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Color.WHITE);        
        this.setPreferredSize(new Dimension(400, 0));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //scrollable
        this.container = new JPanel( new BorderLayout() );
        this.container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        this.container.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(container);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400, 0));
        this.add(scrollPane);

        this.objets = new ArrayList<GeoObject>();
    }

    /**
     * Ajoute un objet géométrique à la liste des objets
     * @param obj
     */
    public void addGeoObject(GeoObject obj) {
        this.objets.add(obj);
        
        try {
            this.container.add(obj.acceptJPanel(presentateur));
        } catch (VisiteurException e) {
            
        }
    }

    public ArrayList<GeoObject> getObject() {
        return this.objets;
        
    }

    /**
     * Supprime un objet géométrique de la liste des objets
     * @param obj
     */
    public void removeGeoObject(GeoObject obj) {
        this.objets.remove(obj);
    }

    /**
     * Efface les elements dessines
     */
    public void clearObject(){
        this.objets.clear();
        this.container.removeAll();
    }


    /**
     * Affiche les informations des objets géométriques dans la liste sur l'inteface graphique
     */
    public void afficherInfo() {
        this.revalidate();
        this.repaint();
    }   
}
