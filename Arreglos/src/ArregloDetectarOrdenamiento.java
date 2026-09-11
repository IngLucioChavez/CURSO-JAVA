import java.util.Scanner;

public class ArregloDetectarOrdenamiento {
    public static void main(String[] args) {
        /* Detectar si un arreglo esta ordenamdo de formas asc, desc o desor */
        
        Scanner entrada = new Scanner(System.in);
        System.out.print("ingresa numeros separados por comas: ");
        String numUsu = entrada.next();
        String[] numerosStr = numUsu.split(",");
        Integer[] numeros = new Integer[numerosStr.length];

        for(int i=0; i<numerosStr.length; i++){
            numeros[i] = Integer.parseInt(numerosStr[i]);
        }

        boolean asc = false;
        boolean desc = false;
        for(int i=0; i<numeros.length-1; i++){

            if(numeros[i] < numeros[i+1]){
                asc = true;
            }
            if(numeros[i] > numeros[i+1]){
                desc = true;
            }

        }

        if( asc == true && desc == true)
            System.out.println("desordenado");
        if( asc == false && desc == false)
            System.out.println("todos iguales");
        if( asc == true && desc == false)
            System.out.println("orden asc");
        if( asc == false && desc == true)
            System.out.println("orden desc");

    }
}
