import org.lucio.poointerfaces.modelo.Cliente;
import org.lucio.poointerfaces.repositorio.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    OrdenablePaginableCrudRepositorio repo = new ClienteListRepositorio();
    repo.crear(new Cliente("Chávez","Lucio"));
    repo.crear(new Cliente("Chávez","Carlos"));
    repo.crear(new Cliente("Silva","Juan"));
    repo.crear(new Cliente("Delgado","Ma Guadalupe"));

    System.out.println("-----Listado---------");
    List<Cliente> clientes = repo.listar();
    clientes.forEach(System.out::println);

    System.out.println("-----Paginable-------");
    List<Cliente> clientesPag = repo.listar(0,2);
    clientesPag.forEach(System.out::println);

    System.out.println("-----Ordenar ASC-------");
    List<Cliente> clientesOrdenASC = repo.listar("nombre",Direccion.ASC);
    clientesOrdenASC.forEach(System.out::println);

    System.out.println("-----Ordenar DESC-------");
    List<Cliente> clientesOrdenDESC = repo.listar("nombre",Direccion.DESC);
    clientesOrdenDESC.forEach(System.out::println);

    System.out.println("-----Editar-------");
    Cliente clienteEditado = new Cliente("Delgado","Ma Isabel");
    // se asigna el id 4 porque cada vez que se crea un cliente se aumenta en 1 el id
    clienteEditado.setId(4);
    // se obtiene el cliente editado a través de su id
    repo.editar(clienteEditado);
    // se imprime donde porId -> Cliente y sout utiliza el toString de Cliente
    System.out.println(repo.porId(4));
    // forma simplificada para mostrar en pantalla el listado de los clientes
    // sin utilizar una variable List que obtenga la lista de clientes
    repo.listar().forEach(System.out::println);

    System.out.println("-----Eliminar-------");
    repo.eliminar(2);
    repo.listar().forEach(System.out::println);

    System.out.println("-----Total Count-------");
    System.out.println("Total: " + repo.total());

}
