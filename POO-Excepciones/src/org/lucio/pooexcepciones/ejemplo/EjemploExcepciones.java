package org.lucio.pooexcepciones.ejemplo;

import org.lucio.pooexcepciones.excepciones.DivisionPorCeroException;
import javax.swing.*;

public class EjemploExcepciones {

    static void main(String[] args) {

        Calculadora cal = new Calculadora();
        String valor = JOptionPane.showInputDialog("Ingrese valor: ");
        int divisor;
        double division;

        try {

            divisor = Integer.parseInt(valor);
            division = cal.dividir(10,divisor);
            System.out.println(division);

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
