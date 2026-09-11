import javax.swing.*;

public class NombreMasLargo {
    public static void main(String[] args) {

        String[] nombres = new String[3];
        String[] soloNombres = new String[3];

        nombres[0] = JOptionPane.showInputDialog("(1)nombre + apellido: ");
        nombres[1] = JOptionPane.showInputDialog("(2)nombre + apellido: ");
        nombres[2] = JOptionPane.showInputDialog("(3)nombre + apellido: ");

        soloNombres[0] = nombres[0].split(" ")[0];
        soloNombres[1] = nombres[1].split(" ")[0];
        soloNombres[2] = nombres[2].split(" ")[0];

        if(soloNombres[0].length() > soloNombres[1].length()){
            if(soloNombres[0].length() > soloNombres[2].length()){
                JOptionPane.showMessageDialog(null,"el mayor es " + soloNombres[0]);
            } else {
                JOptionPane.showMessageDialog(null,"el mayor es " + soloNombres[2]);
            }
        } else {
            if( soloNombres[1].length() > soloNombres[2].length() ){
                JOptionPane.showMessageDialog(null,"el mayor es " + soloNombres[1]);
            } else {
                JOptionPane.showMessageDialog(null,"el mayor es " + soloNombres[2]);
            }
        }

    }
}
