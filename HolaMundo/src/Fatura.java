import java.util.*;

public class Fatura {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        List<Map<String,Object>> productos = new ArrayList<>();
        String idProducto = "";
        float precioProducto = 0;
        char opcion = 's';

        do {
            try {
                System.out.println("id producto: ");
                idProducto = entrada.nextLine();

                if(idProducto.isEmpty())
                    throw new RuntimeException("");

                System.out.println("precio producto: ");
                precioProducto = Float.parseFloat(entrada.nextLine().trim());

                productos.add(Map.of("id",idProducto,"precio",precioProducto));

                System.out.println("Registrar otro producto si(s) o no(n): ");
                String opcionTexto = entrada.nextLine().trim();
                opcion = opcionTexto.isEmpty() ? 'n' : Character.toLowerCase(opcionTexto.charAt(0));

            } catch(Exception e) {
                System.out.println("ERROR - valor no válido");
            }

        } while( opcion == 's' );

        System.out.println("\n\n----Factura----");
        float sumatoria = 0F;
        for(Map<String,Object> producto: productos){
            System.out.println("id: " + producto.get("id") + ", precio: " + producto.get("precio"));
            sumatoria += ((Number)producto.get("precio")).floatValue();
        }
        System.out.println("total: " + sumatoria);

    }
}
