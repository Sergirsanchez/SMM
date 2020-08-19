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
 *Clase posterizar, encargada de reducir el número de colores de las imágenes
 * @author Sergi Ruiz Sánchez
 */
public class PosterizarOp extends BufferedImageOpAdapter{
    //Atributos
    /**
     * Número de niveles de color permitidos (se los pasamos como valor del slider)
     */
    private int niveles;    
    
    /**
     * Constructor por defecto
     * @param niveles número de niveles de color
     */
    public PosterizarOp (int niveles) {
        this.niveles = niveles;
    }
    
    /**
     * Método para crear el filtro aplicado previamente mencionado (reducir el número de colores)
     * @param src imagen de origen
     * @param dest imagen destino
     * @return BufferedImage imagen de destino
     */
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        int sample;
        float K = 256.0F/this.niveles;
                
        if (src == null) {
            throw new NullPointerException("src image is null");
        }
        
        if (dest == null) {
            dest = createCompatibleDestImage(src, null);
        }
        
        WritableRaster srcRaster = src.getRaster();
        WritableRaster destRaster = dest.getRaster();

        for (int x = 0; x < src.getWidth(); x++) {
            for (int y = 0; y < src.getHeight(); y++) {
                for (int band = 0; band < srcRaster.getNumBands(); band++) {
                    sample = srcRaster.getSample(x, y, band);
                    sample = (int)(K * (int)(sample/K));
                    destRaster.setSample(x, y, band, sample);
                }
            }
        }
        
        return dest ;
    }
    
    
}
