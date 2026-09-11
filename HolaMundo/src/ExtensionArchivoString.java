public class ExtensionArchivoString {
    public static void main(String[] args) {

        String nombreArchivo = "documento.pdf";
        //convierte en un arreglo partiendo la cadena a través del caracter especificado
        String[] archivo = nombreArchivo.split("\\."); //recibe un regex no un caracter literal como en PHP

        System.out.println("nombreArchivo.length() = " + nombreArchivo.length());
        System.out.println("archivo = " + archivo[1]); //obtener extensión de archivo
        // para obtener extensión pero con lastIndexOf() donde se obtiene la posición de la última ocurrencia
        System.out.println(nombreArchivo.substring(nombreArchivo.lastIndexOf(".") + 1));

        //convierte cadena en arreglo de carcateres
        char[] caracateres = nombreArchivo.toCharArray();

        for(int i = 0; i < caracateres.length; i++){ //length como atributo en arreglos
            System.out.println(i + "-->" + caracateres[i]);
        }

    }
}
