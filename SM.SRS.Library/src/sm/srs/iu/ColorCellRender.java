/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.iu;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *Clase encargada de crear los botones qeu formarán part ede lista de colores, así como 
 * de pasarles el color que cada uno deberá tener asociado.
 * @author Sergi Ruiz Sánchez
 */
public class ColorCellRender implements ListCellRenderer<Color>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Color> list, Color value, int index, boolean isSelected, boolean cellHasFocus) {
       PanelColor colors = new PanelColor(value);     
       return colors;
    }
    
}
