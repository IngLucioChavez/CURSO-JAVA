package interfaces;

public interface Imprimible {

    default String fichaTécnica(){
        return this.toString();
    }

    String obtenerTipo();

}
