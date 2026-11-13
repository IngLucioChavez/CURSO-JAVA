package interfaces;

public interface Imprimible {

    default String fichaTecnica(){
        return this.toString();
    }

    String obtenerTipo();

}
