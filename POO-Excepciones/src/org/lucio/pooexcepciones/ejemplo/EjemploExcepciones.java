package org.lucio.pooexcepciones.ejemplo;

import org.lucio.pooexcepciones.excepciones.DivisionPorCeroException;
import org.lucio.pooexcepciones.excepciones.FormatonumeroException;

import javax.swing.*;
import java.util.Scanner;

public class EjemploExcepciones {

    static void main(String[] args) {

        Calculadora cal = new Calculadora();
        int divisor;
        double division;
        boolean repetir = true;
        Scanner entrada = new Scanner(System.in);

        do{
            String valor = JOptionPane.showInputDialog("Ingrese Dividendo: ");
            String valor2 = JOptionPane.showInputDialog("Ingrese Divisor: ");

            try {

                division = cal.dividir(valor,valor2);
                System.out.println(division);
                repetir = false;

            } catch (DivisionPorCeroException ae){
                System.out.println("ERROR - aritmético: " + ae.getMessage());
                ae.printStackTrace(System.out);
                //main(args);
            } catch(NumberFormatException | FormatonumeroException nfe ) {
                System.out.println("ERROR - formato ingresado inválido ");
                nfe.printStackTrace(System.out);
                //main(args);

            }
        } while(repetir);


        System.out.println("continuando ejecución");

    }

}
