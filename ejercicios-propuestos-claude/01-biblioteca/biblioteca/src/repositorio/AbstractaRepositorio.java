package repositorio;

import modelo.BaseEntity;
import repositorio.enumeraciones.FormasDeOrden;
import repositorio.interfaces.GeneralRepositorioInt;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractaRepositorio<T extends BaseEntity> implements GeneralRepositorioInt<T> {

    protected List<T> data;

    protected AbstractaRepositorio(){
        data = new ArrayList<>();
    }

    @Override
    public int obtenerNumeroRegistros() {
        return data.size();
    }

    @Override
    public List<T> obtenerRegistros() {
        return List.copyOf(data);
    }

    @Override
    public T obtenerRegistroPorId(int idRegistro) {

        for(T registro: data){
            if( registro.getId() != null && registro.getId().equals(idRegistro) ) {
                return registro;
            }
        }

        return null;
    }

    @Override
    public boolean eliminarRegistro(int idRegistro) {

        T obj = obtenerRegistroPorId(idRegistro);
        if( obj == null )
            return false;
        data.remove(obj);
        return true;

    }

    @Override
    public boolean crearRegistro(T obj) {

        if( data.contains(obj) )
            return false;
        data.add(obj);

        return true;
    }

    @Override
    public List<T> obtenerRegistros(int pagina, int numRegistros) {
        int desde = (pagina - 1) * numRegistros;

        if( pagina < 1 || numRegistros < 1 || desde > data.size() )
            return List.of();

        int hasta = Math.min(desde + numRegistros, data.size());

        return List.copyOf(data.subList(desde,hasta));
    }

    @Override
    public List<T> obtenerRegistros(String campo, FormasDeOrden orden) {

        List<T> lista = new ArrayList<>(data);

        lista.sort((a,b) -> orden == FormasDeOrden.ASC
                    ? comparar(campo,a,b)
                    : comparar(campo,b,a)
                );

        return lista;
    }

}
