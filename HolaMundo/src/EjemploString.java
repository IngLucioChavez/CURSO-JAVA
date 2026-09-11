public class EjemploString {
    public static void main(String[] args) {

        String cadena1 = "cadena"; //por asignación inmediata - implicito
        String cadena2 = new String("cadena"); //por instancia de objeto - explicito

        System.out.println("cadena1 = " + cadena1);
        System.out.println("cadena2 = " + cadena2);
        
        boolean comparacion = (cadena1 == cadena2); //se compara por referencia
        System.out.println("comparacion = " + comparacion);
        boolean comparacion2 = cadena1.equals(cadena2); //comparación por valor
        System.out.println("comparacion2 = " + comparacion2);

        // OJO - se retorna tru porque java por detrás
        // generá las variables cadena1 y cadena3 con referencia al mismo valor
        // esto para no generar objetos a lo desgraciado - optimización de java
        String cadena3 = "cadena";
        System.out.println(cadena1 == cadena3); // --> true


    }
}
