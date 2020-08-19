/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.graficos;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Composite;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *Clase abstracta que hereda de Shape, y la cual van a emplear el resto de 
 * figuras que creemos
 * @author Sergi Ruiz Sánchez
 */
public abstract class myShape implements Shape{
    //Atributos
    /**
     * Color del borde
     */
    private Color borderColor = Color.BLACK; 
    /**
     * Color de relleno
     */
    private Color fillColor = Color.BLACK;  
    
    /**
     * Grosor
     */
    private float thickness = 1.0f; 
    /**
     * Patrón de la línea de borde
     */
    private float pattern[] = {1.0f, 0.0f}; 
    private BasicStroke line = new BasicStroke(thickness,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER, 1.0f, pattern, 0.0f);
    /**
     * Borde
     */
    private Stroke stroke =(Stroke) line; 
    
    /**
     * Render de la figura (ver los bordes suavizados o no)
     */
    private RenderingHints render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    /**
     *Suavizado
     */
    private boolean smooth = false; 
    
    /**
     * Ver si la figura está o no rellena
     */
    private boolean refilled = false;   
    
    /**
     * En un principio creamos la figura con la transparencia al máximo
     */
    private float visibility = 1.0f;    
    private Composite transparency = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, visibility);
    
    /**
     *Tendrá valor "horizontal","vertical" o null
     */
    private String gradient = null;
    /**
     * Almacena color de gradiente
     */
    private Paint gradientColor = null; 
    /**
     * Rectángulo que alberga el boundingbox
     */
    private myRectangle boundingBox = null; 
    

    /**
     * Método pintar asociado a cada figura; Le asocia la objeto graphics2D el color del 
     * borde, patrón de este, transparencia y suavizado de bordes; Por último, mira si 
     * está o no relleno, para rellenarlo
     * 
     * @param g2d objeto Graphics2D proveniente de la clase Lienzo2DFinal 
     */
    public void pintar(Graphics2D g2d){
        
        if(this.boundingBox != null){
            this.boundingBox.pintar(g2d);
        }
                
        g2d.setPaint(this.borderColor);
        g2d.setStroke(stroke);
        g2d.setComposite(transparency);
        g2d.setRenderingHints(render);
        

        

        if(getShape() != null){ //Si tenemos figura
            if(getTypeOfShape() == "myLine"){ //Si es línea, la pintamos
                g2d.draw(this.getShape());
            }
                
            else{   //Si no es línea
                if(this.refilled == true ){  //Pero tiene relleno
                    g2d.draw(this.getShape());  //Pintamos y rellenamos la figura
                    g2d.setPaint(fillColor);
                    g2d.fill(this.getShape());
                }
                
                else{   //Si no va rellena, pintamos solo el contorno
                    g2d.draw(this.getShape());
                }
                
                if(this.gradient != "null" & this.gradient != null){
                    g2d.setPaint(gradientColor);
                    g2d.draw(this.getShape());  //Pintamos y rellenamos la figura
                    g2d.fill(this.getShape());
                }
            }
        }
    }
    
    
    //-----------------SETTERS--------------//
    /**
     * Método para establecer el color del borde
     * @param borderColor nuevo color del borde
     */
    public void setColor(Color borderColor){
        this.borderColor = borderColor;
    }
    
    /**
     * Método para indicar si la figura está o no rellena
     * @param refilled figura rellena o no
     */
    public void setRefilled(boolean refilled){
        this.refilled = refilled;
    }
    
    /**
     * Método para cambiar el grosor del borde
     * @param thickness nuevo grosor
     */
    public void setThickness(float thickness){
        this.thickness = thickness;
        this.line = new BasicStroke(thickness,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER, 1.0f, pattern, 0.0f);
        this.stroke = (Stroke) line;
    }
    
    /**
     * Método para cambiar el valor de la transparencia
     * @param f valor de la transparencia
     */
    public void setTransparency(float f){
        if(f <= 1.0f ){
            visibility = f;
        }
        
        if(f == 2.0f){  //El botón ya está marcado y lo volvemos a pulsar, por lo que ponemos la transparencia a 0
            visibility = 1.0F;
        }
        
        if( f == 3.0F){ //Si el botón no está pulsado y lo pulsamos, sea cual sea la transparencia, esta pasa a la mitad (0.5F)
            visibility = 0.5F;
        }
        transparency = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, visibility);
    }
    
    /**
     * Método para indicar si el objeto debe tener suavizado en los bordes o no
     * @param render suavizado o no de los bordes
     */
    public void setRender(boolean render){
        if(render == true){
            this.render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        else{
            this.render = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        }
        this.smooth = render;
    }
    
    /**
     * Método para asignarle una forma de borde a partir de una dada
     * @param s objeto de la clase Stroke que será el nuevo borde
     */
    public void setStroke(Stroke s){
        this.stroke = s;
    }
    

    /**
     * Método para indicar el nuevo tipo de patrón de borde (línea continua o punteada)
     * @param typeOfPattern String que nos indica el nuevo tipo de patrón
     */
    public void setPattern(String typeOfPattern){
        if(typeOfPattern == "Línea continua"){
            pattern[0] = 1.0f;
            pattern[1] = 0.0f;
        }
        
        else{
            pattern[0] = thickness;
            pattern[1] = thickness+5;
        }
        
        line = new BasicStroke(thickness,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_MITER, 1.0f, pattern, 0.0f);
        stroke = (Stroke) line;
    }
    
    /**
     * Método para indicar el nuevo tipo de gradiente
     * @param type String que indica el nuevo tipo de gradiente 
     * (horizontal, vertical o null)
     */
    
    public void setGradient(String type){
        if(type != "null"){
            this.gradient = type;
            this.calculateGradient(type);   
        }
        
        else{
            this.gradient = null;
            this.gradientColor = null;
        }
        
    }
    
    /**
     * Método para cambiar el color del relleno
     * @param fillColor nuevo color de relleno
     */
    
    public void setFillColor(Color fillColor){
        this.fillColor = fillColor;
    }
    
    /**
     * Método para establecer un boundingBox
     * @param rectangle rectángulo de boundingBox
     */
    public void setBoundingBox(myRectangle rectangle){
        this.boundingBox = rectangle;
    }
    

    
    //-----------------------GETTERS-----------------//
    
    /**
     * Método para devolver el patrón empleado
     * @return float[] con el tipo de patrón {1.0F,0.0F} en el caso de la 
     * línea continua y {thickness,thickness+5} en el caso de la línea
     * punteada
     */
    public float[] getPattern(){
        return this.pattern;
    }
    
    /**
     * Método para devolver el color del borde
     * @return Color color del borde
     */
    public Color getColor(){
        return this.borderColor;
    }
    
    /**
     * Método para devolver el grosor
     * @return float grosor
     */
    public float getThickness(){
        return this.thickness;
    }
    
    /**
     * Método para devolver si la figura está o no rellena
     * @return boolean objeto relleno o no
     */
    public boolean getRefilled(){
        return this.refilled;
    }
    
    /**
     * Método para obtener si el objeto tiene los bordes suavizados
     * @return boolean bordes suavizados o no
     */
    public boolean getSmooth(){
        return this.smooth;
    }
    
    /**
     * Método que devuelve el grado de transparencia
     * @return float grado de transparencia (entre 0.0F y 1.0F)
     */
    public float getTransparency(){
        return this.visibility;
    }
    
    /**
     * Método que devuelve el tipo de gradiente empleado
     * @return String tipo de gradiente
     */
    public String getGradient(){
        return this.gradient;
    }
    
    /**
     * Método que devuelve el tipo de color de relleno
     * @return Color color de relleno
     */

    public Color getFillColor(){
        return this.fillColor;
    }
    
    
    /**
     * Método para calcular el color del gradiente
     * @param type String con el tipo del gradiente
     */
     public void calculateGradient(String type){  
         
         float x1, y1;
         float x2, y2;

         if (type == "Vertical") {
             x1 = (float) this.getminX();
             y1 = (float) ((this.getminY() + this.getHeight()) / 2);
             x2 = (float) (this.getminX() + this.getWidth());
             y2 = y1;
             this.gradientColor = new GradientPaint(x1, y1, this.borderColor, x2, y2, fillColor);
         } 
         
         else if(type != "null"){
             x1 = (float) (this.getminX() + this.getWidth()) / 2;
             y1 = (float) this.getminY();
             x2 = x1;
             y2 = (float) (this.getminY() + this.getHeight());
             this.gradientColor = new GradientPaint(x1, y1, this.borderColor, x2, y2, fillColor);
         }
    }
    
    
    //MÉTODOS ABSTRACTOS (LOS DEFINIREMOS EN LOS HIJOS)//
    public abstract void setShape(Point2D p1, Point2D p2); //Vamos redimensionando la figura mientras hacemos el dragged al crearla
    public abstract Shape getShape();   //Obtener el atributo de la figura asociado a cada clase hija
    public abstract String getTypeOfShape();	//String que devuelve el tipo de figura
    public abstract void setLocation(Point2D p1); //Metodo para poder mover las figuras
    public abstract double getminX();
    public abstract double getminY();
    public abstract double getWidth();
    public abstract double getHeight();
}