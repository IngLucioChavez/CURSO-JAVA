public class ArreglosImprimiendoIEsimo {
    public static void main(String[] args) {

        /* Se tiene un arreglo de 10 elementos y se debe mostrar primero con último,
        * Segundo con penúltimo, tercero con antepenultimo y así sucesivamente
        * */

        int[] numeros = {1,2,3,4,5,6,7,8,9,10};

        if( (numeros.length % 2) != 0 ){
            System.err.println("ERROR - el arreglo debe ser par");
            System.exit(1);
        }

        for(int i = 0; i < (numeros.length/2); i++){
            System.out.println(numeros[i] + " " + numeros[numeros.length-(i+1)]);
        }



    }
}
