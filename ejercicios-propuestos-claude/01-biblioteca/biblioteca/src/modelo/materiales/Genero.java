package modelo.materiales;

public enum Genero {
    PROGRAMACION("programación"),
    FANTASIA("fantasia"),
    TERROR("terror"),
    CIENCIA("ciencia"),
    COSMOLOGIA("cosmología");

    private String genero;

    Genero(String genero){
        this.genero = genero;
    }

    @Override
    public String toString() {
        return genero;
    }
}
