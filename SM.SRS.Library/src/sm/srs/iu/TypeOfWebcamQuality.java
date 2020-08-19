/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.iu;

import com.github.sarxos.webcam.Webcam;
import java.util.List;

/**
 *Clase del JDialog con el que daremos al usuario la posibilidad de escoger una cámara
 * de entre las que dispone, y su calidad
 * @author Sergi Ruiz Sánchez
 */
public class TypeOfWebcamQuality extends javax.swing.JDialog {
    //Atributos
    /**
     * Calidad alta
     */
    private boolean high = false;  
    /**
     * Calidad media
     */
    private boolean medium = false; 
    /**
     * Calidad baja
     */
    private boolean low = false;   
    /**
     * Webcam seleccionada por el usuario
     */
    private Webcam selectedWebcam = null;   

    /**
     * Constructor por defecto
     */
    public TypeOfWebcamQuality(){
        initComponents();
        
        List <Webcam> totalCams = Webcam.getWebcams(); //Como no conocemos a priori el número de cámaras, las introducimos así dentro de la lista

        
        for(Webcam cam: totalCams){
            listOfWebcams.addItem(cam);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        HighQuality = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        MediumQuality = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LowQuality = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        listOfWebcams = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 250));

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 1));

        HighQuality.setText("Alta calidad");
        HighQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HighQualityActionPerformed(evt);
            }
        });
        jPanel1.add(HighQuality);

        jPanel2.setPreferredSize(new java.awt.Dimension(15, 15));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);

        MediumQuality.setText("Calidad Media");
        MediumQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MediumQualityActionPerformed(evt);
            }
        });
        jPanel1.add(MediumQuality);

        jPanel3.setPreferredSize(new java.awt.Dimension(15, 15));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3);

        LowQuality.setText("Baja calidad");
        LowQuality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LowQualityActionPerformed(evt);
            }
        });
        jPanel1.add(LowQuality);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Escoge la calidad:");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(49, 100));
        jPanel4.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setPreferredSize(new java.awt.Dimension(400, 28));

        listOfWebcams.setLightWeightPopupEnabled(false);
        listOfWebcams.setPreferredSize(new java.awt.Dimension(300, 28));
        listOfWebcams.setRenderer(new CameraCellRenderer());
        listOfWebcams.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listOfWebcamsActionPerformed(evt);
            }
        });
        jPanel5.add(listOfWebcams);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void HighQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HighQualityActionPerformed
        this.high = true;
        dispose();

    }//GEN-LAST:event_HighQualityActionPerformed

    private void MediumQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MediumQualityActionPerformed
        this.medium = true;
        dispose();
    }//GEN-LAST:event_MediumQualityActionPerformed

    private void LowQualityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LowQualityActionPerformed
        this.low = true;
        dispose();
    }//GEN-LAST:event_LowQualityActionPerformed

    private void listOfWebcamsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listOfWebcamsActionPerformed
       selectedWebcam = (Webcam) listOfWebcams.getSelectedItem();
    }//GEN-LAST:event_listOfWebcamsActionPerformed

    /**
     * Método para devolver como un String la calidad deseada, para poder pasársela
     * posteriormente a la clase ventanaInternaCamara
     * @return quality String con la calidad escogida
     */
    public String getQuality(){
        String quality = null;
        
        if(high == true){
            quality = "high";
        }
        
        else if(medium == true){
            quality = "medium";
        }
        
        else if (low == true){
            quality = "low";
        }
        
        else{   /*No escogemos ninguna*/
            quality = null;
        }
        return quality;
    }
    
    /**
     * Método para devolver la webcam escogida de la lista de disponibles
     * @return selectedWebcam parámetro de la clase que nos indica la webcam que se ha escogido
     */
    public Webcam getWebcam(){
        return selectedWebcam;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton HighQuality;
    private javax.swing.JButton LowQuality;
    private javax.swing.JButton MediumQuality;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<Webcam> listOfWebcams;
    // End of variables declaration//GEN-END:variables
}
