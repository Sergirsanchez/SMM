/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.iu;

import com.github.sarxos.webcam.Webcam;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * Clase creada para que, aunque en la lista de las cámaras aparezcan solo los nombres de estas, 
 * nos refiramos a objetos Webcam en sí, haciendo más fácil luego poder trabajar con ellos
 * @author Sergi Ruiz Sánchez
 */
public class CameraCellRenderer implements ListCellRenderer<Webcam>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Webcam> list, Webcam value, int index, boolean isSelected, boolean cellHasFocus) {
        JLabel camera = new JLabel("");
        camera.setText(value.getName());
        
        return camera;
    }
    
}
