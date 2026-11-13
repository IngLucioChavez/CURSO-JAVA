import modelo.Prestamo;
import modelo.materiales.Genero;
import modelo.materiales.Libro;
import modelo.personas.Socio;
import repositorio.SocioRepositorio;
import repositorio.enumeraciones.FormasDeOrden;

import java.util.List;

public class Main{

    void main(String[] args) {

        SocioRepositorio repoSocio = new SocioRepositorio();
        repoSocio.crearRegistro(new Socio("0001","Lucio","Chávez","García"));
        repoSocio.crearRegistro(new Socio("0002","Carlos Alam","Chávez","García"));
        repoSocio.crearRegistro(new Socio("0003","Ma Guadalupe","García","Delgado"));
        repoSocio.crearRegistro(new Socio("0004","Juan Pablo","Silva","Gutierrez"));
        repoSocio.crearRegistro(new Socio("0005","Paola","Sánchez","García"));

        // listar todos los registros
        repoSocio.obtenerRegistros().forEach(o->{
            System.out.printf("id: %s, numeroSocio: %s, nombre: %s\n",o.getId(),o.getNumeroSocio(),o.getNombreCompleto());
        });
        // numero total de registros
        System.out.printf("registros totales: %s\n",repoSocio.obtenerNumeroRegistros());
        // listar registros paginados
        repoSocio.obtenerRegistros(1,2).forEach(o->{
            System.out.printf("id: %s, numeroSocio: %s, nombre: %s%n",o.getId(),o.getNumeroSocio(),o.getNombreCompleto());
        });
        System.out.println();
        // listar registros ordenados por apellido paterno
        repoSocio.obtenerRegistros("ap",FormasDeOrden.DESC).forEach(o->{
            System.out.printf("id: %s, numeroSocio: %s, nombre: %s%n",o.getId(),o.getNumeroSocio(),o.getNombreCompleto());
        });
        System.out.println();
        // agregar otro socio
        repoSocio.crearRegistro(new Socio("0005","Alberto","Marquez","Pérez"));
        repoSocio.obtenerRegistros().forEach(o->{
            System.out.printf("id: %s, numeroSocio: %s, nombre: %s\n",o.getId(),o.getNumeroSocio(),o.getNombreCompleto());
        });
        System.out.println();
        // modificación de registro
        Socio sociomodi = repoSocio.obtenerRegistroPorId(6);
        sociomodi.setAp("Vergara");
        repoSocio.modificarRegistro(sociomodi);
        repoSocio.obtenerRegistros().forEach(o->{
            System.out.printf("id: %s, numeroSocio: %s, nombre: %s\n",o.getId(),o.getNumeroSocio(),o.getNombreCompleto());
        });
        System.out.println();
        // eliminación de socio
        repoSocio.eliminarRegistro(6);
        repoSocio.obtenerRegistros().forEach(o->{
            System.out.printf("id: %s, numeroSocio: %s, nombre: %s\n",o.getId(),o.getNumeroSocio(),o.getNombreCompleto());
        });

    }

}

