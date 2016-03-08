package net.ausiasmarch.neptuno.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * DBConnection.java
 * Esta clase usa el patron Singleton para obtener una unica conexion de BD
 */
public class DBConnection {

    // singleton: permite tener una unica instancia de DBConnetion 
    public static final DBConnection instance = new DBConnection();
    // Conexion a la BD
    private Connection conn = null;
    // Contectado si o no
    private boolean conectado = false;

    /**
     * Contructor privado que previene la instanciacion desde otras clases
     */
    private DBConnection() {
    }

    /**
     * Obtiene una conexion a la BD
     *
     * @return Connection
     */
    public Connection getConnection(DriverType driver) {
        // Propiedades de conexion de BD
        Properties prop;

        try {
            // Obtiene las propiedaesde conexion
            prop = getProperties(driver);
            // Carga la clase correspondiente al driver de BD
            Class.forName(prop.getProperty("driver"));
            // Obtiene la conexion a la BD
            conn = DriverManager.getConnection(prop.getProperty("url"), prop);
            conectado = true;
            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Cierra una conexion de bases de datos abierta
     */
    public void close() {
        try {
            if (conectado) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error cerrando la conexion.");
        }
    }

    /**
     * Obtiene las propiedades de conexion a la base de datos
     *
     * @return Properties
     */
    private Properties getProperties(DriverType driver) {
        // InputStrean para leer el archivo de configuracion de BD
        InputStream config = null;
        String path = null;
        try {
            // Propiedades de conexion de BD
            Properties prop = new Properties();
            // Path del archivo de configuracion de BD
            switch (driver) {
                case ACCESS:
                    path = "net/ausiasmarch/neptuno/res/configAccessJDBC.properties";
                    break;
                case MYSQL:
                    path = "net/ausiasmarch/neptuno/res/configMySQL.properties";
                    break;
            }

            // InputStrean para leer el archivo de configuracion de BD
            config = null;
            // Carga el InputStrean del archivo de configuracion de BD
            ClassLoader cl = this.getClass().getClassLoader();
            if (cl == null) {
                config = ClassLoader.getSystemResourceAsStream(path);
            } else {
                config = cl.getResourceAsStream(path);
            }

            // Carga el archivo de propiedades con la configuracion de BD
            prop.load(config);

            return prop;
        } catch (IOException ex) {
            throw new RuntimeException("Error cargando archivo de propiedades.");
        } finally {
            if (config != null) {
                try {
                    config.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }
}
