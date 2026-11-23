package repositorio;

import excepciones.RepositorioException;
import excepciones.SocioNoEncontradoException;
import modelo.personas.Socio;

public class SocioRepositorio extends AbstractaRepositorio<Socio> {

    @Override
    public void modificarRegistro(Socio obj) throws SocioNoEncontradoException {

        Socio search = buscarOriginal(obj.getId());

        if( search == null)
            throw new SocioNoEncontradoException(obj.getId());

        search.setNombres(obj.getNombres());
        search.setAp(obj.getAp());
        search.setAm(obj.getAm());
        search.setEdad(obj.getEdad());

    }

    @Override
    public void crearRegistro(Socio obj) throws RepositorioException {

        if( obj == null )
            throw new RepositorioException("ERROR - el socio referenciado es nulo");

        for(Socio s: data){
            if( s.getNumeroSocio().equals(obj.getNumeroSocio()) )
                throw new RepositorioException("ERROR - ya existe un socio con el número de socio referenciado");
        }

        super.crearRegistro(obj);
    }

    @Override
    public int comparar(String campo, Socio obj0, Socio obj1) {

        int comparacion = 0;

        switch(campo){
            case "nombres" -> {
                comparacion = COLLATOR.compare(obj0.getNombres(),obj1.getNombres());
            }
            case "ap" -> {
                comparacion = COLLATOR.compare(obj0.getAp(),obj1.getAp());
            }
            case "am" -> {
                comparacion = COLLATOR.compare(obj0.getAm(),obj1.getAm());
            }
            case "edad" -> {
                comparacion = obj0.getEdad().compareTo(obj1.getEdad());
            }
            case "numeroSocio" -> {
                comparacion = COLLATOR.compare(obj0.getNumeroSocio(),obj1.getNumeroSocio());
            }
        }

        return comparacion;
    }


}
