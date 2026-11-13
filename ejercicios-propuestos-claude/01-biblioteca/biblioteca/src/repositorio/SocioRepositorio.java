package repositorio;

import modelo.personas.Socio;

public class SocioRepositorio extends AbstractaRepositorio<Socio> {

    @Override
    public boolean modificarRegistro(Socio obj) {

        Socio search = obtenerRegistroPorId(obj.getId());

        if( search == null)
            return false;

        search.setNombres(obj.getNombres());
        search.setAp(obj.getAp());
        search.setAm(obj.getAm());
        search.setEdad(obj.getEdad());

        return true;
    }

    @Override
    public int comparar(String campo, Socio obj0, Socio obj1) {

        int comparacion = 0;

        switch(campo){
            case "nombres" -> {
                comparacion = obj0.getNombres().compareTo(obj1.getNombres());
            }
            case "ap" -> {
                comparacion = obj0.getAp().compareTo(obj1.getAp());
            }
            case "am" -> {
                comparacion = obj0.getAm().compareTo(obj1.getAm());
            }
            case "edad" -> {
                comparacion = obj0.getEdad().compareTo(obj1.getEdad());
            }
            case "numeroSocio" -> {
                comparacion = obj0.getNumeroSocio().compareTo(obj1.getNumeroSocio());
            }
        }

        return comparacion;
    }


}
