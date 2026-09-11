public class EjemploClaseMath {
    public static void main(String[] args) {

        int absoluto = Math.abs(-3);
        System.out.println("absoluto = " + absoluto);

        System.out.println("maximo: " + Math.max(3.5,2));
        System.out.println("minimo: " + Math.min(3.5,2));
        System.out.println("redondeo hacía arriba: " + Math.ceil(4.2));
        System.out.println("redondeo hacia abajo: " + Math.floor(4.6));
        System.out.println("redondeo retorno entero: " + Math.round(4.6));

        System.out.println("Pi: " + Math.PI);
        System.out.println("exponencial: " + Math.exp(10));
        System.out.println("logaritmo natural: " + Math.log(10));
        System.out.println("potencia: " + Math.pow(10,2));
        System.out.println("raiz cuadrada: " + Math.sqrt(25));
        System.out.println("radianes a grados: " + Math.toDegrees(10.5));
        System.out.println("grados a radianes: " + Math.toRadians(90));
        System.out.println("seno(90): " + Math.sin(Math.toRadians(90))); //recibe radianes
        System.out.println("coseno(180): " + Math.cos(Math.toRadians(180)));
        System.out.println("coseno(0): " + Math.cos(Math.toRadians(0)));

    }
}
