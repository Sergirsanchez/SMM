/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.iu;

import java.awt.Component;
import java.util.Hashtable;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *Clase renderer de la lista de los contrastes (normal, iluminado, oscurecido, negativo)
 * @author Sergi Ruiz Sánchez
 */
public class contrastCellRenderer implements ListCellRenderer<String>{


    @Override
    public Component getListCellRendererComponent(JList list, String value,int index, boolean isSelected, boolean cellHasFocus) {
        PanelContrast values = new PanelContrast(value);       
        return values;
    }  
}
