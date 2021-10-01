/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;



public class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected ResultSetMetaData resultadoMeta = null; // Este sirve cuando queremos traer informacion de tablas. Como cuantas columnas hay de x informacion
    protected Statement sentencia = null;
    private String user = "root";
    private String password = "root";
    private String database = "proyecto_alkemi";

    protected void conectarBase() throws Exception {
try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + database + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            throw new Exception("Error de Sistemas");
        }
    }
protected void desconectarBase() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error de Sistemas");
        }
    }

    protected void consultarBase(String sql) throws Exception {
        try {
            //Creamos la conexión a la base
            conectarBase();
            //Creamos la sentencia
            sentencia = conexion.createStatement();
            //Ejecutamos la sentencia y obtenemos los resultados
            resultado = sentencia.executeQuery(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Error de Sistemas");
        }
    }
protected void insertarModificarEliminar(String sql) throws Exception {
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            // conexion.rollback();
            /*
                Descomentar la linea anterior si desean tener en cuenta el rollback.
                Correr el siguiente script en Workbench
            
                SET autocommit=1;
                COMMIT;
            
                **Sin rollback igual anda
             */
            throw ex;
        } finally {
            desconectarBase();
        }
    }


}

        
          

