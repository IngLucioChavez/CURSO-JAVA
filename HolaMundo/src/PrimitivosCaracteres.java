public class PrimitivosCaracteres {
    public static void main(String[] args) {
        char caracter = '\u0040'; //codigo unicode
        char decimal = 64; //codigo ascii
        char simbolo = '@'; //normal
        System.out.println("caracter = " + caracter);
        System.out.println("decimal = " + decimal);

        System.out.println("byte: " + Character.BYTES);
        System.out.println("bits: " + Character.SIZE);
        System.out.println("min: " + Character.MIN_VALUE);
        System.out.println("max: " + Character.MAX_VALUE);

        char espacio = ' '; // \u0020
        char retroceso = '\b'; // borrar un caracter
        char tabulador = '\t'; //tabulación
        char nuevaLinea = '\n';
        char retornoCarro = '\r';

        System.out.println("texto texto" + System.lineSeparator() + "texto texto");

    }
}
