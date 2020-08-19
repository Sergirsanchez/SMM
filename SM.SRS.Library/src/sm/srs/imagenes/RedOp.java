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
 *Clase que implemente la operación RedOp, la cual coge los pixeles con valores
 * de rojo por debajo del umbral estimado y los pone a color gris.
 * @author Sergi Ruiz Sánchez
 */
public class RedOp extends BufferedImageOpAdapter{
    //Atributos
    /**
     * Umbral mínimo para considerarse lo suficientemente rojo o 
     * no, pasado desde ventana principal
     */
    private int umbral; 
                        

    /**
     * Constructor por defecto
     * @param umbral valor pasado para estimar el mínimo umbral del valor rojo
     */
    public RedOp(int umbral) {
        this.umbral = umbral;
    }

    /**
     * Método que determina si un pixel es lo suficientemente rojo (por encima
     * o no del umbral); En el caso de que lo sea, lo deja tal cual; Si no, lo
     * pinta de gris.
     * @param src imagen origen
     * @param dest imagen destino
     * @return BufferedImage imagen de destino
     */
    @Override
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
                
                if((pixelComp[0] - pixelComp[1] - pixelComp[2]) >= umbral){
                   pixelCompDest = pixelComp; 
                }
                
                
                else{
                    float grey = (pixelComp[0]+pixelComp[1]+pixelComp[2])/3;
                    pixelCompDest[0] = (int)grey;
                    pixelCompDest[1] = (int)grey;
                    pixelCompDest[2] = (int)grey;
                    
                }
                
                destRaster.setPixel(x, y, pixelCompDest);
            }
        }
        
        return dest ;
    }

}
