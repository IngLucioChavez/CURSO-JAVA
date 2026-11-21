package servicios;

import modelo.Prestamo;
import modelo.interfaces.Prestable;
import modelo.interfaces.Renovable;
import modelo.materiales.Material;
import modelo.personas.Socio;
import repositorio.interfaces.GeneralRepositorioInt;

import java.util.HashSet;
import java.util.List;

public class BibliotecaServicio {

    private final GeneralRepositorioInt<Socio> sociosRepo;
    private final GeneralRepositorioInt<Prestamo> prestamosRepo;
    private final GeneralRepositorioInt<Material> materialesRepo;

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

        // existencia de socio
        Socio socio = sociosRepo.obtenerRegistroPorId(socioId);
        if( socio == null )
            return null;
        // no se permiten ids vacíos
        if( materialesIds == null || materialesIds.isEmpty() )
            return null;

        //validar que los ids de materiales no esten repetidos
        if( hayIdsRepetidos(materialesIds) )
            return null;

        //validar que los ids de materiales sean existentes y disponibles
        if( !materialesPrestablesYDisponibles(materialesIds) )
            return null;

        //verificar que el socio no exceda el límite de préstamos con respecto a los que ya tiene y esta ingresando
        if( (materialesPrestados(socioId) + materialesIds.size()) > socio.getLimitePrestamos() )
            return null;

        Prestamo prestamo = new Prestamo(socio,dias);
        for(Integer idMaterial: materialesIds){
            prestamo.addMaterial(materialesRepo.obtenerRegistroPorId(idMaterial));
        }

        prestamosRepo.crearRegistro(prestamo);

        // regresar la copia del objeto guardado en el repo no el objeto creado en este metodo
        return prestamosRepo.obtenerRegistroPorId(prestamo.getId());
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

        Material material = null;
        for(Material m:prestamo.getMateriales()){
            if( m.getId().equals(materialId) ) {
                material = m;
                break;
            }
        }

        if(material == null )
            return false;

        if( !(material instanceof Renovable) )
            return false;

        if( !(((Renovable) material).extenderDias(prestamo)) )
            return false;

        return prestamosRepo.modificarRegistro(prestamo);
    }

    private boolean hayIdsRepetidos(List<Integer> ids){
        return new HashSet<>(ids).size() != ids.size();
    }

    private boolean materialesPrestablesYDisponibles(List<Integer> ids){
        for(Integer idMaterial: ids){
            Material material = materialesRepo.obtenerRegistroPorId(idMaterial);
            //existencia de material
            // material instanceof Prestable ya devuelve false cuando material es null
            /*if( material == null )
                return null;*/
            // que el material sea prestable y este disponible
            if( !(material instanceof Prestable) || !materialDisponible(idMaterial) )
                return false;
        }
        return true;
    }


}
