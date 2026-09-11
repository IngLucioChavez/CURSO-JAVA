import java.util.Properties;

public class EjemploPropiedadesSistema {
    public static void main(String[] args) {

        System.out.println(System.getProperty("user.name")); //usuario sistema
        System.out.println(System.getProperty("user.home")); //ruta base en sistema
        System.out.println(System.getProperty("user.dir")); //ruta del proyecto
        System.out.println(System.getProperty("java.version")); //versión de java

        //enlistar las propiedades con sus claves y valores del sistema
        Properties p = System.getProperties();
        p.list(System.out);



    }
}
