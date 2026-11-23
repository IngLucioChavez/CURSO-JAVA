package repositorio;

import excepciones.MaterialNoEncontradoException;
import excepciones.RepositorioException;
import modelo.materiales.Material;

public class MaterialRepositorio extends AbstractaRepositorio<Material>{


    @Override
    public void modificarRegistro(Material obj) throws RepositorioException, MaterialNoEncontradoException {

        Material search = buscarOriginal(obj.getId());

        if( search == null )
            throw new MaterialNoEncontradoException(obj.getId());
        if( search.getClass() != obj.getClass() )
            throw new RepositorioException("ERROR - las clases son diferentes");

        search.actualizarDesde(obj);

    }

    @Override
    public int comparar(String campo, Material obj0, Material obj1) {

        int comparacion = 0;

        switch(campo){
            case "titulo" ->{
                comparacion = COLLATOR.compare(obj0.getTitulo(),obj1.getTitulo());
            }
            case "anio" ->{
                comparacion = obj0.getAnio().compareTo(obj1.getAnio());
            }
            case "genero" ->{
                comparacion = COLLATOR.compare(obj0.getGenero().toString(),obj1.getGenero().toString());
            }

        }

        return comparacion;
    }
}
