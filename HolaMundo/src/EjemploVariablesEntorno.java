import java.util.Map;
import java.util.logging.Logger;

public class EjemploVariablesEntorno {
    public static void main(String[] args) {

        //obteniendo variables de entorno del Sistema Operativo
        Map<String, String> enviroment = System.getenv();

        System.out.println("enviroment = " + enviroment);
        //obteniendo el valor de una variable de ambiente
        System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
        //obteniendo valor de variable desde el map
        System.out.println("FPATH: " + enviroment.get("FPATH"));

        //------------- FORMAS DE ITERAR UN MAP -------------------------------
        //obtener en un Map cada registro del Map
        for(Map.Entry<String,String> entrada: enviroment.entrySet()){
            System.out.println("llave:" + entrada.getKey() + ", valor: " + entrada.getValue());
        }

        //obtener solo la llave y referenciar por la llave
        for(String llave: enviroment.keySet()){
            System.out.println("-->llave: " + llave + ", valor: " + enviroment.get(llave));
        }


    }
}
