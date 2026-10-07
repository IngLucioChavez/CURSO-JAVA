package mamiferos;

import mamiferos.tipos_mamiferos.Felino;

public class Tigre extends Felino {

    private String especie;

    public Tigre(){
        especie = "sin especie";
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    @Override
    public String comer() {
        return String.format("el TIGRE %s empieza a COMER",nombrePropio);
    }

    @Override
    public String correr() {
        return String.format("el TIGRE %s empieza a CORRER",nombrePropio);
    }

    @Override
    public String dormir() {
        return String.format("el TIGRE %s empieza a DORMIR",nombrePropio);
    }

    @Override
    public String comunicarse() {
        return String.format("el TIGRE %s empieza a COMUNICARSE de forma %s",nombrePropio,formaComunicarse);
    }

    @Override
    public String toString() {
        StringBuilder descripcion = new StringBuilder(String.format("===========\nTIGRE %s \n\n",nombrePropio));
        descripcion.append(super.toString());
        descripcion.append(String.format("mamiferos.Tigre.especie: %s \n",especie));
        return descripcion.toString();
    }
}
