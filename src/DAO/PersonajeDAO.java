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
public class PersonajeDAO extends DAO {

    Scanner sc = new Scanner(System.in).useDelimiter("\n");

    public void Armarpersonaje() {

        try {

            System.out.println("Ingrese nombre del Personaje:");
            String nombre = sc.next();
            System.out.println("ingrese edad del personaje:");
            int edad = sc.nextInt();
            System.out.println("Ingrese Imagen:");
            String img = sc.next();
            System.out.println("ingrese Historia del personaje:");
            String Historia = sc.next();
            System.out.println("Ingrese Peso del Personaje");
            double Peso;
            Peso = sc.nextDouble();
//            System.out.println("desea Armar otro personaje?");
//            String respuesta = sc.next();
            String sql = "insert into personaje (nombre, imagen) values ('" + nombre + "','" + img + "')";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }

    }
   public void mostrarPersonaje() throws Exception {
        try {
            String sql = "select imagen,nombre FROM Personaje";
            consultarBase(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            desconectarBase();
        }

    }
    
     public void cambiarPersonaje() {
        try {

            System.out.println("ingres el personaje a cambiar");
            String aux = sc.next();
            System.out.println("ingrese valor a cambiar");
            String aux1 = sc.next();
            System.out.println("ingrece nuevo valor");
            String aux2 = sc.next();
            String sql = "update personaje set  " + aux1 + "= '" + aux2 + "'  where " + aux1 + " = '" + aux + "'";

            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }


    


    

    public void quitarpersonaje() {
        try {
            System.out.println("ingrese el personaje a eliminar");
            String aux3 = sc.next();
            System.out.println("ingrese valor a modificar");
            String aux1 = sc.next();
            String sql = "DELETE FROM personaje WHERE   " + aux1 + " = '" + aux3 + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
