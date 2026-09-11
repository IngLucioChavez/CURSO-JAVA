public class ConversionTipos {
    public static void main(String[] args) {

        String numero = "50";
        int numeroInt = Integer.parseInt(numero);
        System.out.println("numeroInt = " + numeroInt);
        System.out.println("numeroInt = " + String.valueOf(numeroInt));

        String real = "125.12e2";
        double numeroDouble = Double.parseDouble(real);
        System.out.println("numeroDouble = " + numeroDouble);
        System.out.println("numeroDouble = " + String.valueOf(numeroDouble));

        String bool = "false";
        boolean valor = Boolean.parseBoolean(bool);
        System.out.println("valor = " + valor);
        System.out.println("valor = " + String.valueOf(valor));

        System.out.println(bool.length());
        System.out.println(bool.charAt(4));

        // casting
        int a = 1000;
        short b = (short)a;
        long c = a; // un int se puede asignar a un long porque long es más grande

        System.out.println(b);
    }
}
