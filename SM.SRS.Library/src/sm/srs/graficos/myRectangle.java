/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.graficos;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *Clase que representa un objeto de tipo rectángulo; Usa a la clase abstracta myShape
 * @author Sergi Ruiz Sánchez
 */
public class myRectangle extends myShape{
    //Atributos
    /**
     * Nombre del tipo de figura
     */
    private static final String type = "myRectangle";
    /**
     * Objeto con el que operaremos
     */
    private Rectangle2D.Double rectangle; 

    /**
     * Constructor a partir de un punto con tamaño 1x1
     * @param p1 punto
     */
    
     public myRectangle(Point2D p1){
        rectangle = new Rectangle2D.Double(p1.getX(), p1.getY(), 1, 1);
    }
    
     /**
      * Constructor a partir de un punto, un alto y un ancho dados
      * @param x valor en x
      * @param y valor en y
      * @param w ancho
      * @param h alto
      */
    public myRectangle(double x, double y, double w, double h){
        rectangle = new Rectangle2D.Double(x,y,w,h);
    }
    
    /**
     * Constructor a partir de otro rectángulo
     * @param r rectángulo de base
     */
    
    public myRectangle(Rectangle2D.Double r){
        rectangle = r;
    }
    
    //------------------------- SETTERS ----------------------//
    
    /**
     * Método que nos permite poder la forma del rectángulo mientras lo
     * estamos creando (durante el dragged)
     * @param p1 punto inicial
     * @param p2 punto móvil
     */
    @Override
    public void setShape(Point2D p1, Point2D p2) {
        if(this.rectangle != null){
            rectangle.setFrameFromDiagonal(p1, p2);
        }
    }
    
        /**
     * Método que nos permite mover el objeto cuando estamos en edición,
     * ajustando el punto en el que pinchemos de el con el centro del 
     * rectángulo
     * @param p1 punto donde hemos hecho pressed
     */
    @Override
    public void setLocation(Point2D p1) {
        this.rectangle.setFrame((p1.getX())-(this.rectangle.getWidth()/2),p1.getY()-(this.rectangle.getHeight()/2),this.rectangle.getWidth(),this.rectangle.getHeight());
    }
    
    //-------------------- GETTERS ---------------------//

    /**
     * Método que nos permite devolver el objeto Rectangle2D.Double
     * @return Shape objeto Rectangle2D.Double
     */
    @Override
    public Shape getShape() {
        if(this.rectangle != null){
            return this.rectangle;
        }
        return null;
    }

    /**
     * Método para devolver en formato de String el tipo
     * de objeto que estamos usando
     * @return String con el tipo de objeto
     */
    @Override
    public String getTypeOfShape() {
        return this.type;
    }


    /**
     * Método que devuelve el valor mínimo de la X (esquina superior izquierda)
     * @return double valor mínimo de la X
     */
    @Override
    public double getminX() {
        return this.rectangle.getMinX();
    }

    /**
     * Método que devuelve el valor mínimo de la Y (esquina superior izquierda)
     * @return double valor mínimo de la Y
     */
    @Override
    public double getminY() {
       return this.rectangle.getMinY();
    }

    /**
     * Método que devuelve el ancho del rectángulo
     * @return double valor ancho
     */
    @Override
    public double getWidth() {
        return this.rectangle.getWidth();
    }

    /**
     * Método que devuelve el alto del rectángulo
     * @return double alto del rectángulo
     */
    @Override
    public double getHeight() {
      return this.rectangle.getHeight();
    }
    
    /**
     * Método que nos devuelve el boundinbox del rectángulo
     * @return Rectangle2D boundingbox
     */
    @Override
    public Rectangle2D getBounds2D() {
        if(this.rectangle != null){
            return this.rectangle.getBounds2D();
        }
        
        return null;
    }

    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public boolean contains(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Método que nos devuelve si un punto está dentro
     * de la figura o no
     * @param p punto en el que hemos hecho pressed
     * @return boolean indicando si el punto está o no
     * dentro del rectángulo
     */

    @Override
    public boolean contains(Point2D p) {
        return this.rectangle.contains(p);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Rectangle2D r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
