package repositorio.enumeraciones;

public enum FormasDeOrden {

    ASC("asc"),
    DESC("desc");

    private final String orden;

    FormasDeOrden(String orden){
        this.orden = orden;
    }

    public String getOrden(){
        return orden;
    }

}
