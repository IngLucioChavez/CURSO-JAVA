import org.lucio.poointerfaces.modelo.Producto;
import org.lucio.poointerfaces.repositorio.Direccion;
import org.lucio.poointerfaces.repositorio.OrdenablePaginableCrudRepositorio;
import org.lucio.poointerfaces.repositorio.excepciones.AccesoDatoExeption;
import org.lucio.poointerfaces.repositorio.excepciones.EscrituraDatoException;
import org.lucio.poointerfaces.repositorio.excepciones.LecturaDatoException;
import org.lucio.poointerfaces.repositorio.lista.ProductoListRepositorio;

public class EjemploRepositorioProducto {

    static void main() {

        try {

            OrdenablePaginableCrudRepositorio<Producto> repoProducto = new ProductoListRepositorio();
            repoProducto.crear(null);
            repoProducto.crear(new Producto("Silla", 120.5D));
            repoProducto.crear(new Producto("Escritorio", 15.55D));
            repoProducto.crear(new Producto("Vaso", 1.5D));

            System.out.println("-------Listar todo-----------");
            repoProducto.listar().forEach(System.out::println);

            System.out.println("-------Listar paginado-----------");
            repoProducto.listar(0, 2).forEach(System.out::println);

            System.out.println("-------Listar ordenado-----------");
            repoProducto.listar("id", Direccion.DESC).forEach(System.out::println);

            System.out.println("-------Actualizar-----------");
            Producto nuevoProducto = new Producto("Vaso Plástico", 5D);
            nuevoProducto.setId(4);
            repoProducto.editar(nuevoProducto);
            System.out.println(repoProducto.porId(4));

            System.out.println("-------Eliminación-----------");
            repoProducto.eliminar(4);
            repoProducto.listar().forEach(System.out::println);
            System.out.println("Total Registros: " + repoProducto.total());

        } catch (LecturaDatoException | EscrituraDatoException e) {
            System.out.printf("ERROR - %s\n", e.getMessage());
            e.printStackTrace(System.out);
        } catch (AccesoDatoExeption e) {
            System.out.printf("ERROR - %s\n", e.getMessage());
            e.printStackTrace(System.out);
        }


    }

}
