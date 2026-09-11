public class ValidacionesString {
    public static void main(String[] args) {

        String cadenaNulo = null;
        String cadenaVacio = "";
        String cadena = "cadena";

        //System.out.println(cadenaNulo.isEmpty()); //nullPointer
        //System.out.println(cadenaNulo.isBlank()); //nullPointer
        //System.out.println(cadenaNulo.length()); //nullPointer
        if(cadenaNulo == null){
            System.out.println("si es nulo");
        }

        System.out.println(cadenaVacio.isEmpty()); //true
        System.out.println(cadenaVacio.isBlank()); //true
        System.out.println(cadenaVacio.length()); //0

        System.out.println(cadena.isEmpty()); //false
        System.out.println(cadena.isBlank()); //false
        System.out.println(cadena.length()); //6

        //NOTA isEmpty() e length() funciona a partir de Java SE1+
        //NOTA isBlank() funciona a partir de Java SE11+

    }
}
