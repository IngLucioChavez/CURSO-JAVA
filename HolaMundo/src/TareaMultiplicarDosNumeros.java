import java.util.Scanner;

public class TareaMultiplicarDosNumeros {
    public static void main(String[] args) {

        Float[] numeros = new Float[3];
        Scanner entrada = new Scanner(System.in);
        Boolean resultadoNegativo = false;

        System.out.println("numero1: ");
        numeros[0] = Float.parseFloat(entrada.nextLine());
        System.out.println("numero2: ");
        numeros[1] = Float.parseFloat(entrada.nextLine());

        if( numeros[0] < 0 && numeros[1] < 0){ //si los dos son negativos
            numeros[0] = -numeros[0]; //absoluto
            numeros[1] = -numeros[1]; //absoluto
        } else if(numeros[0] < 0 && numeros[1] > 0){ // si num1 es negativo
            numeros[0] = -numeros[0];
            resultadoNegativo = true;
        } else if(numeros[1] < 0 && numeros[0] > 0){ // si num2 es negativo
            numeros[1] = -numeros[1];
            resultadoNegativo = true;
        } else {}

        numeros[2] = 0f;
        for(int i = 0; i < numeros[1]; i++){ // una multiplicación es una serie de sumas
            numeros[2] += numeros[0];
        }

        numeros[2] = resultadoNegativo ? -numeros[2] : numeros[2];

        System.out.println("resultado = " + numeros[2]);

    }
}
