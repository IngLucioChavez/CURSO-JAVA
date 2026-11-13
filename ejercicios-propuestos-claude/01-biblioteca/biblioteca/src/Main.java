import modelo.Prestamo;
import modelo.materiales.Genero;
import modelo.materiales.Libro;
import modelo.personas.Socio;
import modelo.personas.SocioPremium;
import repositorio.SocioRepositorio;
import repositorio.enumeraciones.FormasDeOrden;

import java.util.List;

public class Main{

    void main(String[] args) {

        SocioPremium original = new SocioPremium("0010", "Ana", "Ruiz", "Soto");
        Socio copia = original.copiar();
        System.out.println(copia.getId().equals(original.getId()));   // true
        System.out.println(copia != original);                        // true (objeto distinto)
        System.out.println(copia.getLimitePrestamos());

        Socio siguiente = new Socio("0011", "Beto", "Paz", "Luna");
        System.out.println(siguiente.getId() == original.getId() + 1);  // true: la copia no gastó id
        copia.setAp("Cambiado");
        System.out.println(original.getAp());

        System.out.println();
        SocioRepositorio repo = new SocioRepositorio();
        Socio s = new Socio("0001", "Lucio", "Chávez", "García");
        repo.crearRegistro(s);
        s.setAp("Cambiado");                                           // alterar el objeto original del Main
        System.out.println(repo.obtenerRegistroPorId(s.getId()).getAp());   // "Chávez": el repo no cambió

        Socio leido = repo.obtenerRegistroPorId(s.getId());
        leido.setAp("Otro");
        System.out.println(repo.obtenerRegistroPorId(s.getId()).getAp());   // "Chávez": sigue igual hasta modificar

        repo.obtenerRegistros().get(0).setAp("X");                      // alterar un elemento del listado
        System.out.println(repo.obtenerRegistroPorId(s.getId()).getAp());   // "Chávez"

        leido.setAp("Vergara");
        repo.modificarRegistro(leido);
        System.out.println(repo.obtenerRegistroPorId(s.getId()).getAp());   // "Vergara": ahora sí

    }

}

