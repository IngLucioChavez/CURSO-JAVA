import java.util.Random;

public class EjemploMatrices {
    public static void main(String[] args) {

        int[][][] numeros = new int[2][3][4];

        System.out.println("nv0: " + numeros.length);
        System.out.println("nv1: " + numeros[0].length);
        System.out.println("nv2: " + numeros[0][0].length);

        //Random val = new Random();
        int val = 0;
        for(int i=0; i<numeros.length; i++){
            for(int ii=0; ii<numeros[0].length; ii++) {
                for(int iii=0; iii<numeros[0][0].length; iii++) {
                    //numeros[i][ii][iii] = val.nextInt(20);
                    numeros[i][ii][iii] = val++;
                }
            }
        }

        for(int i=0; i<numeros.length; i++){
            for(int ii=0; ii<numeros[0].length; ii++) {
                for(int iii=0; iii<numeros[0][0].length; iii++) {
                    System.out.printf("numeros [%d][%d][%d] = %d%n",i,ii,iii,numeros[i][ii][iii]);
                }
            }
        }
        
        for(int[][] lvl0: numeros){
            for(int[] lvl1: lvl0){
                for(int lvl2: lvl1){
                    System.out.println("lvl2 = " + lvl2);
                }
            }
        }

    }
}
