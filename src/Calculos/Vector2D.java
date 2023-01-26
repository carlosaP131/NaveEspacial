/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-12-2022 
 *Fecha de actualización:4-01-2023
 *Descripción:Clase Vector2D esta clase se encarga de los calculos nesesarios 
 * para las posiciones de los objetos 
 **
 * ****************************************************************************/
package Calculos;
/**
 * 
 * @author Carlos Aurelio Alcantara Perez
 */
public class Vector2D {
    /**
     * Variables para las coordenadas
     */
    private double x, y;
    /**
     * Método constructor  
     * @param x posicion del objeto en x 
     * @param y posicion del objeto en y
     */
    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Constructor sin parametros
     */
    public Vector2D() {
        x = 0;
        y = 0;
    }
    /**
     * Crea un nuevo Vector
     * @param v Recive un vector anterior 
     * @return Se suman las cordenadas nuevas para mover el objeto
     */
    public Vector2D add(Vector2D v) {
        return new Vector2D(x + v.getX(), y + v.getY());
    }
    /**
     * Desacer el Vector 
     * @param v Recive el vector anterior
     * @return Se resta el vector anterior 
     */
    public Vector2D subtract(Vector2D v) {
        return new Vector2D(x - v.getX(), y - v.getY());
    }
    /**
     * Aumentar el tamaño del vector 
     * @param value Valor a aumentar
     * @return Valor aumentado
     */
    public Vector2D scale(double value) {
        return new Vector2D(x * value, y * value);
    }
    /**
     * Reducir un vector 
     * @param value Valor a reducir 
     * @return Valor reducido
     */
    public Vector2D limit(double value) {
        if (getMagnitude() > value) {
            return this.normalize().scale(value);
        }
        return this;
    }
    /**
     * Normalizar un vector
     * @return Vector Normlizado
     */
    public Vector2D normalize() {
        double magnitude = getMagnitude();

        return new Vector2D(x / magnitude, y / magnitude);
    }
    /**
     * Obtener la magnitud
     * @return Margnitud del vector
     */
    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }
    /**
     * Setear la Direccion
     * @param angle Ángulo en el que se va a mostrar el vector
     * @return 
     */
    public Vector2D setDirection(double angle) {
        double magnitude = getMagnitude();

        return new Vector2D(Math.cos(angle) * magnitude, Math.sin(angle) * magnitude);
    }
    /**
     * Se obtiene el angulo
     * @return 
     */
    public double getAngle() {
        return Math.asin(y / getMagnitude());
    }
    /**
     * Regresar la Coordenada X
     * @return 
     */
    public double getX() {
        return x;
    }
    /**
     * Obtener la coordenada X
     * @param x 
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Regresar la coordenada Y 
     * @return 
     */
    public double getY() {
        return y;
    }
    /**
     * Obtener la cordenada Y
     * @param y 
     */
    public void setY(double y) {
        this.y = y;
    }

}
