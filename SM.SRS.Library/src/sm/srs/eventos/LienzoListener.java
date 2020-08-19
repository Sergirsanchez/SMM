/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.eventos;

/**
 *Interfaz que deben cumplir los manejadores de eventos
 * @author Sergi Ruiz Sánchez
 */
public interface LienzoListener {
    /**
     * Método que nos da las coordenadas
     * en la que tenemos el ratón, así como
     * el píxel donde nos encontramos
     * @param evt evento recogido desde Lienzo2DFinal
     */
    public void setCoordinates(LienzoEvent evt);
    
    /**
     * Método que nos indica si el ratón ha salido
     * del lienzo
     * @param evt  evento recogido desde Lienzo2DFinal
     */
    public void isOutside (LienzoEvent evt);
    
    /**
     * Método para cambiar los parámetros de la 
     * ventana principal al hacer pressed en una
     * figura u otra
     * @param evt evento recogido desde Lienzo2DFinal
     */
    public void changeParameters(LienzoEvent evt);
}
