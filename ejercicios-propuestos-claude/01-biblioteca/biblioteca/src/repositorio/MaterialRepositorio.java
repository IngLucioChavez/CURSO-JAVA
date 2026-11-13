package repositorio;

import modelo.materiales.Material;

public class MaterialRepositorio extends AbstractaRepositorio<Material>{


    @Override
    public boolean modificarRegistro(Material obj) {

        Material search = buscarOriginal(obj.getId());

        if( search == null )
            return false;
        if( search.getClass() != obj.getClass() )
            return false;

        search.actualizarDesde(obj);
        return true;

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
