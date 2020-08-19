/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.eventos;

import java.awt.Color;
import java.awt.geom.Point2D;
import java.util.EventObject;

/**
 *Clase relativa a los eventos lanzados por un objeto Lienzo2DFinal
 * @author Sergi Ruiz Sánchez
 */
public class LienzoEvent extends EventObject{
    //Atributos
    /**
     * Punto en el que se encuentra el ratón
     */
    private Point2D point;  
    /**
     * Valores RGB del píxel donde se encuentra el ratón
     */
    private int rgb []; 
    /**
     * Si el ratón está fuera o no del lienzo
     */
    private boolean outside = false; 
    /**
     * Color del borde de la figura actual
     */
    private Color borderColor;  
    /**
     * Color de relleno de la figura actual
     */
    private Color fillColor;  
    /**
     *Si la figura está o no rellena
     */
    private boolean isFilled; 
    /**
     * Nivel de transparencia de la figura
     */
    private float transparency; 
    /**
     * Grosor del borde
     */
    private float thickness;  
    /**
     * Si estamos aplicando suavizado a los bordes o no
     */
    private boolean smooth; 
    /**
     * Tipo de gradiente aplicado
     */
    private String gradient;    
    /**
     * Tipo de patrón del borde
     */
    private String pattern; 

    
    /**
     * Constructor del evento de obtener las coordenadas y color del píxel 
     * @param source
     * @param point Punto en el que se encuentra el ratón
     * @param rgb Valor RGB de ese píxel
     */
    public LienzoEvent(Object source, Point2D point, int [] rgb) {
        super(source);
        this.point = point;
        this.rgb = rgb;
    }
    
    /**
     * Constructor del evento activado cuando salimos del lienzo con el ratón
     * @param source
     * @param out Si estamos o no fuera del ratón
     */
    public LienzoEvent(Object source, boolean out){
        super(source);
        this.outside = out;
    }
    
    /**
     * Constructor del evento para cambiar los atributos de la ventana
     * principal al clickar en una figura u otra
     * @param source
     * @param borderColor Color de borde de la figura
     * @param fillColor Color de relleno
     * @param isFilled Si está rellena o no la figura
     * @param transparency Nivel de transparencia de la figura
     * @param thickness Grosor del borde
     * @param smooth    Si estamos suavizando o no los bordes
     * @param gradient  Tipo de gradiente
     * @param pattern   Tipo de patrón del borde
     */
    public LienzoEvent(Object source, Color borderColor, Color fillColor, boolean isFilled, float transparency, float thickness, boolean smooth, String gradient,
    String pattern){
        super(source);
        this.borderColor = borderColor;
        this.fillColor = fillColor;
        this.isFilled = isFilled;
        this.transparency = transparency;
        this.thickness = thickness;
        this.smooth = smooth;
        this.gradient = gradient;
        this.pattern = pattern;
    }
    
    //--------------- GETTERS ------------------//
    /**
     * Método para obtener el punto sobre el que se encuentra
     * el ratón
     * @return Point2D punto en el que se encuentra el ratón
     */
    public Point2D getPoint(){
        return this.point;
    }
    
    /**
     * Método para obtener el valor RGB del píxel en el
     * que se encuentra el ratón
     * @return int[] con el valor RGB del píxel
     */
    public int [] getRgb(){
        return this.rgb;
    }
    
    /**
     * Método para obtener si el ratón está o no 
     * fuera del lienzo
     * @return boolean indicando si está o no fuera
     * del lienzo
     */
    public boolean getOutside(){
        return this.outside;
    }

    /**
     * Método para obtener el color del borde
     * de la figura
     * @return Color con el color del borde
     */
    public Color getBorderColor() {
        return this.borderColor;
    }

    /**
     * Método para obtener el color del relleno
     * de la figura
     * @return Color con el color de relleno de la figura
     */
    public Color getFillColor() {
        return this.fillColor;
    }
    
    /**
     * Método para obtener si la figura está o
     * no rellena
     * @return boolean indicando si la figura 
     * está rellena
     */
    public boolean getIsFilled() {
        return this.isFilled;
    }

    /**
     * Método para obtener el grado de transparencia
     * de la figura
     * @return float con el grado de transparencia
     * (entre 0.0F y 1.0F)
     */
    public float getTransparency() {
        return this.transparency;
    }

    /**
     * Método para obtener el grosor del borde
     * de la figura
     * @return float con el valor del grosor de
     * la figura
     */
    public float getThickness() {
        return this.thickness;
    }

    /**
     * Método para obtener si aplicamos o no
     * suavizado a los bordes
     * @return boolean inidicando si lo estamos
     * aplicando
     */
    public boolean getSmooth() {
        return this.smooth;
    }

    /**
     * Método para obtener el tipo de gradiente
     * @return String tipo de gradiente
     */
    public String getGradient() {
        return this.gradient;
    }
    
    /**
     * Método para obtener el tipo de patrón
     * del borde de la figura
     * @return String con el tipo de patrón
     */
    
    public String getPattern(){
        return this.pattern;
    }
}
