package repositorio.enumeraciones;

public enum FormasDeOrden {

    ASC("asc"),
    DESC("desc");

    private final String orden;

    FormasDeOrden(String orden){
        this.orden = orden;
    }

    @Override
    public String toString(){
        return orden;
    }

}
