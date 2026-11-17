package servicios;

import modelo.Prestamo;
import modelo.interfaces.Prestable;
import modelo.interfaces.Renovable;
import modelo.materiales.Material;
import modelo.personas.Socio;
import repositorio.MaterialRepositorio;
import repositorio.PrestamoRepositorio;
import repositorio.SocioRepositorio;
import repositorio.interfaces.GeneralRepositorioInt;

import java.util.Collections;
import java.util.List;

public class BibliotecaServicio {

    GeneralRepositorioInt<Socio> sociosRepo;
    GeneralRepositorioInt<Prestamo> prestamosRepo;
    GeneralRepositorioInt<Material> materialesRepo;

    public BibliotecaServicio(GeneralRepositorioInt<Socio> sociosRepo, GeneralRepositorioInt<Prestamo> prestamosRepo, GeneralRepositorioInt<Material> materialesRepo){
        this.sociosRepo = sociosRepo;
        this.prestamosRepo = prestamosRepo;
        this.materialesRepo = materialesRepo;
    }

    private int materialesPrestados(int socioId){

        int materialesPrestados = 0;

        for(Prestamo p: prestamosRepo.obtenerRegistros()){

            if( p.getFechaDevolucion() != null ) continue;

            if( p.getSocio().getId().equals(socioId) ){
                materialesPrestados += p.getMateriales().size();
            }

        }

        return materialesPrestados;
    }

    private boolean materialDisponible(Integer idMaterial){

        for(Prestamo p: prestamosRepo.obtenerRegistros()){

            if( p.getFechaDevolucion() != null ) continue;

            for(Material m: p.getMateriales()){

                if( idMaterial.equals(m.getId()) )
                    return false;

            }

        }

        return true;
    }

    public Prestamo prestar(int socioId, List<Integer> materialesIds, Long dias){

        //existencia de socio
        boolean existeSocio = false;
        for(Socio s:sociosRepo.obtenerRegistros()){
            if( s.getId().equals(socioId) ){
                existeSocio = true;
                break;
            }
        }

        if( !existeSocio )
            return null;

        //validar que los ids de materiales no esten repetidos
        for(Integer idMaterial: materialesIds){
            if (Collections.frequency(materialesIds,idMaterial) != 1)
                return null;
        }

        //validar que los ids de materiales sean existentes y disponibles
        for(Integer idMaterial: materialesIds){
            //existencia de material
            boolean existe = false;
            for(Material material:materialesRepo.obtenerRegistros()){
                if( material.getId().equals(idMaterial) )
                    existe = true;
            }
            if( !existe ) return null;

            //disponibilidad de material
            if( !materialDisponible(idMaterial) ) return null;
        }

        //verificar que el socio no exceda el límite de préstamos con respecto a los que ya tiene y esta ingresando
        Socio socio = sociosRepo.obtenerRegistroPorId(socioId);
        if( (materialesPrestados(socioId) + materialesIds.size()) > socio.getLimitePrestamos() )
            return null;

        Prestamo prestamo = new Prestamo(socio,dias);
        for(Integer idMaterial: materialesIds){
            prestamo.addMaterial(materialesRepo.obtenerRegistroPorId(idMaterial));
        }

        prestamosRepo.crearRegistro(prestamo);

        return prestamo;
    }

    public boolean devolver(int prestamoId){

        Prestamo prestamo = prestamosRepo.obtenerRegistroPorId(prestamoId);
        if( prestamo == null )
            return false;

        if( !prestamo.devolver(prestamo.getMateriales()) )
            return false;

        if( !prestamosRepo.modificarRegistro(prestamo) )
            return false;

        return true;

    }

    public boolean renovar(int prestamoId, int materialId){

        Prestamo prestamo = prestamosRepo.obtenerRegistroPorId(prestamoId);
        if( prestamo == null )
            return false;

        boolean existeMaterial = false;
        Material material = null;
        for(Material m:prestamo.getMateriales()){
            if( m.getId().equals(materialId) ) {
                existeMaterial = true;
                material = m;
            }
        }
        if( !existeMaterial )
            return false;

        if( !(material instanceof Renovable) )
            return false;

        if( !(material instanceof Prestable) )
            return false;

        if( !(((Renovable) material).extenderDias(prestamo)) )
            return false;

        if( !prestamosRepo.modificarRegistro(prestamo) )
            return false;

        return true;
    }


}
