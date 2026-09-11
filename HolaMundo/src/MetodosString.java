public class MetodosString {
    public static void main(String[] args) {

        String cadena = "Lucio";

        System.out.println(cadena.length()); //numero de caracteres
        System.out.println(cadena.toLowerCase()); //a minúsculas
        System.out.println(cadena.toUpperCase()); //a mayusculas
        System.out.println(cadena.equals("Lucio")); //comparar Strings por valor
        System.out.println(cadena.equalsIgnoreCase("lucio")); //comparar Strings por valor ignorando mayusculas o minusculas
        System.out.println(cadena.compareTo("Lucio")); // 0 identicos
        System.out.println(cadena.charAt(0)); //obtener un carcater por posición
        System.out.println("cadena.substring(1) = " + cadena.substring(1)); //obtiene parte de la cadena a partir de un indice
        System.out.println("cadena.substring(1,3) = " + cadena.substring(1,3)); //obtiene parte de la cadena a partir de un indice hasta el indice
        System.out.println("cadena.substring(cadena.length()-2) = " + cadena.substring(cadena.length()-2));

        String cadena2 = "tra bale nguas ";
        System.out.println(cadena2.replace("a","A")); //reemplaza string por otro
        System.out.println(cadena2.indexOf("a")); //entrega la posición de la primera ocurrencia
        System.out.println(cadena2.lastIndexOf("a")); //entrega la posición de la última ocurrencia
        System.out.println(cadena2.lastIndexOf("z")); //-1 si no se encuentra la ocurrencia
        System.out.println(cadena2.contains("aba")); //valida si contiene un string
        System.out.println(cadena2.startsWith("tra")); //valida si comienza con un string
        System.out.println(cadena2.endsWith("lenguas")); //valida si termina con un string
        System.out.println(cadena2.trim()); //quita espacios en blanco al inicio y al final
        System.out.println(cadena2.replace(" ","")); //quita espacios en blanco

        String nombreArchivo = "document";

    }
}
