package ejemploAutos;

import java.util.Date;

public class EjemploAutos {
    public static void main(String[] args) {

        Auto auto1 = new Auto(Color.NEGRO,"mazda");
        Auto auto2 = new Auto();
        Date fecha = new Date();

        System.out.println(auto1.equals(auto2)); // false - sin error null pointer
        // error - null pointer x q auto2 no tiene valores definidos
        // un valor con null no puede invocar métodos
        System.out.println(auto2.equals(auto1));

        //comparacion entre dos objetos incompatibles
        // sin validación arroja Error de Cast
        System.out.println(auto1.equals(fecha));

        // ejecutando toString()
        // el metodo casi no es llamado de forma manual ya que se ejecuta cuando
        // se quiere impirmir el obj como tal
        System.out.println(auto1); //implicito
        System.out.println(auto1.toString()); //explicito

    }
}
