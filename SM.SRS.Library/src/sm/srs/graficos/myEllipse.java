/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.graficos;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *Clase que representa un objeto de tipo elipse; Usa a la clase abstracta myShape
 * @author Sergi Ruiz Sánchez
 */
public class myEllipse extends myShape{
    //Atributos
    /**
     * Nombre del tipo de figura
     */
    private static final String type = "myEllipse"; 
    /**
     * Objeto con el que operaremos
     */
    private Ellipse2D.Double ellipse;   
    
    /**
     * Constructor por defecto (creamos una elipse a partir de un 
     * punto, con valores de alto y ancho 1)
     * @param p punto 
     */
    public myEllipse(Point2D p){
        this.ellipse = new Ellipse2D.Double(p.getX(), p.getY(), 1, 1);
    }
    

    //--------------------- SETTERS ----------------------------//

    /**
     * Método para poder ver la elipse mientras la creamos
     * durante el dragged
     * @param p1 punto original de la figura
     * @param p2 punto móvil
     */
    @Override
    public void setShape(Point2D p1, Point2D p2) {
        if(this.ellipse != null){
            this.ellipse.setFrameFromDiagonal(p1, p2);
        }
    }
    
    /**
     * Método para que cuando movamos la figura en la edición
     * establezca en el punto donde hemos hecho pressed el 
     * centro de la figura
     * @param p1 punto de pressed
     */
    @Override
    public void setLocation(Point2D p1) {
        this.ellipse.setFrame((p1.getX())-(this.ellipse.getWidth()/2),p1.getY()-(this.ellipse.getHeight()/2),this.ellipse.getWidth(),this.ellipse.getHeight());

    }
    
    //----------------GETTERS-----------------------//
    
    /**
     * Método para obtener el objeto Ellipse2D.Double
     * @return Shape el objeto Ellipse2D.Double
     */
      @Override
    public Shape getShape() {
        if(this.ellipse != null){
            return this.ellipse;
        }
        
        return null;
    }

    /**
     * Método para obtener en String el tipo de figura
     * @return String con el tipo de figura
     */
    @Override
    public String getTypeOfShape() {
        return this.type;
    }
    
    /**
     * Método para obtener el mínimo valor de las X
     * (esquina superior izquierda)
     * @return double con el valor mínimo de las X
     */
    @Override
    public double getminX() {
        return this.ellipse.getMinX();
    }

    /**
     * Método para obtener el mínimo valor de las Y
     * (esquina superior izquierda)
     * @return double con el valor mínimo de las Y
     */
    @Override
    public double getminY() {
      return this.ellipse.getMinY();
    }

    /**
     * Método para obtener el ancho de la figura
     * @return double con el ancho de la figura
     */ 
    @Override
    public double getWidth() {
        return this.ellipse.getWidth();
    }

     /**
     * Método para obtener el alto de la figura
     * @return double con el alto de la figura
     */ 
    @Override
    public double getHeight() {
        return this.ellipse.getHeight();
    }
        
    /**
     * Método para obtener el boundingBox de la figura
     * @return Rectangle2D con el boundingBox
     */
    @Override
    public Rectangle2D getBounds2D() {
        return this.ellipse.getBounds2D();
    }

    /**
     * Método para ver si el punto en el que 
     * hemos hecho pressed se encuentra dentro
     * de la elipse
     * @param p punto de pressed
     * @return boolean indicando si el punto está
     * o no dentro de la elipse
     */
    @Override
    public boolean contains(Point2D p) {
        return this.ellipse.contains(p);
    }
    

    @Override
    public Rectangle getBounds() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(double x, double y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
