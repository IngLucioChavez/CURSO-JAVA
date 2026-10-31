package org.lucio.pooexcepciones.ejemplo;

import javax.swing.*;

public class EjemploExcepciones {

    static void main(String[] args) {


        try {
            String valor = JOptionPane.showInputDialog("Ingrese valor: ");
            // se podría ingresar un valor que no es numérico
            Integer divisor = Integer.parseInt(valor);

            int division = 10/divisor;
            System.out.println(division);

        // de Exception -> ArithmeticException - así se define más concretamente la excepción
        } catch (ArithmeticException ae){
            System.out.println("capturando excepción: " + ae.getMessage());
            main(args); // se vuelve a ejecutar el main
        } catch(NumberFormatException nfe) {
            System.out.println("ERROR - formato ingresado inválido " + nfe.getMessage());
            main(args);
        } finally {
            System.out.println("se ejecuta siempre bloque Finally");
        }

        System.out.println("continuando ejecución");

    }

}
