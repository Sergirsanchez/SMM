/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.imagenes;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 *Clase que implementa una operación pixel a pixel; Consiste en ver si el pixel
 * es lo suficientemente rojo (está por encima del umbral) y si lo está lo pinta 
 * de morado; si no, lo deja tal cual
 * 
 * @author Sergi Ruiz Sánchez
 */
public class redToPurple extends BufferedImageOpAdapter{
    //Atributos
    /**
     * Umbral mínimo para ser considerado "suficientemente" rojo (dado desde la ventana principal)
     */
   private int umbral;  

   /**
    * Constructor por defecto
    * @param umbral umbral mínimo de rojo, proviene de ventana principal
    */
    public redToPurple(int umbral) {
        this.umbral = umbral;
    }

    /**
     * El filtro consiste en convertir los píxeles los suficientemente rojos a morado;
     * Si no, los deja tal cual están
     * @param src imagen de origen
     * @param dest imagen de destino
     * @return BufferedImage imagen de destino
     */
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();
        
        int[] pixelComp = new int[srcRaster.getNumBands()];
        int[] pixelCompDest = new int[srcRaster.getNumBands()];
        
        
        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                srcRaster.getPixel(x, y, pixelComp);
               
               
               /*Rojo color predominante y por encima del umbral --> Hacemos la transición */
               if((pixelComp[0]) > (pixelComp[1] + pixelComp[2]) & pixelComp[0] >= umbral){
                   pixelCompDest[0] = pixelComp[0];
                   pixelCompDest[1] = pixelComp[1];
                   pixelCompDest[2] = pixelComp[0];
                }
                
                
                else{
                    pixelCompDest = pixelComp;    
                }
                
                
                destRaster.setPixel(x, y, pixelCompDest);
            }
        }
        
        return dest ;
    }

}
