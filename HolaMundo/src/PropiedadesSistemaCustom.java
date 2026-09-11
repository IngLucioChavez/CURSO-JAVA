import java.io.FileInputStream;
import java.util.Properties;

public class PropiedadesSistemaCustom {
    public static void main(String[] args) {

        try {
            FileInputStream archivo = new FileInputStream("src/config2.properties");
            Properties properties = new Properties(System.getProperties()); //cargar propiedades del sistema

            properties.load(archivo); //cargar propiedades customizadas con las del sistema
            properties.setProperty("config.fuchis","fuchis"); //definir nueva propiedad
            System.setProperties(properties); //definir propiedades del sistema
            System.getProperties().list(System.out); //enlistar todas las propiedades en consola

            System.out.println("consultando propiedad: " + System.getProperty("config.correo")); //obtener el valor de una propiedad

        } catch (Exception e) {
            System.err.println("no exite archivo " + e.getMessage()); //mostrar mensaje de error en consola
            System.out.println(System.currentTimeMillis());
            System.gc(); //garbage collection - para invocarlo manualmente y se limpien las instancias no utilizadas
            System.exit(1); //terminar ejecución de aplicación 1(exito) -1(error)
        }

    }
}
