import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EjemploNumeroAleatorio {
    public static void main(String[] args) {

        double random = Math.random(); //nunca llega a 1
        System.out.println("(random) = " + (random));

        //forma común de hacerlo
        random = Math.floor(Math.random() * 8); //0 y 7
        System.out.println("random = " + (int)random);

        //mejor práctica si se trabaja con hilos
        int numRand = ThreadLocalRandom.current().nextInt(0,8); // rango 0-7
        System.out.println("numRand = " + numRand);

        Random random2 = new Random();
        System.out.println("random entero = " + random2.nextInt()); //negativos y positivos
        System.out.println("random entero = " + random2.nextInt(8)); //0-7
        System.out.println("random entero = " + (15 + random2.nextInt(26 - 15))); //15-25


    }
}
