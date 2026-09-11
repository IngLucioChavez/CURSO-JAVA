public class ConcatenacionStrings {
    public static void main(String[] args) {

        String a = "lucio francisco";
        String b = "chávez garcía";

        String detalle = a + " " + b;
        String detalle2 = a.concat(" ").concat(b); //forma más eficiente
        System.out.println(detalle2);

        String tranformacion = a.transform(c -> {
           return c.concat(" ").concat(b);
        });
        tranformacion = tranformacion.replace(" ","_");

        System.out.println("tranformacion = " + tranformacion);

        // los métodos de un string no cambian el string sino que retornan
        // una nueva instancia con los ajustes o los tratamientos solicitados


    }
}
