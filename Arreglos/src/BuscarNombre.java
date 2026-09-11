import java.util.Scanner;

public class BuscarNombre {
    public static void main(String[] args) {

        String[] nombres = {
            "Lucio","JuAn","Carlos","Lupita","paola","federico"
        };

        Scanner entrada = new Scanner(System.in);
        System.out.println("proporcione nombre a buscar: ");
        String nombreUsuario = entrada.nextLine();

        boolean encontrado = false;
        for(int i=0; i<nombres.length; i++){
            if(nombreUsuario.equalsIgnoreCase(nombres[i])){
                System.out.println("nombre " + nombreUsuario + " encontrado en posicion("+ i +")");
                encontrado = true;
                break;
            }
        }

        if( !encontrado )
            System.out.println("Nombre no encontrado");


    }
}
