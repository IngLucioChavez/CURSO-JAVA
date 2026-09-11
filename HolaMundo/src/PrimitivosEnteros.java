public class PrimitivosEnteros {
    public static void main(String[] args) {
        
        byte numero = 127;
        System.out.println("byte numero = " + numero);
        System.out.println("tipo byte corresponde en byte a " + Byte.BYTES);
        System.out.println("tipo byte corresponde en bits a " + Byte.SIZE);
        System.out.println("valor maximo de byte " + Byte.MAX_VALUE);
        System.out.println("valor minimo de byte " + Byte.MIN_VALUE);

        short numero1 = 32767;
        System.out.println("short numero1 = " + numero1);
        System.out.println("tipo short corresponde en byte a " + Short.BYTES);
        System.out.println("tipo short corresponde en bits a " + Short.SIZE);
        System.out.println("valor maximo de short " + Short.MAX_VALUE);
        System.out.println("valor minimo de short " + Short.MIN_VALUE);

        int numero2 = 2147483647;
        System.out.println("int numero2 = " + numero2);
        System.out.println("tipo int corresponde en byte a " + Integer.BYTES);
        System.out.println("tipo int corresponde en bits a " + Integer.SIZE);
        System.out.println("valor maximo de int " + Integer.MAX_VALUE);
        System.out.println("valor minimo de int " + Integer.MIN_VALUE);

        long numero3 = 9223372036854775807L; // los long deben llevar 'L' al final
        System.out.println("long numero2 = " + numero2);
        System.out.println("tipo long corresponde en byte a " + Long.BYTES);
        System.out.println("tipo long corresponde en bits a " + Long.SIZE);
        System.out.println("valor maximo de long " + Long.MAX_VALUE);
        System.out.println("valor minimo de long " + Long.MIN_VALUE);

        // var no se soporta en Java SE8 sino en SE10+
        // si el valor asignado rebasa algún límite del int se debe especificar L o F o D
        var numero4 = 9223372036854775807L;

    }
}
