package geoanalytique.controleur;

import java.awt.event.*;

import geoanalytique.model.geoobject.operation.*;

/**
 * Classe Operation
 */
public class OperationControleur implements MouseListener, MouseMotionListener {
    
    private DeplacerPointOperation deplacerPointOperation;
    private boolean deplacementEnCours = false;

    private MedianeOperation medianeOperation;
    private boolean medianeEnCours = false;

    private ChangeNomOperation changeNomOperation;
    private boolean changementNomEnCours = false;

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}
