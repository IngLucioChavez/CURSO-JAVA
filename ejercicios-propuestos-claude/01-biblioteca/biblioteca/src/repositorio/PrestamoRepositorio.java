package repositorio;

import excepciones.RepositorioException;
import modelo.Prestamo;

public class PrestamoRepositorio extends AbstractaRepositorio<Prestamo>{
    @Override
    public void modificarRegistro(Prestamo obj) throws RepositorioException {

        Prestamo search = buscarOriginal(obj.getId());

        if( search == null )
            throw new RepositorioException("ERROR - el préstamo referencia no existe");

        search.actualizarDesde(obj);

    }

    @Override
    public int comparar(String campo, Prestamo obj0, Prestamo obj1) {

        int comparacion = 0;

        switch(campo){
            case "fechaInicial" ->
                comparacion = obj0.getFechaInicialPrestamo().compareTo(obj1.getFechaInicialPrestamo());
            case "fechaFinal" ->
                comparacion = obj0.getFechaFinalPrestamo().compareTo(obj1.getFechaFinalPrestamo());
            case "dias" ->
                comparacion = obj0.getDiasPrestamo().compareTo(obj1.getDiasPrestamo());
        }

        return comparacion;
    }
}
