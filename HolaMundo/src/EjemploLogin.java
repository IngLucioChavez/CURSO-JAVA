import java.util.Scanner;

public class EjemploLogin {
    public static void main(String[] args) {

        //String[] usernames = new String[2]; //declaración de arreglo con 2 espacios
        //String[] passwords = new String[2];
        String[] usernames = {"lucio","carlos","juan"}; //declaración de arreglo con inicialización
        String[] passwords = {"123456","123456","1234"};

        Scanner entrada = new Scanner(System.in);
        String nombreUsuario, passwordUsuario;

        // agregando en arreglo a través de posición
        /*usernames[0] = "lucio";
        passwords[0] = "123456";
        usernames[1] = "carlos";
        passwords[1] = "123456";*/

        System.out.print("Ingrese nombre: ");
        nombreUsuario = entrada.nextLine();
        System.out.print("Ingrese password: ");
        passwordUsuario = entrada.nextLine();

        boolean encontrado = false;
        for(int i = 0; i<2; i++){

            if( nombreUsuario.equals(usernames[i]) && passwordUsuario.equals(passwords[i]) ){
                encontrado = true;
                break;
            }

        }

        if( encontrado ){
            System.out.printf("\nBienvenido %s\n",nombreUsuario);
        } else {
            System.out.println("\nUsuario no encontrado\n");
        }


    }
}
