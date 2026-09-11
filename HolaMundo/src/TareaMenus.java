import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class TareaMenus {
    public static void main(String[] args) {

        int opcionIndice = 0;
        Map<String,Integer> opciones = new HashMap<String,Integer>();
        opciones.put("Actualizar", 1);
        opciones.put("Eliminar", 2);
        opciones.put("Agregar", 3);
        opciones.put("Listar", 4);
        opciones.put("Salir", 5);

        Object[] opArreglo = opciones.keySet().toArray();

        do{
            Object opcion = JOptionPane.showInputDialog(null,
                    "Seleccione un Opción",
                    "Mantenedor de Productos",
                    JOptionPane.INFORMATION_MESSAGE, null, opArreglo, opArreglo[0]);

            if(opcion == null){
                JOptionPane.showMessageDialog(null, "Seleccionar opción valida");
                continue;
            }

            opcionIndice = opciones.get(opcion.toString());
            switch (opcionIndice){
                case 1:
                    JOptionPane.showMessageDialog(null, "Actualizado");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Eliminado");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Agregado");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Listado");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Adios");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no valida");
                    break;
            }
        } while(opcionIndice != 5);

    }
}
