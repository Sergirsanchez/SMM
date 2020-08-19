/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sm.srs.graficos;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *Clase que representa un objeto de tipo Línea; Usa a la clase abstracta myShape
 * @author Sergi Ruiz Sánchez
 */
public class myLine extends myShape{
    //Atributos
    /**
     * Nombre del tipo de figura
     */
    private static final String type = "myLine"; 
    /**
     *Objeto con el que operaremos
     */
    private Line2D.Double line; 

    /**
     * Punto para usarlo en el método setLocation
     */
    private Point2D newp1 = new Point2D.Double(); 
      /**
     * Punto para usarlo en el método setLocation
     */
    private Point2D newp2 = new Point2D.Double();
    
     
    
    /**
     * Constructor por defecto
     */
    public myLine(){
        line = new Line2D.Double();
    }
    
    /**
     * Constructor que dadas las coordenadas de dos puntos construye la recta
     * @param x1 x del primer punto
     * @param y1 y del primer punto
     * @param x2 x del segundo punto
     * @param y2 y del segundo punto
     */
    public myLine(double x1, double y1, double x2, double y2){
        line = new Line2D.Double(x1, y1, x2, y2);
    }
    
    /**
     * Constructor que dados dos puntos construye la recta
     * @param p1 punto de inicio
     * @param p2 punto de fin
     */
    
    public myLine(Point2D p1, Point2D p2) {
        line = new Line2D.Double(p1, p2);
    }
    

    //-------------------------GETTERS------------------------//

    /**
     * Método para obtener el valor de x en el punto de 
     * inicio de la recta
     * @return double x del punto de inicio de la recta
     */
    public double getX1(){
        return this.line.getX1();
    }
    
    /**
     * Método para obtener el valor de x en el punto de 
     * fin de la recta
     * @return double x del punto de fin de la recta
     */
    public double getX2(){
        return this.line.getX2();
    }
    
    /**
     * Método para obtener el valor de y en el punto de 
     * inicio de la recta
     * @return double y del punto de inicio de la recta
     */
    public double getY1(){
        return this.line.getY1();
    }
    
    /**
     * Método para obtener el valor de y en el punto de 
     * fin de la recta
     * @return double y del punto de fin de la recta
     */
    public double getY2(){
        return this.line.getY2();
    }
    
    /**
     * Método para obtener el punto inicial de la recta
     * @return Point2D punto de inicio de la recta
     */
    public Point2D getP1(){
        return this.line.getP1();
    }
    
    /**
     * Método para obtener el punto final de la recta
     * @return Point2D punto de fin de la recta
     */
    public Point2D getP2(){
        return this.line.getP2();
    }
    
    /**
     * Método que devuelve el objeto Line2D.Double
     * @return Line2D objeto línea
     */
    @Override
    public Shape getShape() {
        return this.line;
    }
    
    /**
     * Método que devuelve un String con el tipo de figura
     * @return String con el tipo de figura
     */

    @Override
    public String getTypeOfShape() {
        return this.type;
    }
    
    /**
     * Método que devuelve el boundingBox
     * @return Rectangle2D con el boundingBox de la figura
     */
    
    @Override
    public Rectangle2D getBounds2D() {
        return this.line.getBounds2D();
    }
    
    
    /**
     * Método para obtener la X del punto inicial de la recta
     * @return double X del inicio de la recta
     */
    @Override
    public double getminX() {
        return this.line.getX1();
    }
    
    /**
     * Método para obtener la Y del punto inicial de la recta
     * @return double Y del inicio de la recta
     */
    @Override
    public double getminY() {
        return this.line.getY1();
    }

    /**
     * Método para obtener el ancho de la recta
     * @return double ancho de la recta
     */
    @Override
    public double getWidth() {
        return Math.pow(Math.abs(this.line.x1 - this.line.x2),2) + Math.pow(Math.abs(this.line.y1 - this.line.y2),2);
    }

    /**
     * Método para obtener el alto de la recta
     * @return double alto de la recta
     */
    
    @Override
    public double getHeight() {
        return Math.abs(this.line.getX1() - this.line.getX2());
    }

    
    
    //--------------------SETTERS--------------//
    
    /**
     * Método para establecer la forma de la recta a partir de dos puntos
     * @param p1 punto inicial
     * @param p2 punto final
     */
    @Override
    public void setShape(Point2D p1, Point2D p2){
        if(this.line != null){
            this.line.setLine(p1, p2);
        }
    }
    
    /**
     * Método para estableces la forma de la recta a partir de las 
     * coordenadas de dos puntos
     * @param x1 x del punto inicial
     * @param y1 y del punto inicial
     * @param x2 x del punto final
     * @param y2 y del punto final
     */
    public void setLine(double x1, double y1, double x2, double y2) {
        this.line.setLine(x1, y1, x2, y2);
    }
    
         
    /**
     * Método que dado el punto al desplazar, va cambiando la posición de la línea, para dar la sensación de que esta se mueve al hacer el dragged
     * @param p1 punto inicial
     * @param p2 punto final
     * @param pos punto que se va moviendo
     */

    public void setLocation(Point2D p1, Point2D p2, Point2D pos){
        
        newp1.setLocation(pos.getX() - p2.getX(), pos.getY() - p2.getY());
        newp2.setLocation(pos.getX() + p1.getX(), pos.getY() + p1.getX());
        
        
        this.line.setLine(newp1,newp2); 
    }
    
    
        
    /**
     * Método para ver si está a una determinada distancia de la línea el punto en el que hagamos pressed
     * @param p punto en el que hemos hecho pressed
     * @return boolean nos indica si el punto está o no lo suficientemente cerca
     */
    public boolean isNear(Point2D p){
        return this.line.ptSegDist(p) <= 2.0;
    }
    
    /**
     * Método para ver si un punto donde hicimos
     * pressed está contenido en la recta
     * @param p punto en el que hicimos pressed
     * @return boolean está o no contenido
     */
    @Override
    public boolean contains(Point2D p) {
        return isNear(p);
    }
    
    /**
     * Métodos usado en el lienzo para calcular los puntos en isLine() 
     * (punto de inicio)
     * @param pos punto de inicio
     * @return Point2D punto con la distancia desde donde hicimos pressed al 
     * inicio de la recta
     */
    public Point2D calculateP1(Point2D pos){
        double x1 = Math.abs(pos.getX() - this.getX1());
        double y1 = Math.abs(pos.getY() - this.getY1());
        Point2D p1 = new Point2D.Double(x1,y1);
         
        return p1; 
    }
    
    /**
     * Métodos usado en el lienzo para calcular los puntos en isLine() 
     * (punto de fin)
     * @param pos punto de inicio
     * @return Point2D punto con la distancia desde donde hicimos pressed al 
     * final de la recta
     */
    
     public Point2D calculateP2(Point2D pos){
        double x2 = Math.abs(pos.getX() - this.getX2());
        double y2 = Math.abs(pos.getY() - this.getY2());
        Point2D p2 = new Point2D.Double(x2,y2);
         
        return p2; 
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

    @Override
    public void setLocation(Point2D p1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}