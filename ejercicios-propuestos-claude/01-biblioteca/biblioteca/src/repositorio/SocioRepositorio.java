package repositorio;

import modelo.personas.Socio;

public class SocioRepositorio extends AbstractaRepositorio<Socio> {

    @Override
    public boolean modificarRegistro(Socio obj) {

        Socio search = buscarOriginal(obj.getId());

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
