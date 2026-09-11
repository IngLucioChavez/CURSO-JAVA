import java.util.Random;

public class BuscarNumero {
    public static void main(String[] args) {

        int[][][] numeros = new int[2][4][6];
        int numSearch = 10;

        Random random = new Random();
        for(int i=0; i<numeros.length; i++){
            for(int ii=0; ii<numeros[0].length; ii++){
                for(int iii=0; iii<numeros[0][0].length; iii++){
                    numeros[i][ii][iii] = random.nextInt(20);
                }
            }
        }

        boolean encontrado = false;
        uno: for(int i=0; i<numeros.length; i++){
            for(int ii=0; ii<numeros[0].length; ii++){
                for(int iii=0; iii<numeros[0][0].length; iii++){
                    if(numSearch == numeros[i][ii][iii]){
                        encontrado = true;
                        System.out.printf("encontrado en [%d][%d][%d] = %d\n",i,ii,iii,numeros[i][ii][iii]);
                        break uno;
                    }
                }
            }
        }

        if( !encontrado )
            System.out.printf("No encontrado num:%d",numSearch);

    }
}
