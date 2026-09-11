import javax.swing.*;
import java.util.Scanner;

public class Conversor {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int numero = 0;

        System.out.print("valor entrada: ");
        try {
            // JOptionPane -> abre una ventana para ingresar valor
            //numero = Integer.parseInt(JOptionPane.showInputDialog("valor de entrada: "));

            numero = entrada.nextInt();
        } catch (Exception e){ // cualquier excepción
            System.out.println("ERROR - dede ser número entero");
            //JOptionPane.showMessageDialog(null,"Error - debe ser un valor entero");
            main(args); // se ejecuta main de forma recursiva
            System.exit(0); // se termina la ejecución con estatus 0 o return;
        }

        System.out.println("numero = " + numero);
        System.out.println("binario = " + Integer.toBinaryString(numero));
        System.out.println("octal = " + Integer.toOctalString(numero));
        System.out.println("hexadecimal = " + Integer.toHexString(numero));

    }
}
