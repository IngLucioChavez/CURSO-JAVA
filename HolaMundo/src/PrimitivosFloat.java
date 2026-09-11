public class PrimitivosFloat {
    public static void main(String[] args) {

        float numero = 1.0F;
        System.out.println("numero = " + numero);
        float cientifico = 2.10e3F;
        System.out.println("cientifico = " + cientifico);
        float cientifico2 = 2.10e-3F;
        System.out.println("cientifico2 = " + cientifico2);

        System.out.println("\nbytes de float " + Float.BYTES);
        System.out.println("bits de float " + Float.SIZE);
        System.out.println("min de float " + Float.MIN_VALUE);
        System.out.println("max de float " + Float.MAX_VALUE);

        double numero1 = 3.4;
        System.out.println("\nbytes de float " + Double.BYTES);
        System.out.println("bits de float " + Double.SIZE);
        System.out.println("min de float " + Double.MIN_VALUE);
        System.out.println("max de float " + Double.MAX_VALUE);

    }
}
