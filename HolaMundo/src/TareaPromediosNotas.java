import java.util.Scanner;

public class TareaPromediosNotas {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Float promedioGeneral = 0F, promedioMayores5 = 0F, promedioMenores4 = 0F;
        Integer numMayores5 = 0, numMenores4 = 0;

        for(int i = 0; i < 20; i++){
            System.out.print("nota " + (i+1) + ": ");
            Float valor = Float.parseFloat(entrada.nextLine());

            if( valor == 0){
                System.out.print("ERROR - nota 0 - adios!");
                return;
            } else if( valor > 5 ){
                promedioMayores5 += valor;
                numMayores5++;
            } else if(valor < 4) {
                promedioMenores4 += valor;
                numMenores4++;
            } else {}

            promedioGeneral += valor;

        }

        System.out.printf("%d calificaciones mayores a 5, promedio: %.2f%n",numMayores5,(promedioMayores5/numMayores5));
        System.out.printf("%d calificaciones menores a 4, promedio: %.2f%n",numMenores4,(promedioMenores4/numMenores4));
        System.out.printf("20 calificaciones totales, promedio: %.2f%n",(promedioGeneral/20));

    }
}
