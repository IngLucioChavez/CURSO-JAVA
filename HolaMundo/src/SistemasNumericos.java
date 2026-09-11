public class SistemasNumericos {
    public static void main(String[] args) {

        int numero = 500;
        System.out.println("numero = " + numero);
        System.out.println("binario = " + Integer.toBinaryString(numero));
        System.out.println("octal = " + Integer.toOctalString(numero));
        System.out.println("hexa = " + Integer.toHexString(numero));

        int numBinario = 0b111110100; //especificacion en binario
        System.out.println("numBinario = " + numBinario); //se muestra decimal
        int numOctal = 0764; //especificacion en octal
        System.out.println("numOctal = " + numOctal); //se muestra en decimal
        int numHexa = 0x1f4; //especificacion en hexa
        System.out.println("numHexa = " + numHexa); //se muestra en decimal
    }
}
