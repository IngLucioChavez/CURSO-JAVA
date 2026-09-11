import java.util.Scanner;

public class ArregloNumeroMayor {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int[] numeros = new int[5];
        int mayor = 0;
        int numUsu = 0;

        for(int i=0; i<numeros.length; i++){

            System.out.print("ingresa numero " + (i+1) + ": ");
            numUsu = Integer.parseInt(entrada.nextLine());
            numeros[i] = numUsu;

            if(i == 0 || numUsu > mayor)
                mayor = numUsu;

        }

        for(int n:numeros){
            System.out.print( n + ",");
        }
        System.out.println("\nmayor = " + mayor);


    }
}
