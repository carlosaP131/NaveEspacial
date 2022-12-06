/** ****************************************************************************
 *Autor:Carlos Aurelio Alcántara Pérez
 *Fecha de creación: 18-11-2022 ***
 *Fecha de actualización:31-11-2022
 *Descripción: Clase conexion para conectar a base de datos 
 **
 * ****************************************************************************/
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Carlos Aurelio Alcántara Pérez
 */

public class Conexion {
    /* Variables para guardar y hacer mas accesible el cambio de parametros de 
    *   de la base de datos 
    */
    private final String driver;
    private final String user;
    private final String pdw;
    private final String url;
    private final String ip;
    private final String puerto;
    private final String basedatos;
    private Connection connection;

    public Conexion() {
        this.driver = "com.mysql.cj.jdbc.Driver";//Enlace del driver
        this.user = "root";//usuario
        this.pdw = "root";//contraseña
        this.url = "jdbc:mysql://";//url Mysql
        this.ip = "127.0.0.1";//ip
        this.puerto = "3306";//puerto
        this.basedatos = "nave_espacial";//base de datos
        
    }

    public Connection getConnection() throws ClassNotFoundException {
        try {

            Class.forName(this.driver);
            connection = DriverManager.getConnection(this.url + this.ip + ":" + puerto + "/"
                    + this.basedatos, this.user, this.pdw);

            System.out.println("Conexion exitosa");
            return connection;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
       
        return null;
    }

}
