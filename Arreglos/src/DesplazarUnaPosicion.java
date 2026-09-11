public class DesplazarUnaPosicion {
    public static void main(String[] args) {

        Integer[] numeros = {1,2,3,4,5,6,7,8};

        for(int i=1, respaldo=0; i<numeros.length; i++){
            respaldo = numeros[i];
            numeros[i] = numeros[0];
            numeros[0] = respaldo;
        }
        
        for(int n:numeros){
            System.out.println("n = " + n);
        }

    }
}
