import java.lang.reflect.Method;

public class GetClassMetodo {
    public static void main(String[] args) {

        String texto = "texto";
        Class strClass = texto.getClass(); //para ver estructura interna del obj

        System.out.println(strClass.getName()); //nombre de clase con package
        System.out.println(strClass.getSimpleName()); //nombre de clase sin package
        System.out.println(strClass.getPackageName()); //nombre del package donde se encuentra

        for(Method metodo:strClass.getMethods()){ //obteniendo los métodos que tiene la clase
            System.out.println("metodo.getName() = " + metodo.getName());
        }

    }
}
