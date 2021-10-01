/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.Scanner;

/**
 *
 * @author Belen
 */
public class  Pelicula_DAO extends DAO { 
    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void ArmarPelicula() {

        try {

            System.out.println("Ingrese nombre del Personaje:");
            String nom = sc.next();
            
            System.out.println("Ingrese Imagen:");
            String img = sc.next();

            String sql = "insert into personaje (nombre, imagen) values ('" + nom + "','" + img + "')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }

    }

    public void cambiarPelicula() {
        try {
            System.out.println("ingres el personaje a modificar");
            String aux = sc.next();
            System.out.println("ingrese  la pelicula a cambiar  ");
            String aux1 = sc.next();
            System.out.println("ingrece nuevo valor");
            String aux2 = sc.next();
            String sql = "update personaje set  " + aux1 + "= '" + aux2 + "'  where " + aux1 + " = '" + aux + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }

    public void quitarPelicula() {
        try {
            System.out.println("ingrese el personaje a ");
            String aux3 = sc.next();
            System.out.println("ingrese el valor a modificar");
            String aux1 = sc.next();

            String sql = "DELETE FROM personaje WHERE   " + aux1 + " = '" + aux3 + "'";

    } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void mostrarPelicula() throws Exception {
        try {
            String sql = "select titulo,imagen,fecha_creacion FROM Pelicula";
            consultarBase(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            desconectarBase();
        }

    }

}

    
    
    
    
    
    
    
    
    
    
    
    

