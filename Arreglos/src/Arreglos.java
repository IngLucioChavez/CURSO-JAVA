
public class Arreglos {
    public static void main(String[] args) {

        // un array es mutable
        String[] productos = {
                "L","U","C","I","O"
        };

        sortBurbuja(productos);

        for(String producto: productos){
            System.out.println("producto = " + producto);
        }

    }

    public static <T extends Comparable<T>> void sortBurbuja(T[] arreglo){

        int total = arreglo.length;
        for(int i = 0; i < total; i++){ //iteracion externa queda el menor de todos
            for(int ii = i; ii < total; ii++){
                if( arreglo[ii].compareTo(arreglo[i])< 0){ //interno es menor a externo
                    T respaldo = arreglo[ii]; //respaldo menor
                    arreglo[ii] = arreglo[i]; //el menor se pone mayor
                    arreglo[i] = respaldo; //el mayor se pone menor
                }
            }
        }

    }

}
