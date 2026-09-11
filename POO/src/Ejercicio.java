import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.println("ingresa datos: ");
        String valoresStr = entrada.nextLine();
        String[] valores = valoresStr.split(",");

        /*
        Integer[] valoresInt = new Integer[valores.length];
        
        for(int i = 0; i <valoresInt.length; i++){
            valoresInt[i] = Integer.parseInt(valores[i]);
        }
        */

        // conversión con programación funcional
        int[] valoresInt = Arrays.stream(valores)
                    .mapToInt(Integer::parseInt)
                    .toArray();

        
        
    }
}
