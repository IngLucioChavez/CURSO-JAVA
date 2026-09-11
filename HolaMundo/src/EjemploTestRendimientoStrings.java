public class EjemploTestRendimientoStrings {
    public static void main(String[] args) {

        String a = "a";
        String b = "b";
        String c = a;
        // el StringBuilder es mutable a diferencia de un String
        StringBuilder sb = new StringBuilder(a);

        long inicio = System.currentTimeMillis();

        for(int i = 0; i < 10000; i++){
            //c = c.concat(a).concat(b).concat("\n"); // 500 -> 2ms, 1000 -> 3ms, 10000 -> 75ms
            //c += a + b + "\n"; // 500 -> 10ms, 1000 -> 9ms, 10000 -> 37ms
            sb.append(a).append(b).append("\n"); // 500 -> 0ms, 1000 -> 0ms, 10000 -> 1ms
        }

        // CONCLUSION
        // es mejor utilizar el StringBuilder ya que es más eficiente en tiempos

        long fin = System.currentTimeMillis();
        System.out.println("c = " + c);
        System.out.println("sb = " + sb);
        System.out.println( fin - inicio );


    }
}
