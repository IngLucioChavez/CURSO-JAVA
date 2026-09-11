import java.util.Scanner;

public class TareaMenorDe10Numeros {
    public static void main(String[] args) {

        Integer menor = 0;
        Scanner entrada = new Scanner(System.in);

        for(int i=0; i<10; i++){
            System.out.printf("numero %d: ",(i+1));
            Integer valor = entrada.nextInt();
            if( i == 0 ){
                menor = valor;
            } else {
                if( valor < menor ){
                    menor = valor;
                }
            }
        }

        System.out.printf("el menor es %d%n",menor);
        System.out.printf( menor < 10? "el menor es menor a 10": "el menor es mayor a 10" );

    }
}
