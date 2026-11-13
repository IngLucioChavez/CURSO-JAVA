package repositorio;

import modelo.BaseEntity;
import repositorio.enumeraciones.FormasDeOrden;
import modelo.interfaces.Copiable;
import repositorio.interfaces.GeneralRepositorioInt;

import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public abstract class AbstractaRepositorio<T extends BaseEntity & Copiable<T>> implements GeneralRepositorioInt<T> {

    protected List<T> data;
    protected static final Collator COLLATOR = Collator.getInstance(Locale.forLanguageTag("es-MX"));

    protected AbstractaRepositorio(){
        data = new ArrayList<>();
    }

    private List<T> copiarLista(List<T> origen){
        List<T> resultado = new ArrayList<>();
        for(T registro: origen){
            resultado.add(registro.copiar());
        }
        return resultado;
    }

    protected T buscarOriginal(int idRegistro) {
        for(T registro: data){
            if( registro.getId() != null && registro.getId().equals(idRegistro) ) {
                return registro;
            }
        }
        return null;
    }

    @Override
    public int obtenerNumeroRegistros() {
        return data.size();
    }

    @Override
    public List<T> obtenerRegistros() {
        return copiarLista(data);
    }

    @Override
    public T obtenerRegistroPorId(int idRegistro) {

        T original = buscarOriginal(idRegistro);
        return original == null ? null : original.copiar();

    }

    @Override
    public boolean eliminarRegistro(int idRegistro) {

        T obj = buscarOriginal(idRegistro);
        if( obj == null )
            return false;
        data.remove(obj);
        return true;

    }

    @Override
    public boolean crearRegistro(T obj) {

        if( data.contains(obj) || obj == null )
            return false;
        data.add(obj.copiar());

        return true;
    }

    @Override
    public List<T> obtenerRegistros(int pagina, int numRegistros) {
        int desde = (pagina - 1) * numRegistros;

        if( pagina < 1 || numRegistros < 1 || desde > data.size() )
            return List.of();

        int hasta = Math.min(desde + numRegistros, data.size());

        return copiarLista(data.subList(desde,hasta));
    }

    @Override
    public List<T> obtenerRegistros(String campo, FormasDeOrden orden) {

        List<T> lista = new ArrayList<>(data);

        lista.sort((a,b) -> orden == FormasDeOrden.ASC
                    ? comparar(campo,a,b)
                    : comparar(campo,b,a)
                );

        return copiarLista(lista);
    }

}
